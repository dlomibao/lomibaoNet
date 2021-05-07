<template>
<div class="home">
<dino-view/>
  <div id="categories" class="sections">
    <Tile id="code" title="Code" caption="Programming experiments and projects" background-url="assets/thumb/thumb_code.jpg" href="#"/>
    <Tile id="art" title="Artwork" caption="Paintings and drawings" background-url="assets/thumb/thumb_InAnotherCastle.jpg" href="#"/>
    <Tile id="photos" title="Photography" caption="Experiences around the world" background-url="assets/thumb/thumb_Piazza_San_Marco.jpg" href="#"/>
  </div>
</div>
</template>

<script>
import DinoView from "@/components/DinoView";
import Tile from "@/components/Tile";
export default {
  name: "Home",
  components: {Tile, DinoView}
}
</script>

<style lang="scss" scoped>
.sections{
  display: flex;
  flex-flow: row wrap;
  justify-content: center;
  section {
    width: 30vw;
    height: 20vw;

    background: #8ba18b;

    margin: 1em;
  }
}
.cat{
  height:100%;
  width:960px;
  float:left;
  overflow:hidden;
  margin-top:18px;
}

.cattitle{
  font-size: 20px;
  font-family: "Palatino Linotype",serif;
}

.postbox{
  width:100%;height:100%;
  background-color: #667;
  opacity:.9;
  box-shadow:inset 3px 3px 15px #000;
  position:relative;
  border-top:10px;
  float:left;
  background-size:100% 100%;
}
.posttitle{
  background-color:#FFF;
  transition:background-color .25s;
  -moz-transition:background-color .25s;
  -webkit-transition:background-color .25s;
  font-family:"Century Gothic", sans-serif;
  font-size:20px;
  background-color:rgba(255,255,255,.6);
  position:absolute;
  top:10px;
  display:inline-block;
  padding:5px;
  clear:none;
}
.postbox:hover{
  opacity:.7;
  box-shadow: 3px 3px 15px #555;
}
.postcaption{
  background-color:#FFF;
  opacity:0;
  transition: opacity .25s;
  -moz-transition:opacity .25s;
  -webkit-transition:opacity .25s;
  font-family:"Century Gothic", sans-serif;
  font-size:16px;
  background-color:rgba(255,255,255,.9);
  position:absolute;
  bottom:20%;
  padding:5px;
  display:inline-block;
}
.postbox:hover .postcaption{
  opacity:1;
}
.postbox:hover .posttitle{
  background-color:rgba(255,255,255,.9);
}

a.nocolor{
  color:inherit;
  text-decoration:none;
  cursor:pointer;
}
</style>