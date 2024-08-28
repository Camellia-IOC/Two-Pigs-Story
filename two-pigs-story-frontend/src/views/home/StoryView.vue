<template>
    <div class="container">
        <!-- 开场动画 -->
        <div class="book-start-left" :class="{ 'book-start-left-leave': isStoryStart }"></div>
        <div class="book-start-right" :class="{ 'book-start-right-leave': isStoryStart }"></div>
        <el-button class="book-start-button" :class="{ 'book-start-button-leave': isStoryStart }"
            @click="isStoryStart = true" type="primary" round plain>开始</el-button>

        <!-- 故事内容 -->
        <div class="story-content">
            <!-- 页面切换 -->
            <el-affix>
                <el-button class="btn-page-switch-left" type="info" round plain :disabled="currentStoryPage == 0"
                    @click="currentStoryPage--">
                    <el-icon>
                        <ArrowLeftBold />
                    </el-icon>
                </el-button>
            </el-affix>
            <el-affix>
                <el-button class="btn-page-switch-right" type="info" round plain
                    :disabled="currentStoryPage == storyPageNum - 1" @click="currentStoryPage++">
                    <el-icon>
                        <ArrowRightBold />
                    </el-icon>
                </el-button>
            </el-affix>

            <!-- 故事页 -->
            <div class="story-page-item story-page-0" v-show="currentStoryPage == 0">
                <el-empty description="暂无内容" />
            </div>

            <div class="story-page-item story-page-1" v-show="currentStoryPage == 1">
                <el-empty description="暂无内容" />
                <button id="test" style="position: absolute; top: 50%; left: 50%;">test</button>
            </div>

            <div class="story-page-item story-page-2" v-show="currentStoryPage == 2">
                <el-empty description="暂无内容" />
            </div>

            <div class="story-page-item story-page-3" v-show="currentStoryPage == 3">
                <el-empty description="暂无内容" />
            </div>

            <div class="story-page-item story-page-4" v-show="currentStoryPage == 4">
                <el-empty description="暂无内容" />
            </div>
        </div>
    </div>
</template>

<script setup lang="ts">
    import { ref } from 'vue';
    import $ from 'jquery'
    import { ArrowLeftBold, ArrowRightBold } from '@element-plus/icons-vue'

    // 故事开始标志位   
    const isStoryStart = ref<boolean>(false);

    // 故事总页数
    const storyPageNum = 5;

    // 当前故事页数
    const currentStoryPage = ref<number>(0);

    $(document).ready(function () {
        $('#test').addClass("bounceInLeft");
    }); 
</script>

<style scoped>
    .bounceInLeft {
        animation: bounceInLeft 2s ease-in;
    }

    .container {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 100%;
        height: 90vh;
        position: relative;
    }

    .book-start-left {
        width: 50%;
        height: 100%;
        background-color: #EBEBEB;
        position: absolute;
        left: 0;
        top: 0;
        z-index: 10;
        transition: all 2s ease;
    }

    .book-start-left-leave {
        transform: translateX(-50vw);
        opacity: 20;
    }

    .book-start-right {
        width: 50%;
        height: 100%;
        background-color: #EBEBEB;
        position: absolute;
        right: 0;
        top: 0;
        z-index: 10;
        transition: all 2s ease;
    }

    .book-start-right-leave {
        transform: translateX(50vw);
        opacity: 20;
    }

    .book-start-button {
        position: absolute;
        left: 50%;
        top: 50%;
        z-index: 10;
        transform: translate(-50%, -50%);
        transition: all 2s ease;
    }

    .book-start-button-leave {
        opacity: 0;
        visibility: hidden;
    }

    .story-content {
        width: 100%;
        height: 100%;
    }

    .story-page-item {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 100%;
        height: 100%;
        position: relative;
        background-color: white;
    }

    .btn-page-switch-left {
        width: 5vh;
        height: 5vh;
        position: absolute;
        top: 50%;
        left: 2%;
        z-index: 5;
        transition: all 0.5s ease;
    }

    .btn-page-switch-left:hover {
        scale: 1.1;
    }

    .btn-page-switch-right {
        width: 5vh;
        height: 5vh;
        position: absolute;
        top: 50%;
        right: 2%;
        z-index: 5;
        transition: all 0.5s ease;
    }

    .btn-page-switch-right:hover {
        scale: 1.1;
    }
</style>