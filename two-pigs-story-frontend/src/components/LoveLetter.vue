<template>
    <div class="letter-container">
        <div class="envelop">
            <div class="envelop__front-paper"></div>
            <div class="envelop__back-paper"></div>
            <div class="envelop__up-paper js-up-paper"></div>
            <div class="envelop__sticker js-sticker"></div>
            <div class="envelop__false-sticker"></div>
            <div class="envelop__content js-envelop-content">
                <div class="love-notes">
                    <div class="note js-note">
                        <div class="note__text">
                            <p>{{ letter_content_1 }}</p>
                        </div>
                    </div>
                    <div class="note js-note">
                        <div class="note__text">
                            <p>{{ letter_content_2 }}</p>
                        </div>
                    </div>
                    <div class="note js-note">
                        <div class="note__text">
                            <p>{{ letter_content_3 }}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" setup>
    import { ref } from 'vue'
    import $ from 'jquery'

    const letter_content_1 = ref('')
    const letter_content_2 = ref('')
    const letter_content_3 = ref('')

    const letter_1 = ref(
        `111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111`
    )
    const letter_2 = ref(
        `222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222`
    )
    const letter_3 = ref(
        `333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333`
    )

    // const startSpace = '        '

    // 信件内容显示
    let index = 0

    const displayLetter_1 = () => {
        letter_content_1.value += letter_1.value[index]
        index++
        if (index < letter_1.value.length) {
            setTimeout(displayLetter_1, 50)
        }
    }

    const displayLetter_2 = () => {
        letter_content_2.value += letter_2.value[index]
        index++
        if (index < letter_2.value.length) {
            setTimeout(displayLetter_2, 50)
        }
    }

    const displayLetter_3 = () => {
        letter_content_3.value += letter_3.value[index]
        index++
        if (index < letter_3.value.length) {
            setTimeout(displayLetter_3, 50)
        }
    }

    const showLetter = (letterIndex: number) => {
        index = 0
        switch (letterIndex) {
            case 1:
                // letter_content_2.value = "";
                // letter_content_3.value = "";
                if (letter_content_1.value == '') {
                    displayLetter_1()
                }
                break

            case 2:
                // letter_content_1.value = "";
                // letter_content_3.value = "";
                if (letter_content_2.value == '') {
                    displayLetter_2()
                }
                break

            case 3:
                // letter_content_1.value = "";
                // letter_content_2.value = "";
                if (letter_content_3.value == '') {
                    displayLetter_3()
                }
                break
        }
    }

    // 信件初始化
    function letterInit() {
        //Variables
        let mobile_media_query = window.matchMedia('(max-width: 400px)')
        let tablet_media_query = window.matchMedia('(min-width: 400px) and (max-width: 600px)')

        const notes = $('.js-note')

        //-> Function that resets the size of the notes.
        function recize_notes() {
            for (let i = 0; i < notes.length; i++) {
                if (notes[i].hasClass('active')) {
                    notes[i].removeClass('active')
                    gsap.set(notes[i], {
                        height: '30%',
                        clearProps: 'all'
                    })
                }
            }
        }

        //-> Main function that enables all the notes.
        function notes_ready() {
            gsap.to('.js-envelop-content', {
                height: '110%',
                duration: 0.5
            })

            notes.each(function (index: number, note: HTMLElement) {
                let $this = $(note)

                $this.on('click', function () {
                    if (mobile_media_query.matches) {
                        if ($this.hasClass('active')) {
                            $this.removeClass('active')
                            gsap.set($this, {
                                height: '30%',
                                clearProps: 'all'
                            })
                        } else {
                            notes.each(function (index: number, note: HTMLElement) {
                                let $this = $(note)
                                if ($this.hasClass('active')) {
                                    $this.removeClass('active')
                                    gsap.set($this, {
                                        height: '30%',
                                        clearProps: 'all'
                                    })
                                }
                            })
                            $this.addClass('active')
                            gsap.set($this, {
                                height: 125 + 40 * index + '%'
                            })
                        }
                    } else if (tablet_media_query.matches) {
                        if ($this.hasClass('active')) {
                            $this.removeClass('active')
                            gsap.set($this, {
                                height: '30%',
                                clearProps: 'all'
                            })
                        } else {
                            notes.each(function (index: number, note: HTMLElement) {
                                let $this = $(note)
                                if ($this.hasClass('active')) {
                                    $this.removeClass('active')
                                    gsap.set($this, {
                                        height: '30%',
                                        clearProps: 'all'
                                    })
                                }
                            })
                            $this.addClass('active')
                            gsap.set($this, {
                                height: 80 + 21 * index + '%'
                            })
                        }
                    } else {
                        if ($this.hasClass('active')) {
                            $this.removeClass('active')
                            gsap.set($this, {
                                height: '30%',
                                clearProps: 'all'
                            })
                        } else {
                            notes.each(function (index: number, note: HTMLElement) {
                                let $this = $(note)
                                if ($this.hasClass('active')) {
                                    $this.removeClass('active')
                                    gsap.set($this, {
                                        height: '30%',
                                        clearProps: 'all'
                                    })
                                }
                            })
                            $this.addClass('active')
                            showLetter(index + 1)
                            gsap.set($this, {
                                height: 70 + 20 * index + '%'
                            })
                        }
                    }
                })
            })
        }

        //-> Function that set up the up paper of the envelope.
        function set_up_paper() {
            var arr = [0, 0, 100, 0, 50, 61]
            gsap.set('.js-up-paper', {
                bottom: '97%',
                rotation: 180,
                zIndex: 200,
                clipPath:
                    'polygon(' +
                    arr[0] +
                    '%' +
                    arr[1] +
                    '%,' +
                    arr[2] +
                    '%' +
                    arr[3] +
                    '%,' +
                    arr[4] +
                    '%' +
                    arr[5] +
                    '%)',
                onComplete: notes_ready
            })
        }

        //-> Function that starts the up paper transition.
        function envelop_transition() {
            let envelop = $('.envelop')
            window.scrollTo({
                top: envelop.offset().top - ($(window).height() - envelop.height()),
                left: 0,
                behavior: 'smooth'
            })

            gsap.to('.js-up-paper', {
                bottom: '1%',
                duration: 0.25,
                onComplete: set_up_paper
            })
            $('.js-up-paper').off('click', envelop_transition)
            $('.js-up-paper').removeClass('cursor')
        }

        //-> Function that allows cut the sticker.
        function sticker() {
            gsap.set('.js-sticker', {
                width: '20%',
                left: '-80%'
            })
            document.body.classList.remove('scissors')
            $('.js-sticker').off('click', sticker)
            $('.js-up-paper').on('click', envelop_transition)
            $('.js-up-paper').addClass('cursor')
        }

        $('.js-sticker').on('click', sticker)

        window.onresize = function () {
            recize_notes()
        }
    }

    $(document).ready(function () {
        letterInit()
    })
