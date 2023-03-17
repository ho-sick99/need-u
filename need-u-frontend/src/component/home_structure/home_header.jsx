import React, { Component } from "react";
import "./home_header.css";
import store from '../../home_store.js';
import store_l from '../../login_store.js';
import Before_login from '../before_login/before_login.jsx'
import After_login from '../after_login/after_login.jsx'




export default class Home_header extends Component{


    state_1 = {number:store_l.getState().number} 

    // constructor(props){ 
    //     super(props);
    //     store_l.subscribe(function(){ // subscribe는 store가 변할때 마다 호출이 된다.
    //         console.log("아씨발 ")
    //         this.setState({number:store_l.getState().number});
    //     }.bind(this));
    // }

    // state = {number:store.getState().number} 
    // constructor(props){ 
    //     super(props);
    //     store.subscribe(function(){ // subscribe는 store가 변할때 마다 호출이 된다.
    //         this.setState({number:store.getState().number});
    //     }.bind(this));
    // }

    render() { 
        // console.log(this.state_l);

        function post_alert() {
            alert('너는 정상적인 접근을 할 수 없다.');
        }

        return (
            <div className="home_header_body">

                {/* 로고 */}
                <div className="home_header_kategory_1">
                    <img src="img/logo.png"></img>
                </div>

                {/* 게시글 보기 및 쓰기 */}
                <div className="home_header_kategory_2">
                    <div className="home_header_kategory_2_list">
                        <div onClick={function(){
                            store.dispatch({type:"FIND"});
                        }.bind(this)}>FIND</div>

                        {this.state_1.number === 0 && <div onClick={post_alert}>POST</div>} 
                        {this.state_1.number === 1 && <div onClick={function(){store.dispatch({type:"POST"});}.bind(this)}>POST</div>} 
{/* 
                        <div onClick={function(){
                            store.dispatch({type:"POST"});
                        }.bind(this)}>POST</div> */}

                    </div>
                </div>
                
                {/* 로그인 및 회원가입 */}
                {this.state_1.number === 0 && <Before_login></Before_login>}   
                {this.state_1.number === 1 && <After_login></After_login>}   
                
                {/* <Before_login></Before_login> */}
                {/* <After_login></After_login> */}
                
            </div>
        )
    }
}