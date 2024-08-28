import {createRouter, createWebHistory} from 'vue-router'
import LoginView from '../views/LoginView.vue'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            redirect: '/login'
        },
        {
            path: '/login',
            name: 'login',
            component: LoginView
        },
        {
            path: '/birthday',
            name: 'birthday',
            component: () => import('@/views/BirthdayView.vue')
        },
        {
            path: '/home',
            name: 'home',
            component: HomeView,
            children: [
                {
                    path: '',
                    redirect: '/home/index'
                },
                {
                    path: '/home/index',
                    name: 'home-index',
                    component: () => import('@/views/home/HomeIndexView.vue')
                },
                {
                    path: '/home/zone',
                    name: 'zone',
                    component: () => import('@/views/zone/ZoneView.vue'),
                },
                {
                    path: '/home/about',
                    name: 'home-about-us',
                    component: () => import('@/views/home/AboutUsView.vue')
                },
                {
                    path: '/home/wall',
                    name: 'home-pictures-wall',
                    component: () => import('@/views/home/PictureWallView.vue')
                },
                {
                    path: '/home/message',
                    name: 'home-message',
                    component: () => import('@/views/home/MessageView.vue')
                },
                {
                    path: '/home/map',
                    name: 'home-footprints-map',
                    component: () => import('@/views/home/FootprintMapView.vue')
                },
                {
                    path: '/home/story',
                    name: 'home-our-story',
                    component: () => import('@/views/home/StoryView.vue')
                }
            ]
        },
        {
            path: '/user',
            name: 'user',
            component: () => import('@/views/UserHomeView.vue')
        }
    ]
})

export default router
