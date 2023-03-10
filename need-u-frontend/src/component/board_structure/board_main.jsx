import React, { Component } from "react";
import "./board_main.css";

export default class Board_main extends Component{

    render() { 
        return (
            <div className="board_main_body">
                <div className="board_main_body_container">
                    
                <div className="board_main_body_container_header_1">NeedU</div>
                    <div className="board_main_body_container_header_2">
                        <div className="list_title_1">번호</div>
                        <div className="list_title_2">분류</div>
                        <div className="list_title_3">제목</div>
                        <div className="list_title_4">인원</div>
                        <div className="list_title_5">버튼</div>
                    </div>

                    <div class="board_main_body_container_header_list">
                        <div class="board-list">
                            <div class="board-list_t1">1</div>
                            <div class="board-list_t2">프로젝트</div>
                            <div class="board-list_t3">조윤찬 급의 프론트엔드 개발자 모집합니다.(심화과정 필수)</div>
                            <div class="board-list_t4">1/4</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">2</div>
                            <div class="board-list_t2">공모전</div>
                            <div class="board-list_t3">경험 필요없고 우승을 목표로 하는 팀입니다.</div>
                            <div class="board-list_t4">1/3</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">3</div>
                            <div class="board-list_t2">공모전</div>
                            <div class="board-list_t3">경험 필요없고 우승을 목표로 하는 팀입니다.</div>
                            <div class="board-list_t4">1/3</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">4</div>
                            <div class="board-list_t2">스터디</div>
                            <div class="board-list_t3">우동균의 컴퓨터 네트워크 스터디</div>
                            <div class="board-list_t4">1/100</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">5</div>
                            <div class="board-list_t2">프로젝트</div>
                            <div class="board-list_t3">조윤찬 급의 프론트엔드 개발자 모집합니다.(심화과정 필수)</div>
                            <div class="board-list_t4">1/4</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">6</div>
                            <div class="board-list_t2">프로젝트</div>
                            <div class="board-list_t3">조윤찬 급의 프론트엔드 개발자 모집합니다.(심화과정 필수)</div>
                            <div class="board-list_t4">1/4</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                        <div class="board-list">
                            <div class="board-list_t1">7</div>
                            <div class="board-list_t2">스터디</div>
                            <div class="board-list_t3">우동균의 컴퓨터 네트워크 스터디</div>
                            <div class="board-list_t4">1/100</div>
                            <div class="board-list_t5">
                                <button>보기</button><button>신청</button><button>찜</button>
                            </div>
                        </div>
                    </div>

                    <div className="board_main_body_container_footer">
                        <div className="board_main_body_container_footer_page_controller">
                            <div><img className = "r_nextnext" src="img/r_nextnext.png"></img></div>
                            <div><img className = "r_next" src="img/r_next.png"></img></div>
                            <p className ="page_num">1</p>
                            <div><img className = "next" src="img/next.png"></img></div>
                            <div><img className = "nextnext" src="img/nextnext.png"></img></div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}