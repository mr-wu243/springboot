<template>
  <div>
    {{message}}
    <element-view/>
  </div>
</template>
<script>
import ElementView from './views/element/ElementView.vue'
export default{
  components:{ElementView},
  data(){
    return {
      message:"Hello Vue"
    }
  }
}
</script>
<style>

</style>
