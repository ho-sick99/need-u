import React, { useState } from 'react';
import "./sign_up.css";

const Sign_up = () => {
    const [id, setId] = useState('');
    const [email, setEmail] = useState('');
    const [nickname, setNickname] = useState('');
    const [password, setPassword] = useState('');

    const handleidChange = (event) => {
        setId(event.target.value)
    };

    const handleemailChange = (event) => {
        setEmail(event.target.value)
    };

    const handleNicknameChange = (event) => {
        setNickname(event.target.value)
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    };

    //저장완료
    const handleSubmit = async (event) => {
        event.preventDefault();
        const res = await (await fetch("http://localhost:8088/member/sign_up", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "mid": id,
                "nickname": nickname,
                "email": email,
                "password": password
            }),
        })).json();

        console.log(res.msg);
        if (res.status) { // 회원가입 성공
            console.log("회원가입 성공");
        } else { // 회원가입 실패
            console.log("회원가입 실패");
        }
    }

    return (
        <div class="sign_up-box">
            <h2>Sign Up</h2>
            <form onSubmit={handleSubmit}>
                <div class="user-box">
                    <input type="text" value={id} onChange={handleidChange}></input>
                    <label>ID</label>
                </div>
                <div class="user-box">
                    <input type="email" value={email} onChange={handleemailChange}></input>
                    <label>E-mail</label>
                </div>

                <div class="user-box">
                    <input type="text" value={nickname} onChange={handleNicknameChange}></input>
                    <label>Nickname</label>
                </div>

                <div class="user-box">
                    <input type="password" value={password} onChange={handlePasswordChange}></input>
                    <label>Password</label>
                </div>

                <div class="user-box">
                    <input type="password" name="" required=""></input>
                    <label>Verify Password</label>
                </div>

                <button type="submit">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Join
                </button>
            </form>
        </div>
    )
}
export default Sign_up;