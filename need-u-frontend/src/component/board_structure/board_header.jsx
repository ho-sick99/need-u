import React, { Component } from "react";
import "./board_header.css";
import store from '../../home_store.js';
import Before_board from '../before_login/before_board.jsx'
import After_board from '../after_login/after_board.jsx'
import store_l from '../../login_store.js';

import {token} from '../login_structure/login.js'
export default class Board_header extends Component{


    state_1 = {number:store_l.getState().number} 

    render() { 
        return (
            <div className="board_header_body">

                <div className="board_header_container_1">

                    {/* 홈으로 돌아가기 */}
                    <div className="gotohome_text" onClick={function(){
                            store.dispatch({type:"HOME"});
                        }.bind(this)}>
                        <h2>◀Go to home</h2>
                    </div>


                    {this.state_1.number === 0 && <Before_board></Before_board>}   
                    {this.state_1.number === 1 && <After_board></After_board>}   

                </div>


                {/* 컨테이너 2*/}
                <div className="board_header_container_2">
                    <select className="select_one">
                        <option selected >전체</option>
                        <option>프로젝트</option>
                        <option>스터디</option>
                        <option>공모전</option>
                    </select>

                    <select className="select_two">
                        <option selected>비고</option>
                        <option>비고</option>
                        <option>비고</option>
                        <option>비고</option>
                    </select>

                    <select className="select_three">
                        <option selected>비고</option>
                        <option>비고</option>
                        <option>비고</option>
                        <option>비고</option>
                    </select>

                    <button className="button_one">SEARCH</button>

                    <button className="button_two">REFRESH</button>
                </div>
            </div>
        )
    }
}