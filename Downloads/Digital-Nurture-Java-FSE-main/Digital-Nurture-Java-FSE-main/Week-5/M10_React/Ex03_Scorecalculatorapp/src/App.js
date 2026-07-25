import React from 'react';
import CalculateScore from './Components/CalculateScore';
import './App.css';

function App() {
  return (
    <div className="App">
      <h2>Student Score Calculator</h2>
      <CalculateScore 
        Name="John Doe" 
        School="Greenwood High" 
        Total={425} 
        goal="Achieve 90% and above in finals" 
      />
    </div>
  );
}

export default App;
