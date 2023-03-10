import React, { Component } from "react";
import "./board_header.css";
import store from '../../home_store.js';

export default class Board_header extends Component{

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

                    {/* 로고 */}
                    <div className="hello_text">
                        <h2>ooo님 안녕하세요!</h2>
                    </div>

                    {/* 마이페이지*/}
                    <div className= "board_mypage" onClick={function(){
                            store.dispatch({type:"MYPAGE"});
                        }.bind(this)}><img className = "baord_to_mypage" src="img/mypage.png"></img></div>
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