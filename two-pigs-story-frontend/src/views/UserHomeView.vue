<template>
    <div class="container">
        <!-- 导航栏 -->
        <Navbar />

        <div class="config-container">
            <div class="config-card">

            </div>

            <div class="config-card">

            </div>
        </div>
    </div>
</template>

<script lang="ts" setup>
    import { ref } from "vue";
    import $ from "jquery";

    import Navbar from '@/components/TopNavBar.vue'

    $(document).ready(() => {
        $(".config-container").addClass("animate__animated animate__slideInUp");
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
        min-height: 100vh;
        background-color: $main-background-color;
    }

    .config-container {
        @extend .column-container;

        justify-content: space-around;
        width: 100%;
        gap: 5vh;
        padding: 5vh;

        .config-card {
            @extend .column-container;

            width: 45%;
            min-height: 40vh;
            background-color: white;
            border-radius: 3vh;
        }
    }
</style>