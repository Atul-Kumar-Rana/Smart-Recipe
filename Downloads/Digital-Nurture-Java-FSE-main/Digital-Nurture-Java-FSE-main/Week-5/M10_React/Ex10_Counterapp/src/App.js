import React from 'react';
import CountPeople from './Components/CountPeople';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header" style={{ minHeight: '10vh', padding: '20px' }}>
        <h1>Counter Application</h1>
      </header>
      <main>
        <CountPeople />
      </main>
    </div>
  );
}

export default App;
