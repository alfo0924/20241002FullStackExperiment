import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from './App.vue'
import PageA from './components/PageA.vue'
import PageB from './components/PageB.vue'

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: PageA },
        { path: '/b', component: PageB }
    ]
})

const app = createApp(App)
app.use(router)
app.mount('#app')