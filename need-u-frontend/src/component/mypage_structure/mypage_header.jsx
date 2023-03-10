import React, { Component } from "react";
import "./mypage_header.css";
import store from '../../home_store.js';


export default class Mypage_header extends Component{

    render() { 
        return (
            <div className="mypage_header_body">
                <img className = "logo_2" src="img/logo_2.png"></img>
                <div className="mypage_header_body_content">
                    <div className="mypage_header_body_content_1" onClick={function(){
                            store.dispatch({type:"FIND"});
                        }.bind(this)}>Go to board</div>
                    <div className="mypage_header_body_content_2">About us</div>
                </div>
            </div>
        )
    }
}