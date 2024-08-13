import { createRouter, createWebHistory } from 'vue-router'
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
      path: '/welcome',
      name: 'welcome',
      component: ()=>import('../views/WelcomeView.vue')
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
          component: () => import('../views/Home/HomeIndexView.vue')
        },
        {
          path: '/home/about',
          name: 'home-about-us',
          component: () => import('../views/Home/AboutUsView.vue')
        },
        {
          path: '/home/wall',
          name: 'home-pictures-wall',
          component: () => import('../views/Home/PictureWallView.vue')
        },
        {
          path: '/home/message',
          name: 'home-message',
          component: () => import('../views/Home/MessageView.vue')
        },
        {
          path: '/home/map',
          name: 'home-footprints-map',
          component: () => import('../views/Home/FootprintMapView.vue')
        },
        {
          path: '/home/story',
          name: 'home-our-story',
          component: () => import('../views/Home/StoryView.vue')
        }
      ]
    },
    {
      path: '/user',
      name: 'user',
      component:()=>import('../views/UserHomeView.vue')
    }
  ]
})

export default router
