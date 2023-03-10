import React from 'react';
import './mypage.css'
import Mypage_header from './mypage_header';
import Mypage_main from './mypage_main';


const Mypage = () =>{
    return (
        <div className='mypage_body'>
            <Mypage_header></Mypage_header>
            <Mypage_main></Mypage_main>
        </div>
    )
}

export default Mypage;