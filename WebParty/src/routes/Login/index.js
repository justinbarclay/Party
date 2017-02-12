import { injectReducer } from '../../store/reducers'

export default (store) => ({  
  path: 'login',
  getComponent (nextState, next) {
    require.ensure([
      './containers/LoginContainer',
      //'./modules/login'
    ], (require) => {
      const login = require('./containers/LoginContainer').default
      //const loginReducer = require('./modules/login').default

      //injectReducer(store, {
        //key: 'login',
        //reducer: loginReducer
      //})

      next(null, login)
    }, 'login')
  }
})