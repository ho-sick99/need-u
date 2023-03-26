import React, { Component } from 'react';
// import { hashing } from "./hashing"
import "./after_login.css";
import store from '../../home_store.js';
import {token} from '../login_structure/login.js'


class After_login extends Component {
    click_logout = (event) => {
        window.location.reload();
        // 클릭 이벤트 처리 로직
    }
    
    render() {
        return (
            <div className="home_header_kategory_3_after">
                <div>{token}</div>
                <div className="home_header_kategory_3_list_after">
                    <div onClick={function(){
                        store.dispatch({type:"MYPAGE"});
                    }.bind(this)}>Mypage</div>

                    <div onClick={this.click_logout}>Log out</div>
                </div>
            </div>
        )
    }
}
export default After_login;