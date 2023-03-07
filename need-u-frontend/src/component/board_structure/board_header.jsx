import React, { Component } from "react";
import "./board_header.css";

export default class Board_header extends Component{

    render() { 
        return (
            <div className="board_header_body">

                <div className="board_header_container_1">
                    {/* 로고 */}
                    <div className="hello_text">
                        <h2>안녕하세요! ooo 님</h2>
                    </div>

                    {/* 마이페이지*/}
                    <div className="board_mypage">

                    </div>
                </div>


                {/* 컨테이너 2*/}
                <div className="board_header_container_2">
                    <select className="select_one">
                        <option selected>전체</option>
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