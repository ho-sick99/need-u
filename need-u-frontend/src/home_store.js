import { legacy_createStore as createStore } from "redux";

export default createStore(function(state, action){
    if(state === undefined){
        return {number : 0}
    }

    if(action.type === "HOME"){
        return {...state, number : 0}
    }

    if(action.type === "LOGIN"){
        return {...state, number: 1}
    }

    if(action.type === "SIGN_UP"){
        return {...state, number: 2}
    }

    if(action.type === "FILTER"){
        return {...state, number: 3}
    }

    if(action.type === "POST"){
        return {...state, number: 4}
    }

    if(action.type === "FIND"){
        return {...state, number: 5}
    }

    if(action.type === "MYPAGE"){
        return {...state, number: 6}
    }


    return state

}, window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__())