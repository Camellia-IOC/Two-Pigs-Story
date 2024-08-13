<template>
  <div class="container">
    <!-- 导航栏 -->
    <Navbar />

    <!-- 主内容 -->
    <div class="container-main">
      <Transition name="MainFade" mode="out-in">
        <RouterView />
      </Transition>
    </div>

    <!-- 页脚 -->
    <!-- <div class="footer">Footer</div> -->
  </div>
</template>

<script setup lang="ts">
  import { RouterView } from 'vue-router'
  import Navbar from '@/components/TopNavBar.vue'
</script>

<style scoped>
  .container {
    height: 100vh;
    width: 100vw;
    color: black;
    background-color: white;
  }

  .container-main {
    width: 100%;
    min-height: 90vh;
  }

  .footer {
    color: white;
    height: 20vh;
    background-color: black;
  }

  /* 过渡动画 */
  .MainFade-enter-from,
  .MainFade-leave-to {
    transform: translateX(20px);
    opacity: 0;
  }

  .MainFade-enter-to,
  .MainFade-leave-from {
    opacity: 1;
  }

  .MainFade-enter-active {
    transition: all 0.7s ease;
  }

  .MainFade-leave-active {
    transition: all 0.3s cubic-bezier(1, 0.6, 0.6, 1);
  }
</style>