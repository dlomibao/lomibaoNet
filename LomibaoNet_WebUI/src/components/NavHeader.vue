<template>
  <header class="navbar">
    <router-link class="router" to="/">
      <label id="title">
        <span class="bigtitle">The Random Curiosities of Derek&nbsp;</span>
        <span class="bothtitle">Lomibao</span>
        <span class="smalltitle">.net</span>
      </label>
    </router-link>
    <nav>
      <ul class="navlist">
        <li class="navitem">
          <router-link to="/posts">Posts</router-link>
        </li>
        <li class="navitem"><router-link to="/projects">Projects</router-link></li>
        <li class="navitem"><router-link to="/about">About</router-link></li>
      </ul>
    </nav>
  </header>
</template>
<script>
export default {
  name: "NavHeader"
}
</script>
<style lang="scss" scoped>
.router{
  text-decoration: none !important;
  color: black;
  cursor: pointer;
  font-size: 1em;
}
.navbar {
  z-index: 3;
  grid-area: navbar;
  width: 100%;
  height: 5rem;
  display: flex;

  justify-content: space-between;
  background-color: #DDDDDD;
  box-shadow: 3px 3px 15px #555;


}

#title {
  cursor: pointer;

  height: 100%;
  align-items: center;
  display: flex;
  padding-left: 4%;
  padding-right: 4%;
  font-size: 24px;
  font-family: 'Times New Roman', Times, serif;

  .smalltitle {

    visibility: hidden;
    opacity: 0;
    transition: visibility .6s, opacity 0.5s linear;

    flex-shrink: 0;
  }

  .bigtitle {
    display: inline-block;
    visibility: visible;
    opacity: 1;
    flex-shrink: 0;

  }
  .bothtitle {
    display: inline-block;
    visibility: visible;
    opacity: 1;
    flex-shrink: 0;
  }


}

nav {
  height: 100%;
  width: 300px;
  margin-right: 4%;
}

.navlist {
  height: 100%;
  width: 100%;
  display: flex;
  justify-content: space-between;

  align-items: flex-end;

}

.navitem {
  display: inline-block;
  width: 100%;
  height: 100%;
  position: relative; //ensure <a href> lives inside

  a {
    //fill whole <li class="navitem">
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 100%;
    border-radius: 1px;
    border-left: 1px solid #AAA;
    border-right: 1px solid #AAA;
    text-align: center;
    top: 50%;
    left: 50%;
    margin: 0;
    transform: translate(-50%, -50%);
    color: black;
    cursor: pointer;
    text-decoration: none;
    font-size: 18px;
  }

  :hover {
    border-bottom: 3px solid #222222;
    background-color: #DEDEDE;
    box-shadow: 3px 3px 15px #777;

  }
}


@media screen and (max-width: 225px) {
  #title {
    width: 100%;
    height: 1.5em;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .navbar {
    display: flex;
    flex-wrap: wrap;
    height: 11.5em;
    display: block;

  }
  .navbar nav {
    margin-right: 0;

    width: 100%;
    height: 3em;
    display: block;
  }
  .navlist {
    display: block;
  }
  .navitem {
    border-top: 1px solid #EEE;
  }
}

@media screen and (max-width: 359px) and (min-width: 226px) {
  #title {

    width: 100%;
    height: 1.5em;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .navbar {
    display: flex;
    flex-wrap: wrap;
    height: 80px;
  }
  .navbar nav {
    margin-right: 0;
    height: 2em;
    width: 100%;
  }
}

@media screen and (max-width: 500px) {
  #title {
    padding: .5em;
  }
  nav {
    width: 200px;
  }
}

@media screen and (max-width: 900px) {

  #title .smalltitle {
    visibility: visible;
    display: inline-block;
    opacity: 1;
  }
  #title .bigtitle {
    width: 0px;
    height: 0px;
    overflow: hidden;
    visibility: hidden;
    opacity: 0;
    transition: height 1s, width 1s, visibility .3s, opacity 0.5s linear;
  }


}
</style>
