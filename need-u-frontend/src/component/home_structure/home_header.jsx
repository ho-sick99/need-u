import React, { Component } from "react";
import "./home_header.css";
import store from '../../home_store.js';

export default class Home_header extends Component{

    render() { 
        return (
            <div className="home_header_body">

                {/* 로고 */}
                <div className="home_header_kategory_1">
                    <img src="img/logo.png"></img>
                </div>

                {/* 게시글 보기 및 쓰기 */}
                <div className="home_header_kategory_2">
                    <div className="home_header_kategory_2_list">
                        <div onClick={() => alert('미완성')}>FIND</div>

                        <div onClick={function(){
                            store.dispatch({type:"POST"});
                        }.bind(this)}>POST</div>

                    </div>
                </div>
                
                {/* 로그인 및 회원가입 */}
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
            </div>
        )
    }
}