<template>
  <div id="app" class="container">
    <NavHeader class="navbar"/>
    <router-view class="main"/>
    <footer class="foot">&#169;2021 Derek Lomibao</footer>
  </div>
</template>

<script>
import NavHeader from "@/components/NavHeader"
//import Home from "@/views/Home";
export default {
  name: 'App',
  components: {
    NavHeader:NavHeader
  }
}
</script>

<style lang="scss">
*{
  font-family: 'Times New Roman', Times, serif;
  box-sizing: border-box;
  padding: 0;
  margin: 0;
}
body{
  width: 100vw;
  background-color:#eeeeee;
}
.container{
  width:100%;
  min-height: 100vh;
  margin: auto;
  box-shadow: 3px 3px 15px #555;


  box-sizing: border-box;
  display: grid;
  grid-template:
    "navbar"
    "main"
    "foot";
  grid-template-rows: 80px 1fr 3rem;
}
.main{
  grid-area: main;
  z-index: 2;
}
.foot{
  z-index: 4;
  height: 3rem;
  grid-area: foot;
  align-items:center;
  display: flex;
  text-align: right;
  align-content: center;
  width: 100%;
  padding-left:5%;
  padding-right:5%;
  background-color:#D0D0D0;
  box-shadow: 3px 3px 15px #777;

}
</style>
