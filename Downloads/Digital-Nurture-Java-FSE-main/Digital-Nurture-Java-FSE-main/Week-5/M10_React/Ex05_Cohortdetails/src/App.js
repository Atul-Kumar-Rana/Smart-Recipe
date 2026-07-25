import React from 'react';
import CohortDetails from './Components/CohortDetails';
import './App.css';

function App() {
  return (
    <div className="App" style={{ textAlign: 'center', padding: '20px' }}>
      <h2>My Academy - Cohort Dashboard</h2>
      
      <CohortDetails 
        name="Java Full Stack Engineer" 
        status="ongoing" 
        startDate="Jan 15, 2026" 
        endDate="April 30, 2026" 
      />
      
      <CohortDetails 
        name="Cloud Native Architecture" 
        status="completed" 
        startDate="Sep 01, 2025" 
        endDate="Dec 15, 2025" 
      />

      <CohortDetails 
        name="React Frontend Developer" 
        status="ongoing" 
        startDate="Feb 10, 2026" 
        endDate="May 20, 2026" 
      />
    </div>
  );
}

export default App;
