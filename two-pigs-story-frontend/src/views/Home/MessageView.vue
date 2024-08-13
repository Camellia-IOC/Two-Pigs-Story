<template>
    <div class="container">
        <div id="message-card-container" class="message-card-container">
            <div class="message-card display-message-card" style="left: 100%;">
                <a-avatar :size="64">
                    <template #icon>
                        <UserOutlined />
                    </template>
                </a-avatar>
                <p>{{ messageList[0] }}</p>
            </div>
        </div>

        <div class="message-input-container">
            <input type="text" placeholder="Type your message here...">
            <el-button type="primary" round plain>留言</el-button>
        </div>
    </div>
</template>

<script lang="ts" setup>
    import { ref } from 'vue';
    import $ from 'jquery';
    import { UserOutlined } from '@ant-design/icons-vue';

    const timeID = ref();

    const containerWidth = ref(0);
    const cardWidth = ref(0);
    const cardHeight = ref(0);

    const messageIndex = ref(0);
    const messageList = ref<Array<string>>(["我爱邓钰婕", "老婆天下第一美", "爱你老婆", "老婆你爱我吗"])

    function displayCard() {
        $('.display-message-card').each(function (index: number, element: HTMLElement) {
            // if (element.getBoundingClientRect().right > 0) {
            //     $(element).css('left', `${element.getBoundingClientRect().left - cardWidth.value}px`);

            //     if (element.getBoundingClientRect().left < 0) {
            //         console.log('append');
            //         let newElement = $("<div></div>");
            //         newElement.css('left', `${$(window).width}`);
            //         newElement.css('width', `${cardWidth.value}px`);
            //         newElement.css('height', `${cardHeight.value}px`);
            //         newElement.css('margin', `0 ${containerWidth.value * 0.01}px`);
            //         newElement.css('background-color', 'white');
            //         newElement.appendTo("#message-card-container");
            //         newElement.addClass("display-message-card");
            //     }
            // }
            // else {
            //     console.log('remove');
            //     $(element).remove();
            // }

            if (element.getBoundingClientRect().right > 0) {
                $(element).css('left', `${$(element).position().left - (cardWidth.value / 2)}px`);

                if (element.getBoundingClientRect().right < containerWidth.value && element.getBoundingClientRect().left > (containerWidth.value - cardWidth.value * 1.5)) {
                    // 添加新元素
                    messageIndex.value = (messageIndex.value + 1) % (messageList.value.length - 1);
                    let newElement = $(`<div></div>`);
                    $('<a-avatar :size="64"><template #icon><UserOutlined /></template></a-avatar>').appendTo(newElement);
                    $(`<p>${messageList.value[messageIndex.value]}</p>`).appendTo(newElement);
                    newElement.css('display', 'flex');
                    newElement.css('flex-direction', 'column');
                    newElement.css('justify-content', 'center');
                    newElement.css('align-items', 'center');
                    newElement.css('position', 'absolute');
                    newElement.css('transition', 'left 1s linear');
                    newElement.css('left', `${containerWidth.value}px`);
                    newElement.css('width', `${cardWidth.value}px`);
                    newElement.css('height', `${cardHeight.value}px`);
                    newElement.css('margin', `0 ${containerWidth.value * 0.01}px`);
                    newElement.css('background-color', 'white');
                    newElement.css('border-radius', '3vh');
                    newElement.css('box-shadow', '0 10px 10px rgba(0, 0.15, 0, 0.15)')
                    newElement.appendTo("#message-card-container");
                    newElement.addClass("display-message-card");
                    console.log("append");
                }
            }
            else if (element.getBoundingClientRect().right < 0) {
                $(element).remove();
                console.log("remove");
            }
        });
    }

    function displayPause() {
        clearInterval(timeID.value);
    }

    $(document).ready(() => {
        containerWidth.value = $('#message-card-container').width();
        cardWidth.value = $('#message-card-container').width() * 0.18;
        cardHeight.value = $('#message-card-container').height() * 0.8;

        timeID.value = setInterval(() => {
            displayCard();
        }, 1000);
    }); 
</script>

<style lang="scss" scoped>
    $main-background-color: #E5EAF3;

    .row-container {
        display: flex;
        flex-direction: row;
        align-items: center;
    }

    .column-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .container {
        @extend .column-container;

        width: 100%;
        height: 90vh;
        background-color: $main-background-color;
    }

    .message-card-container {
        @extend .row-container;

        justify-content: center;
        width: 100%;
        height: 70%;
        position: relative;

        .message-card {
            @extend .column-container;

            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            width: 18%;
            min-height: 80%;
            margin: 0 1%;
            background-color: white;
            border-radius: 3vh;
            position: absolute;
            transition: left 1s linear;
            box-shadow: 0 10px 10px rgba(0, 0.15, 0, 0.15);
        }
    }

    .display-message-card {
        // background-color: white;
        // border-radius: 3vh;
        // position: absolute;
        // transition: left 1s linear;
    }

    .message-input-container {
        @extend .column-container;

        width: 100%;
        height: 30%;
    }
</style>