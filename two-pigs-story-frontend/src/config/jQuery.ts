import { App } from 'vue'
import jQuery from 'jquery'

export default {
  install: (app: App) => {
    app.config.globalProperties.$ = jQuery
    app.config.globalProperties.jQuery = jQuery
    app.provide('jQuery', jQuery)
  }
}
