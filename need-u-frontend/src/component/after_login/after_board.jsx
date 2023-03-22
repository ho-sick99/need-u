import React, { Component } from 'react';
// import { hashing } from "./hashing"
import "./after_board.css";
import store from '../../home_store.js';
import {token} from '../login_structure/login.js'


class After_board extends Component {
    
    render() {
        return (
            <div className="home_header_kategory_3_after">
                {/* 로고 */}
                <div className="id_hello_text">
                    <h2>{token}님 안녕하세요!</h2>
                </div>

                {/* 마이페이지*/}
                <div className= "board_mypage" onClick={function(){
                        store.dispatch({type:"MYPAGE"});
                    }.bind(this)}><img className = "baord_to_mypage" src="img/mypage.png"></img>
                </div>
            </div>
        )
    }
}
export default After_board;