import React from 'react';
import "./post.css";

const Post = () =>{
    return (
        <div class="post-box">
            <h2>Post</h2>
            <form>
                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>1</label>
                </div>

                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>2</label>
                </div>

                <div class="user-box">
                    <input type="text" name="" required=""></input>
                    <label>3</label>
                </div>

                <div class="user-box">
                    <input type="password" name="" required=""></input>
                    <label>4</label>
                </div>

                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    POST
                </a>
            </form>
        </div>
    )
}
export default Post;