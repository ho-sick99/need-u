import React, { useState } from 'react';
import './search.css';
import store from '../../home_store.js'


function Search() {
  const [searchTerm, setSearchTerm] = useState("");
  const [history, setHistory] = useState([]);

  function handleInputChange(event) {
    setSearchTerm(event.target.value);
  }

  function handleSearch(e) {
    if (e.key == 'Enter'){
        if (!history.includes(searchTerm)){
          setHistory(prevHistory => [...prevHistory, searchTerm]);
          setSearchTerm("");
        }
    }
  }

  const removeList = (id) => {
    console.log(id);
    const about_lists = history.filter((item) => item !== id);
    setHistory(about_lists);
  };
  
  return (
    <div>
        <input className="home_main_kategory_1_search" 
            type="text"
            value={searchTerm} 
            onChange={handleInputChange}
            onClick={function() {store.dispatch({type:"FILTER"});}.bind(this)}
            onKeyPress={handleSearch}>
        </input>
        <div class="home_main_kategory_1_save">
            {history.map((item) => (
            <div class = "flex-item" key={item} onClick={() => removeList(item)}>{item}</div>
            ))}
        </div>
    </div>
  );
}

export default Search;