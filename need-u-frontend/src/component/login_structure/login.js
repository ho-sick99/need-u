import React, { useEffect } from 'react';
import "./login.css";

// https://eunhee-programming.tistory.com/194

const Login = () => {
    useEffect(() => {
        fetch("/needu-backend/sign_in", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "mid": "USER2",
                "password": "USER2"
            }),
        })
            .then((res) => {
                console.log(res);
            })
    });

    return (
        <div class="login-box">
            <h2>Login</h2>
            <form>
                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="" required=""></input>
                    <label>Password</label>
                </div>
                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Submit
                </a>
            </form>
        </div>
    )
}
export default Login;