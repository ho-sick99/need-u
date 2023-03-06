import React from 'react';
import Board_header from './board_header';
import Board_main from './board_main';
import './board.css'


const Board = () =>{
    return (
        <div className='board_body'>
            <Board_header></Board_header>
            <Board_main></Board_main>
        </div>
    )
}

export default Board;