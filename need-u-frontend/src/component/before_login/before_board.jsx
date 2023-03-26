import React, { Component } from 'react';
// import { hashing } from "./hashing"
import "./before_board.css";
import store from '../../home_store.js';



class before_board extends Component {
    
    render() {
        return (
            <div className="home_header_kategory_3_after">
                {/* 로고 */}
                <div className="hello_text">
                    <h2>로그인 후 사용해주세요!</h2>
                </div>

            </div>
        )
    }
}
export default before_board;