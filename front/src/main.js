import Vue from 'vue'
import App from './App.vue'
import {router} from './router'
import {store} from './store/index.js';
import vuetify from './plugins/vuetify'

import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/ko'

Vue.config.productionTip = false;
Vue.use(Element,{locale})
new Vue({
  store,
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
