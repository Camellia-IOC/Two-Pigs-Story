<template>
    <div class="header">
        <!-- 菜单 -->
        <el-menu :default-active="activeMenuItemIndex" class="menu-bar" mode="horizontal" :ellipsis="false"
            @select="handleMenuSelect">
            <div class="menu">
                <!-- logo -->
                <div>
                    <img style="width: 100px" src="@/assets/images/login_background.png" alt="Element logo" />
                </div>

                <!-- 菜单项 -->
                <div class="menu-item-list">
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '0' }" index="0"
                        @click="router.push('/home/index')">
                        <el-icon>
                            <icon-menu />
                        </el-icon>
                        <span>主页</span>
                    </el-menu-item>
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '1' }" index="1"
                        @click="router.push('/home/about')">
                        <el-icon>
                            <icon-menu />
                        </el-icon>
                        <span>关于我们</span>
                    </el-menu-item>
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '2' }" index="2"
                        @click="router.push('/home/wall')">
                        <el-icon>
                            <icon-menu />
                        </el-icon>
                        <span>照片墙</span>
                    </el-menu-item>
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '3' }" index="3"
                        @click="router.push('/home/message')">
                        <el-icon>
                            <ChatDotRound />
                        </el-icon>
                        <span>留言板</span>
                    </el-menu-item>
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '4' }" index="4"
                        @click="router.push('/home/map')">
                        <el-icon>
                            <location />
                        </el-icon>
                        <span>足迹地图</span>
                    </el-menu-item>
                    <el-menu-item :class="{ 'active-menu-item': activeMenuItemIndex == '5' }" index="5"
                        @click="router.push('/home/story')">
                        <el-icon>
                            <setting />
                        </el-icon>
                        <span>我们的故事</span>
                    </el-menu-item>
                </div>
            </div>

            <!-- 操作区 -->
            <div class="operation-bar">
                <a-avatar size="large" @click="router.push('/user')">
                    <template #icon>
                        <UserOutlined />
                    </template>
                </a-avatar>
                <el-button type="danger" @click="userLogout">退出登录</el-button>
            </div>
        </el-menu>
    </div>
</template>

<script lang="ts" setup>
    import { ref } from 'vue'
    import { useRouter } from 'vue-router'

    import { Menu as IconMenu, Location, Setting, ChatDotRound } from '@element-plus/icons-vue'
    import { UserOutlined } from '@ant-design/icons-vue';

    const router = useRouter();

    // 当前活跃菜单项
    const activeMenuItemIndex = ref<string>('0');

    // 菜单操作回调
    const handleMenuSelect = (key: string, keyPath: string[]) => {
        // console.log(key, keyPath)
        activeMenuItemIndex.value = key;
    }

    // 退出登录
    const userLogout = () => {
        router.push("/login");
    } 
</script>

<style lang="scss" scoped>
    .header {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100vw;
        height: 10vh;
        color: white;
        background-color: white;
    }

    .menu-bar {
        display: flex;
        justify-content: space-between;
        align-items: center;
        width: 100%;
        height: 100%;
        padding: 0 2vw;
        background-color: white;
    }

    .menu {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 2vw;
    }

    .menu-item-list {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .active-menu-item {
        scale: 1.05;
        background: white;
        border-bottom: 2px solid #409EFF;
        transition: scale 0.5s ease;
    }
</style>