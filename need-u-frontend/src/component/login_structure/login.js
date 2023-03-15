import React, { useState } from 'react';
import "./login.css";

// https://eunhee-programming.tistory.com/194

const Login = () => {
    const [id, setId] = useState('');
    const [password, setPassword] = useState('');

    const handleidChange = (event) => {
        console.log(event.target.value);
        setId(event.target.value)
    };

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        console.log(await (await fetch("http://localhost:8088/member/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                "mid": id,
                "password": password
            }),
        })).json());
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