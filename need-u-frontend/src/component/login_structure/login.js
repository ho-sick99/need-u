import React, { useState } from 'react';
import { hashing } from "./hashing"
import "./login.css";
import store from '../../home_store.js';
import store_l from '../../login_store.js';

//토큰이 받아질 변수이다.
export let token

const Login = () => {
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');

    const handleidChange = (event) => {
        setId(event.target.value)
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        //테스트
        alert("로그인을 축하드립니다.")
        store_l.dispatch({type:"AFTER"})
        store.dispatch({type:"HOME"})

        //@@@@@@바꿀 전역변수 메커니즘@@@@@@@@
        token = 1999


        // const hashingPW = await hashing(password); // 비밀번호 해시화

        // const res = await (await fetch("http://localhost:8088/member/login", {
        //     method: "POST",
        //     headers: {
        //         "Content-Type": "application/json",
        //     },
        //     body: JSON.stringify({
        //         "mid": id,
        //         "password": hashingPW
        //     }),
        // })).json();

        // console.log(res.msg);
        // if (res.status == "true") { // 로그인 성공
        //     console.log("login success");
        //     const token = res.token; // 토큰
        //     console.log("token: " + token);

            
        //     alert("로그인을 축하드립니다.")
        //     store_l.dispatch({type:"AFTER"})
        //     store.dispatch({type:"HOME"})
        //     //////////////////////////////////////////////////////////


        // } else { // 로그인 실패
        //     console.log("login fail")
        // }
    }

    return (
        <div class="login-box">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <div class="user-box">
                    <input type="text" value={id} onChange={handleidChange}></input>
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" value={password} onChange={handlePasswordChange}></input>
                    <label>Password</label>
                </div>
                <button type="submit">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Submit
                </button>
            </form>
        </div>
    )
}
export default Login;