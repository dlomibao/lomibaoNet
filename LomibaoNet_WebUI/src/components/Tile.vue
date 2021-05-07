<template>
  <section :id="id" class="cat">
    <a :href='href' class='nocolor'>
      <div class='postbox'>
        <span class='posttitle'>{{ title }}</span>
        <p class='postcaption'>{{ caption }}</p>
        <img class="backgroundImage" :src="require(`@/${backgroundUrl}`)">
      </div>
    </a>
  </section>
</template>

<script>
export default {
  name: "Tile",
  props: {
    id: String,
    backgroundUrl: String,
    title: String,
    href: String,
    caption: String
  }

}
</script>

<style lang="scss" scoped>
.cat {
  height: 100%;
  width: 960px;
  float: left;
  overflow: hidden;
  margin-top: 18px;
}

.cattitle {
  font-size: 20px;
  font-family: "Palatino Linotype", serif;
}

.postbox {

  width: 100%;
  height: 100%;
  background-color: #667;
  opacity: .9;
  box-shadow: inset 3px 3px 15px #000;
  position: relative;
  border-top: 10px;
  float: left;
}

.posttitle {
  background-color: #FFF;
  transition: background-color .25s;
  -moz-transition: background-color .25s;
  -webkit-transition: background-color .25s;
  font-family: "Century Gothic", sans-serif;
  font-size: 20px;
  background-color: rgba(255, 255, 255, .6);
  position: absolute;
  top: 10px;
  display: inline-block;
  padding: 5px;
  clear: none;
}

.postbox:hover {
  opacity: .7;
  box-shadow: 3px 3px 15px #555;
}

.postcaption {
  background-color: #FFF;
  opacity: 0;
  transition: opacity .25s;
  -moz-transition: opacity .25s;
  -webkit-transition: opacity .25s;
  font-family: "Century Gothic", sans-serif;
  font-size: 16px;
  background-color: rgba(255, 255, 255, .9);
  position: absolute;
  bottom: 20%;
  padding: 5px;
  display: inline-block;
}

.postbox:hover .postcaption {
  opacity: 1;
}

.postbox:hover .posttitle {
  background-color: rgba(255, 255, 255, .9);
}

a.nocolor {
  color: inherit;
  text-decoration: none;
  cursor: pointer;
}

.backgroundImage {
  width: 100%;
  height: 100%;
  object-fit: cover;
}



@media screen and (max-width: 225px) {
  .postbox {
    width: 98%;
  }
  .cat {
    width: 98%;
  }
}

@media screen and (max-width: 359px) and (min-width: 226px) {
  .sections {
    section {
      width: 90vw;
      height: 60vw;
    }
  }
}

@media screen and (max-width: 500px) {

  .sections {
    section {
      width: 90vw;
      height: 60vw;
    }
  }

}

@media screen and (max-width: 950px) and (min-width: 501px) {
  .sections {
    section {
      width: 40vw;
      height: 30vw;

    }
  }

}

@media screen and (min-width: 1920px) {

  .sections {
    display: flex;
    flex-flow: row wrap;
    section {
      width: 600px;
      height: 400px;
      background: #8ba18b;
      margin: .5em;
    }
  }

  .postbox {
    width: 600px;
    height: 400px;
  }
  .cat {
    width: 600px;
    height: 400px;
  }
}
</style>