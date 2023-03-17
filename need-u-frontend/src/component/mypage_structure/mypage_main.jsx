import React, { Component } from "react";
import "./mypage_main.css";
import store from '../../home_store.js';

export default class Mypage_main extends Component{

    click_logout = (event) => {
        window.location.reload();
        // 클릭 이벤트 처리 로직
    }

    render() { 
        return (
            <div className="mypage_main_body">
                <div className="mypage_main_body_content_1"></div>
                <div className="mypage_main_body_content_2">
                    <div className="mypage_main_body_content_2_main_page">
                        <div className="mypage_to_home" onClick={function(){
                            store.dispatch({type:"HOME"});
                        }.bind(this)}>GO TO HOME</div>
                        <div className="mypage_main_body_content_2_main_page_1">

                            <div className="profile">
                                <div className="profile_photo"><img className = "profile_photo_img" src="img/mypage.png"></img></div>
                                <div className="profile_name">oo님</div>
                            </div>
                            <div className="profile_under">
                                <div className="profile_under_logout" onClick={this.click_logout}>로그아웃</div>
                            </div>  
                        </div>
                        <div className="mypage_main_body_content_2_main_page_2">
                            <div className="status_text_content">
                                <div className="status_text">STATUS</div>
                                
                                <div className="status_text_upload">업로드</div>
                                <div className="status_text_request">요청중</div>
                            </div>
                            
                            <div className="status_content">
                                <div className="status_content_1">
                                    <div className="status_content_1_1">
                                        <div className="status_content_1_1_project"><img className="project" src="img/project.png"></img></div>
                                    </div>
                                    <div className="status_content_1_2">
                                        <div className="status_content_1_2_study"><img className="study" src="img/study.png"></img></div>
                                    </div>
                                    <div className="status_content_1_3">
                                        <div className="status_content_1_3_contest"><img className="contest" src="img/contest.png"></img></div>
                                    </div>
                                </div>
                                <div className="status_content_2">
                                    <div className="status_content_2_1">
                                        <div className="status_content_2_1_post">1</div>
                                        <div className="status_content_2_1_request">2</div>
                                    </div>
                                    <div className="status_content_2_2">
                                        <div className="status_content_2_2_post">3</div>
                                        <div className="status_content_2_2_request">4</div>     
                                    </div>
                                    <div className="status_content_2_3">
                                        <div className="status_content_2_3_post">5</div>
                                        <div className="status_content_2_3_request">6</div>
                                    </div>                    
                                </div>
                            </div>

                            <div className="message_content">
                                <img className="message" src="img/message.png"></img>
                                <div className="message_alarm">1</div>
                                <div className="chat">안녕하세요! 우동균의 네트워크 스터디 신청합니다. 정말 cs정복 가능하나요??? 저 진짜 동균님만 믿어요</div>
                            </div>
                        </div>
                    </div>
                        
                </div>
            </div>
            
        )
    }
}