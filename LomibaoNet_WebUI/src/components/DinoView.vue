<template>

  <div class="spotlight-holder">
    <div id="l1"/>
    <kinesis-container tag="div" class="spotlight">
      <kinesis-element tag="img" :src="backgroundSrc" id="backer"  :max-y="3" :strength="3" />
      <kinesis-element tag="img" :src="wallSrc" id="wall" :max-y="2" :strength="5"/>
      <kinesis-element tag="img" :src="dinoSrc" id="dino" :max-y="5" :strength="10"/>
      <kinesis-element tag="img" :src="catSrc" id="cat" :max-y="5" :strength="14"/>
    </kinesis-container>
    <div id="l2"/>
  </div>


</template>

<script>
import {KinesisContainer, KinesisElement} from "vue-kinesis"

export default {
  name: "DinoView",
  components: {
    KinesisContainer: KinesisContainer,
    KinesisElement: KinesisElement
  },
  data() {
    return {
      backgroundSrc: "https://lh4.googleusercontent.com/-2npmNOJDjhs/UYwpxfA-PzI/AAAAAAAAAUo/wbpdowV1N2Q/w824-h652-no/masterback.jpg",
      wallSrc: "https://lh3.googleusercontent.com/-hJx2onsLb1I/UbCZuzwcFYI/AAAAAAAAAWE/PSKTIEeEnE0/w657-h763-no/wall.png",
      catSrc: "https://lh4.googleusercontent.com/-sQTIOFqbLnw/UYwpCBIa6TI/AAAAAAAAAUc/AR9O57Fk4RQ/w698-h476-no/catback8.png",
      dinoSrc: "https://lh5.googleusercontent.com/-ROJbowmRDsE/UbCXFNVjSxI/AAAAAAAAAVo/yqVS3K8zjG0/w610-h762-no/dinoback8.png"
    }
  }
}
</script>

<style lang="scss" scoped>
.spotlight-holder {
  display: grid;
  grid-template-columns: 1fr 900px 1fr;
}
#l1,
#l2 {
  background-color: #333;
}
.spotlight {
  width: 100%;
  padding-bottom: 60%;
  position: relative;
  background-color: #99b;
  overflow: hidden;
}

#backer {
  position: absolute;
  left: -20px;
  top: -10px;
  z-index: 0;
  width: 110%;
  height: 110%;
}
#cat {
  position: absolute;
  left: -18px;
  bottom: -25px;
  height: 70%;
}
#wall {
  position: absolute;
  left: -2%;
  bottom: -5px;
  height: 110%;
  max-width: 60%;
}
#dino {
  position: absolute;
  right: -30px;
  top: -15%;
  width: 55%;
}

@media screen and (max-width:225px){
  #cat{top:60%;height:40%;}
  #dino{top: 30%;height:60%;}
}
@media screen and (max-width: 359px) and (min-width:226px){
  .spotlight-holder{grid-template-columns: 1fr 100% 1fr;}
  #cat{top:60%;height:40%;}
  #dino{top: 0%;height:90%;right:0%;}
}
@media screen and (max-width: 900px){
  .spotlight-holder{grid-template-columns: 1fr 100% 1fr;}
  #cat{top:45%;height:55%;}
  #dino{top: 0%;width:50%;right:-10px;}
}
@media screen and (min-width: 1920px)
{
  .spotlight-holder{width:100%;}
}

</style>