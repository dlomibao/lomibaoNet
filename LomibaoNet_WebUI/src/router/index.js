import {createRouter,createWebHistory} from "vue-router";
import Home from "@/views/Home"
import Categories from "@/views/Categories";
import About from "@/views/About";
import Posts from "@/views/Posts";
import Projects from "@/views/Projects";

const routes=[
    {
        path:"/",
        name:"home",
        component: Home
    },
    {
        path:"/about",
        name:"about",
        component: About
    },
    {
        path: "/categories",
        name:"categories",
        component: Categories
    },
    {
        path: "/posts",
        name:"posts",
        component: Posts
    },
    {
        path: "/projects",
        name: "projects",
        component: Projects
    }

]
const router = createRouter({
    history: createWebHistory(),
    routes
})
export default router