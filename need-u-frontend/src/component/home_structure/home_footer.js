import React from 'react';
import './home_footer.css'

const Home_footer = () =>{
    return (
        <div className="home_footer_body">
            <div className="home_footer_body_1_line"></div>
            <div className="home_footer_body_2_container">
                <div className="home_footer_body_2_container_copyright">@Copyright CHAN</div>
                <div className="home_footer_body_2_container_contect">
                    <div className="home_footer_body_2_container_contect_m">
                        <a href="https://github.com/ho-sick99" target='_blank'>
                            <img className = "Moon_img" src="img/git.png"></img>
                        </a>
                        <div>Moon</div>
                    </div>
                    <div className="home_footer_body_2_container_contect_c">
                        <a href="https://github.com/YOON-CC" target='_blank'>
                            <img className = "Chan_img" src="img/git.png"></img>
                        </a>
                        <div>Chan</div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Home_footer;