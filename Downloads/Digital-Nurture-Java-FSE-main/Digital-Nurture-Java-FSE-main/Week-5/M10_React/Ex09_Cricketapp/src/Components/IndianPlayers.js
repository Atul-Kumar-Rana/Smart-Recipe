import React from 'react';

const IndianPlayers = () => {
  const T20players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophy = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  
  // Merge the two arrays using the spread operator feature of ES6
  const indianPlayers = [...T20players, ...RanjiTrophy];
  
  // Display Odd Team Player and Even Team players using Destructuring
  const [odd1, even1, odd2, even2, odd3, even3] = indianPlayers;

  return (
    <div>
      <h2>Indian Players</h2>
      
      <h3>Odd Team Players</h3>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
      </ul>
      
      <h3>Even Team Players</h3>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
      </ul>

      <h3>All Merged Players</h3>
      <ul>
        {indianPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
