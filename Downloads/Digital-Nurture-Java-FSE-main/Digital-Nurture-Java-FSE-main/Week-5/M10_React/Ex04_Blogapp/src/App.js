import React from 'react';
import Posts from './Post';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header" style={{ minHeight: '10vh', padding: '20px' }}>
        <h1>My Blog Application</h1>
      </header>
      <main style={{ padding: '20px' }}>
        <Posts />
      </main>
    </div>
  );
}

export default App;
