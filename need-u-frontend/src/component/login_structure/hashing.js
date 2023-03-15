import { sha512 } from 'crypto-hash'; // SHA-512 해시함수

// 비밀번호 해시화 함수
export const hashing = async (password) => { 
    return await sha512(password);
}  