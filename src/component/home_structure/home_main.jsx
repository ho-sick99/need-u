import React, { Component, useState } from "react";
import './home_main.css';
import Filter from '../filter_structure/filter.js';
import Login from '../login_structure/login.js';
import Sign_up from '../login_structure/sign_up';
import Home_default_structure from '../home_default_structure/home_default_structure';
import store from '../../home_store.js'
import Search from "../search_structure/search";
import Post from "../post_structure/post";

export default class Home_main extends Component{
    
    //메인화면 렌더링
    state = {number:store.getState().number} 

    //변화가 일어났을때 다시 재랜더링 되도록 하는 것이다.
    constructor(props){ 
        super(props);
        store.subscribe(function(){ // subscribe는 store가 변할때 마다 호출이 된다.
            this.setState({number:store.getState().number});
        }.bind(this));
    }

    //검색기록 구현


    render() { 
        console.log(this.state);
        return (
            <div className="home_main_body">

                {/*  검색 및 검색기록 화면 */}
                <div className = "home_main_kategory_1">
                    <div className='home_main_kategory_1_text'>NeedU can find</div>
                    <Search></Search>
                </div>

                {/*  필터로 걸러진 것들 */}
                <div className = "home_main_kategory_2">
                    {/* 메인일러스트 */}
                    {this.state.number === 0 && <Home_default_structure></Home_default_structure>} 
                    
                    {/*로그인*/}
                    {this.state.number === 1 && <Login></Login>} 

                    {/*회원가입*/}
                    {this.state.number === 2 && <Sign_up></Sign_up>} 
                    
                    {/*필터링 작업*/}
                    {this.state.number === 3 && <Filter></Filter>} 

                    {/*글쓰기*/}
                    {this.state.number === 4 && <Post></Post>} 
                </div>

            </div>
        )
    }
}
