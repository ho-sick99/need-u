import React from 'react';
import Home_header from './home_header';
import Home_main from './home_main';
import Home_footer from './home_footer';
import './home.css'

const Home = () =>{
    return (
        <div className='home_body'>
            <Home_header></Home_header>
            <Home_main></Home_main>
            <Home_footer></Home_footer>
        </div>
    )
}

export default Home;