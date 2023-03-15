import React from 'react';
import "./post.css";

const Post = () =>{
    return (
        <div class="post-box">
            <form>
                <div class="post_content">
                    {/* 헤더 부분 */}
                    <div class="post_header">
                        <div class="post_header_text">POST</div>
                    </div>

                    {/* 바디 부분 */}
                    <div class="post_body">
                        <div class="post_body_content1">
                            <div class="post_body_title">TITLE</div>
                            <input class = "post_body_titlecontent"></input>
                        </div>

                        <div class="post_body_content2">
                            <select className="post_body_content2_select_one">
                                <option selected >전체</option>
                                <option>프로젝트</option>
                                <option>스터디</option>
                                <option>공모전</option>
                            </select>

                            <select className="post_body_content2_select_two">
                                <option selected >비고</option>
                                <option>비고</option>
                                <option>비고</option>
                                <option>비고</option>
                            </select>

                            <select className="post_body_content2_select_three">
                                <option selected >비고</option>
                                <option>비고</option>
                                <option>비고</option>
                                <option>비고</option>
                            </select>
                        </div>

                        <div class="post_body_content3">
                            <div class="post_body_write">Content</div>
                            <input class = "post_body_writecontent"></input>
                        </div>
                    </div>

                    {/* 푸터 부분 */}
                    <div class="post_footer">
                        <button class="post_footer_button">submit</button>
                    </div>
                </div>
            </form>
        </div>
    )
}
export default Post;