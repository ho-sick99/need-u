import React from 'react';
import "./sign_up.css";

const Sign_up = () =>{
    return (
        <div class="sign_up-box">
            <h2>Sign Up</h2>
            <form>
                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>ID</label>
                </div>

                <div class="user-box">
                    <input type="password" name="" required=""></input>
                    <label>Password</label>
                </div>

                <div class="user-box">
                    <input type="password" name="" required=""></input>
                    <label>Verify Password</label>
                </div>

                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>Nickname</label>
                </div>

                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Join
                </a>
            </form>
        </div>
    )
}
export default Sign_up;