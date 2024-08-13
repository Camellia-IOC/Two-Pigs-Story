<template>
  <div class="container">
    <div class="carousel-area">
      <el-carousel :interval="4000" type="card" height="50vh">
        <el-carousel-item v-for="(item, index) in imagesList " :key="index">
          <el-image :src="item" fit="cover" :preview-src-list="[item]" preview-teleported hide-on-click-modal />
        </el-carousel-item>
      </el-carousel>
    </div>

    <!-- <div class="textcontainer">
            <span class="particletext hearts">Hearts</span>
        </div> -->

    <div class="element-container">
      <!-- 信件区 -->
      <h1 style="margin: 15vh 0;">来拆信吧</h1>
      <LoveLetter />

      <!-- 照片区 -->
      <PictureHeart />

      <!-- 拼图区 -->
      <PicturePuzzle />

      <!-- 刮奖区 -->
      <LuckyScratch />

      <!-- <div class="picture-display-container" style="flex-direction:row;">
                <img class="move-to-right test-image" src="@/assets/images/login_background.png" alt="test" />
                <img class="move-to-left test-image" src="@/assets/images/login_background.png" alt="test" />
            </div> -->
    </div>
  </div>
</template>

<script lang="ts" setup>
  import { ref } from 'vue'
  import $ from 'jquery'
  import gsap from 'gsap'
  import LoveLetter from '@/components/LoveLetter.vue'
  import PictureHeart from '@/components/PictureHeart.vue'
  import PicturePuzzle from '@/components/PicturePuzzle.vue'
  import LuckyScratch from '@/components/LuckyScratch.vue';

  const imagesList = ref<Array<string>>([
    '/images/picture_heart_images/1-6.jpg',
    '/images/picture_heart_images/2-5.jpg',
    '/images/picture_heart_images/3-2.jpg',
    '/images/picture_heart_images/4-7.jpg',
    '/images/picture_heart_images/5-6.jpg',
    '/images/picture_heart_images/6-1.jpg',
    '/images/picture_heart_images/7-5.jpg',
    '/images/picture_heart_images/8-3.jpg',
  ])

  $(document).ready(function () {
    $(window).on('scroll', function () {
      // 当前浏览器顶部坐标
      let top = $(window).scrollTop()

      // 视窗高度
      let viewHeight = $(window).height()

      // 动画施加对象列表
      let dom = $('.animation')
      dom.each(function (index: number, element: HTMLElement) {
        let $this = $(element)

        // 当前元素顶部坐标
        let offset = $this.offset().top

        if (top + viewHeight > offset) {
          $this.css('opacity', 1)
          $this.addClass($this.data('animation'))
        } else {
          $this.css('opacity', 0)
          $this.removeClass($this.data('animation'))
        }
      })

      let test = $('#test')
      test.each(function (index: number, element: HTMLElement) {
        let $this = $(element)

        $this.css('transform', `rotate(${top % 360}deg)`)
      })

      let moveRightItems = $('.move-to-right')
      moveRightItems.each(function (index: number, element: HTMLElement) {
        let $this = $(element)
        let offset = $this.offset().top

        if (top + viewHeight > offset) {
          $this.css('transform', `translateX(${((offset - top) / viewHeight) * 100}vw)`)
        }
      })
    })

    //   $.rnd = function (m: any, n: any) {
    //       m = parseInt(m);
    //       n = parseInt(n);
    //       return Math.floor(Math.random() * (n - m + 1)) + m;
    //   }

    // function heartDecoration() {
    //     let elements = $(".particletext.hearts");
    //     elements.each(function (index: number, element: HTMLElement) {
    //         let $this = $(element);
    //         console.log($this)
    //         var heartcount = ($this.width() / 50) * 5;
    //         for (var i = 0; i <= heartcount; i++) {
    //             var size = ($.rnd(60, 120) / 10);
    //             $this.append('<span class="particle" style="top:' + $.rnd(20, 80) + '%; left:' + $.rnd(0, 95) + '%;width:' + size + 'px; height:' + size + 'px;animation-delay: ' + ($.rnd(0, 30) / 10) + 's;"></span>');
    //         }
    //     });
    // }
  })
</script>

<style lang="scss" scoped>
  .row-container {
    display: flex;
    align-items: center;
  }

  .column-container {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .container {
    @extend .column-container;

    justify-content: none;
    width: 100%;
    min-height: 90vh;
    padding: 5vh 0;

    .carousel-area {
      width: 90%;
      height: 50vh;
    }
  }

  .el-carousel__item {
    @extend .row-container;
    justify-content: center;
    border-radius: 3vh;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n + 1) {
    background-color: #d3dce6;
  }

  .display-image {
    object-fit: cover;
  }

  .element-container {
    @extend .column-container;
    width: 100%;
  }

  .move-to-right {
    position: absolute;
    left: 0;
    transition: all 1s linear;
  }

  // 文字装饰
  // .textcontainer {
  //     padding: 40px 0;
  //     text-align: center;
  // }

  // .particletext {
  //     text-align: center;
  //     font-size: 48px;
  //     position: relative;

  //     &.hearts {
  //         >.particle {
  //             opacity: 0;
  //             position: absolute;
  //             background-color: rgba(204, 42, 93, 1);
  //             animation: hearts 3s ease-in infinite;

  //             &:before,
  //             &:after {
  //                 position: absolute;
  //                 content: '';
  //                 border-radius: 100px;
  //                 top: 0px;
  //                 left: 0px;
  //                 width: 100%;
  //                 height: 100%;
  //                 background-color: rgba(204, 42, 93, 1);
  //             }

  //             &:before {
  //                 transform: translateX(-50%);
  //             }

  //             &:after {
  //                 transform: translateY(-50%);
  //             }
  //         }
  //     }
  // }

  // @keyframes hearts {
  //     0% {
  //         opacity: 0;
  //         transform: translate(0, 0%) rotate(45deg);
  //     }

  //     20% {
  //         //show and hint at moving
  //         opacity: 0.8;
  //         transform: translate(0, -20%) rotate(45deg);
  //     }

  //     100% {
  //         opacity: 0;
  //         transform: translate(0, -1000%) rotate(45deg); //Big hearts move faster
  //     }
  // }
</style>