</script>

<style lang="scss" scoped>
    .column-container {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .letter-container {
        @extend .column-container;
        width: 100%;
        min-height: 30rem;
        position: relative;
        margin: 5vh 0;

        //Colors
        $bg: #000;
        $tab-bg: #f9f9f9;
        $f-color: #ba9872;
        $s-color: #967b5c;
        $t-color: #a38564;
        $fo-color: #f9f9f9;
        $fi-color: #e2e2e2;

        //Mixins
        @mixin posAbsolute($p) {
            width: 100%;
            height: 100%;
            bottom: 0;
            left: 0;

            @if ($p==a) {
                position: absolute;
            }

            @else if($p==r) {
                position: relative;
            }
        }

        // General styles
        * {
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        //Styles
        .envelop {
            width: 45rem;
            height: 30rem;
            position: absolute;
            left: 0;
            right: 0;
            margin: auto;
            transition: margin-top 1s ease;

            &__front-paper {
                @include posAbsolute(a);
                border-radius: 0.7rem;
                border: 0.35rem solid $s-color;
                background-color: $f-color;
                clip-path: polygon(100% 0%, 50% 70%, 0% 0%, 0% 100%, 100% 100%);
                z-index: 300;
            }

            &__back-paper {
                @include posAbsolute(a);
                border-radius: 0.7rem;
                background-color: $s-color;
                clip-path: polygon(0% 0%, 100% 0%, 90% 100%, 0% 90%);
                z-index: 100;
            }

            &__up-paper {
                @include posAbsolute(r);
                border-radius: 0.7rem;
                background-color: $s-color;
                z-index: 400;
                clip-path: polygon(0% 0%, 100% 0%, 50% 81%);
            }

            &__sticker {
                width: 100%;
                height: 20%;
                position: absolute;
                margin: auto;
                top: 30%;
                left: 0;
                bottom: 0;
                right: 0;
                z-index: 400;
                background-image: url('https://www.freepnglogos.com/uploads/heart-png/emoji-heart-33.png');
                background-color: $fo-color;
                border: 0.3rem solid $fi-color;
                background-size: 2rem;
                background-position: center;

                @media (max-width: 400px) {
                    background-size: 1.2rem;
                }

                @media (min-width: 600px) {
                    height: 15%;
                }
            }

            &__false-sticker {
                width: 20%;
                height: 20%;
                position: absolute;
                margin: auto;
                top: 30%;
                left: 80%;
                bottom: 0;
                right: 0;
                z-index: 300;
                background-image: url('https://www.freepnglogos.com/uploads/heart-png/emoji-heart-33.png');
                background-color: $fo-color;
                border: 0.3rem solid $fi-color;
                background-size: 2rem;
                background-position: center;

                @media (max-width: 400px) {
                    background-size: 1.2rem;
                }

                @media (min-width: 600px) {
                    height: 15%;
                }
            }

            &__content {
                @include posAbsolute(a);
                z-index: 200;
            }
        }

        .love-notes {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .note {
            width: 95%;
            height: 30%;
            background-color: $tab-bg;
            position: absolute;
            overflow: hidden;
            transition:
                height 0.5s,
                opacity 0.25s;
            box-shadow: 0px 0px 5px 0px rgba(0, 0, 0, 0.75);

            &:nth-child(1) {
                bottom: 60%;
            }

            &:nth-child(2) {
                bottom: 40%;
            }

            &:nth-child(3) {
                bottom: 20%;
            }

            &:hover {
                cursor: pointer;
                height: 45%;
            }

            &__text {
                font-family: 'Sofia';
                padding: 1rem;

                p {
                    font-size: 0.9rem;
                    margin-bottom: 1rem;
                    text-align: center;

                    @media (min-width: 300px) and (max-width: 600px) {
                        font-size: 1.025rem;
                    }

                    @media (min-width: 600px) {
                        font-size: 0.6rem;
                    }
                }
            }
        }

        .scissors {
            cursor: url('https://i.postimg.cc/GtLCdKxR/sisors.png'), pointer;

            &:active {
                cursor: url('https://i.postimg.cc/GtXQ7WPZ/pngwing-com.png'), pointer;
            }
        }

        .cursor {
            cursor: pointer;
        }
    }
</style>