import React, { useState } from 'react';
import "./sign_up.css";

const Sign_up = () =>{
    
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
    function handleSubmit(event) {
        event.preventDefault(); 
        console.log('id:', id);
        console.log('email:', email);
        console.log('nickname:', nickname);
        console.log('password:', password);
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

                <div class="user-box">``
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