import React, { useState } from 'react';
// import { hashing } from "./hashing"
import "./before_login.css";
import store from '../../home_store.js';


const Before_login = () => {

    return (
        <div className="home_header_kategory_3">
            <div className="home_header_kategory_3_list">
                <div onClick={function(){
                    store.dispatch({type:"LOGIN"});
                }.bind(this)}>Login</div>

                <div onClick={function(){
                    store.dispatch({type:"SIGN_UP"});
                }.bind(this)}>Sign Up</div>
            </div>
        </div>
    )
}
export default Before_login;