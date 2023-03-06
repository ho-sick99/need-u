import React, { Component } from "react";
import "./board_main.css";

export default class Board_main extends Component{

    render() { 
        return (
            <div className="board_main_body">
                <div className="board_main_body_container">
                    
                    <div className="board_main_body_container_header">제목</div>

                    <div class="board_main_body_container_header_list">
                        <div class="board-list">1<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">2<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">3<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">4<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">5<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">6<button>보기</button><button>신청</button><button>찜</button></div>
                        <div class="board-list">7<button>보기</button><button>신청</button><button>찜</button></div>
                    </div>

                    <div className="board_main_body_container_footer">
                        <div className="board_main_body_container_footer_page_controller">
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}