import React from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = ({ Name, School, Total, goal }) => {
  // Let's assume there are 5 subjects to calculate the average
  const average = Total / 5;

  return (
    <div className="score-card">
      <h3>Student Score Details</h3>
      <p><strong>Name:</strong> {Name}</p>
      <p><strong>School:</strong> {School}</p>
      <p><strong>Total Marks:</strong> {Total} / 500</p>
      <p><strong>Calculated Average:</strong> {average}%</p>
      <p><strong>Goal:</strong> {goal}</p>
    </div>
  );
};

export default CalculateScore;
