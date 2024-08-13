<template>
    <div class="container">
        <audio class="audio-player" autoplay controls loop preload="auto">
            <source src="./resource/Lenka - Lucky.mp3" type="audio/mp3" />
        </audio>
        <div id="main">
            <div id="wrap">
                <div id="text">
                    <div id="code">

                    </div>
                </div>
                <div id="clock-box">
                    <span class="STYLE1"></span>
                    <font color="#33CC00">陪伴你的时光</font>
                    <span class="STYLE1">已经是……</span>
                    <div id="clock"></div>
                </div>
                <canvas id="canvas" width="1100" height="680"></canvas>
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
    import $ from 'jquery';
    import "@/dependency/js/love.js";

    // variables
    // var $win = $(window);
    // var clientWidth = $win.width();
    // var clientHeight = $win.height();

    // $(window).resize(function () {
    //     var newWidth = $win.width();
    //     var newHeight = $win.height();
    //     if (newWidth != clientWidth && newHeight != clientHeight) {
    //         location.replace(location);
    //     }
    // });

    (function ($) {
        $.fn.typewriter = function () {
            this.each(function () {
                var $ele = $(this), str = $ele.html(), progress = 0;
                $ele.html('');
                var timer = setInterval(function () {
                    var current = str.substr(progress, 1);
                    if (current == '<') {
                        progress = str.indexOf('>', progress) + 1;
                    } else {
                        progress++;
                    }
                    $ele.html(str.substring(0, progress) + (progress & 1 ? '_' : ''));
                    if (progress >= str.length) {
                        clearInterval(timer);
                    }
                }, 75);
            });
            return this;
        };
    })(jQuery);

    function timeElapse(date: any) {
        var current = new Date();
        var timeDifference = current.getTime() - date.getTime(); // 计算当前时间与给定日期的时间差（毫秒）
        var seconds = Math.floor(timeDifference / 1000); // 转换为秒数

        var days = Math.floor(seconds / (3600 * 24)); // 计算天数
        seconds = seconds % (3600 * 24); // 剩余的秒数

        var hours = Math.floor(seconds / 3600); // 计算小时数
        seconds = seconds % 3600; // 剩余的秒数

        var minutes = Math.floor(seconds / 60); // 计算分钟数
        seconds = seconds % 60; // 剩余的秒数

        var result = "第 <span class=\"digit\">" + days + "</span> 天 <span class=\"digit\">" + hours + "</span> 小时 <span class=\"digit\">" + minutes + "</span> 分钟 <span class=\"digit\">" + seconds + "</span> 秒";
        $("#clock").html(result);
    }

    $(document).ready(function () {
        var canvas = $('#canvas');

        if (!canvas[0].getContext) {
            $("#error").show();
            return false;
        }

        var width = canvas.width();
        var height = canvas.height();

        canvas.attr("width", width);
        canvas.attr("height", height);

        var opts = {
            seed: {
                x: width / 2 - 20,
                color: "rgb(190, 26, 37)",
                scale: 2
            },
            branch: [
                [535, 680, 570, 250, 500, 200, 30, 100, [
                    [540, 500, 455, 417, 340, 400, 13, 100, [
                        [450, 435, 434, 430, 394, 395, 2, 40]
                    ]],
                    [550, 445, 600, 356, 680, 345, 12, 100, [
                        [578, 400, 648, 409, 661, 426, 3, 80]
                    ]],
                    [539, 281, 537, 248, 534, 217, 3, 40],
                    [546, 397, 413, 247, 328, 244, 9, 80, [
                        [427, 286, 383, 253, 371, 205, 2, 40],
                        [498, 345, 435, 315, 395, 330, 4, 60]
                    ]],
                    [546, 357, 608, 252, 678, 221, 6, 100, [
                        [590, 293, 646, 277, 648, 271, 2, 80]
                    ]]
                ]]
            ],
            bloom: {
                num: 700,
                width: 1080,
                height: 650,
            },
            footer: {
                width: 1200,
                height: 5,
                speed: 10,
            }
        };

        var tree = new Tree(canvas[0], width, height, opts);
        var seed = tree.seed;
        var foot = tree.footer;
        var hold = 1;

        canvas.click(function (e: any) {
            var offset = canvas.offset(), x, y;
            x = e.pageX - offset.left;
            y = e.pageY - offset.top;
            if (seed.hover(x, y)) {
                hold = 0;
                canvas.unbind("click");
                canvas.unbind("mousemove");
                canvas.removeClass('hand');
            }
        }).mousemove(function (e: any) {
            var offset = canvas.offset(), x, y;
            x = e.pageX - offset.left;
            y = e.pageY - offset.top;
            canvas.toggleClass('hand', seed.hover(x, y));
        });

        function sleep(ms: any) {
            return new Promise(resolve => setTimeout(resolve, ms));
        }

        async function seedAnimate() {
            seed.draw();
            while (hold) {
                await sleep(10);
            }
            while (seed.canScale()) {
                seed.scale(0.95);
                await sleep(10);
            }
            while (seed.canMove()) {
                seed.move(0, 2);
                foot.draw();
                await sleep(10);
            }
        }

        // 以同样的方式转换其他动画函数...
        // growAnimate
        async function growAnimate() {
            let continueGrowing = true;
            while (continueGrowing) {
                tree.grow();
                await sleep(10);
                continueGrowing = tree.canGrow();
            }
        }

        // flowAnimate
        async function flowAnimate() {
            let continueFlowering = true;
            while (continueFlowering) {
                tree.flower(2);
                await sleep(10);
                continueFlowering = tree.canFlower();
            }
        }

        // moveAnimate
        async function moveAnimate() {
            tree.snapshot("p1", 240, 0, 610, 680);
            let continueMoving = true;
            while (continueMoving) {
                foot.draw();
                await sleep(10);
                continueMoving = tree.move("p1", 500, 0);
            }
            foot.draw();
            tree.snapshot("p2", 500, 0, 610, 680);

            // 设置背景图片并恢复画布背景
            const canvasBg = tree.toDataURL('image/png');
            const $canvasParent = $('#canvas').parent();
            $canvasParent.css("background", `url(${canvasBg})`);
            $('#canvas').css("background", "#ffe");
            await sleep(300);
            $canvasParent.css("background", "none");
            $('#canvas').css("background", "");
        }

        // jumpAnimate
        async function jumpAnimate() {
            let flag = true;
            while (flag) {
                tree.ctx.clearRect(0, 0, width, height);
                tree.jump();
                foot.draw();
                await sleep(25);
            }
        }

        // 由于 textAnimate 包含无限循环，我们将其转换为一个自运行的异步函数
        function textAnimate() {
            const together = new Date(2021, 1, 16, 0, 0, 0, 0); // 注意月份是从 0 开始的

            // $("#code").show().typewriter();
            $("#clock-box").fadeIn(500);

            (async () => {
                let flag = true;
                while (flag) { // 这里可能需要一个退出条件
                    timeElapse(together);
                    await sleep(1000);
                }
            })();
        }

        // 将 runAsync 函数转换为标准的 async 函数
        async function runAsync() {
            await seedAnimate();
            await growAnimate();
            await flowAnimate();
            await moveAnimate();

            textAnimate(); // textAnimate 是自运行的，不需要 await

            await jumpAnimate();
        }

        // 最后，调用 runAsync 函数来启动动画
        runAsync();
    });
