<template>
  <RouterView />
</template>

<script setup lang="ts">
  import { RouterView } from 'vue-router'
</script>

<style>

  html,
  body {
    width: 100%;
    height: auto;
    margin: 0 auto;
    padding: 0;
    background-color: white;
  }

  #app {
    width: 100%;
    height: auto;
    margin: 0 auto;
    padding: 0;
    background-color: black;
  }

  /* 隐藏滚动条 */
  body::-webkit-scrollbar {
    display: none;
  }

  /* 消息提示框样式 */
  .notification-success {
    background-color: #d1edc4;
    width: 25vw;
    border-radius: 1vw;
  }

  .notification-warning {
    background-color: #f8e3c5;
    width: 25vw;
    border-radius: 1vw;
  }

  .notification-error {
    background-color: #fcd3d3;
    width: 25vw;
    border-radius: 1vw;
  }
</style>

<style scoped></style>
