import React from 'react';
import CounterEvents from './Components/CounterEvents';
import CurrencyConvertor from './Components/CurrencyConvertor';
import './App.css';

function App() {
  return (
    <div className="App" style={{ padding: '30px' }}>
      <h1>ReactJS-HOL-11: Events and Forms</h1>
      <CounterEvents />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