</script>

<style lang="scss" scoped>
    .container {
        height: 90vh;
        margin: 0;
        padding: 0;
        background: white;
        font-size: 14px;
        font-family: '微软雅黑', '宋体', sans-serif;
        color: #231F20;
        position: relative;
        overflow: auto
    }

    .audio-player {
        position: absolute;
        top: 80%;
        left: 2%;
    }

    a {
        color: #000;
        font-size: 14px;
    }

    #main {
        width: 100%;
    }

    #wrap {
        position: relative;
        margin: 0 auto;
        width: 1100px;
        height: 680px;
        margin-top: 10px;
    }

    #text {
        width: 400px;
        height: 425px;
        left: 60px;
        top: 80px;
        position: absolute;
    }

    #code {
        display: none;
        font-size: 16px;
    }

    #clock-box {
        position: absolute;
        left: 60px;
        top: 550px;
        font-size: 28px;
        display: none;
    }

    #clock-box a {
        font-size: 28px;
        text-decoration: none;
    }

    #clock {
        margin-left: 48px;
    }

    #clock .digit {
        font-size: 64px;
    }

    #canvas {
        margin: 0 auto;
        width: 1100px;
        height: 680px;
    }

    #error {
        margin: 0 auto;
        text-align: center;
        margin-top: 60px;
        display: none;
    }

    .hand {
        cursor: pointer;
    }

    .say {
        margin-left: 32px;
    }

    .space {
        margin-right: 150px;
    }
</style>