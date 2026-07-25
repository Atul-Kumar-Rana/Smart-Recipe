import React from 'react';
import ListofPlayers from './Components/ListofPlayers';
import IndianPlayers from './Components/IndianPlayers';
import './App.css';

function App() {
  const flag = true;

  return (
    <div className="App">
      <h1>Cricket App</h1>
      <p>Current flag value is: {flag.toString()}</p>
      
      {flag ? (
        <ListofPlayers />
      ) : (
        <IndianPlayers />
      )}
    </div>
  );
}

export default App;
