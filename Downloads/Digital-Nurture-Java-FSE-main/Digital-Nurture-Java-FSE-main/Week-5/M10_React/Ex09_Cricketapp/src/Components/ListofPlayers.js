import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 100 },
    { name: 'Rohit Sharma', score: 45 },
    { name: 'KL Rahul', score: 85 },
    { name: 'Shikhar Dhawan', score: 30 },
    { name: 'Rishabh Pant', score: 75 },
    { name: 'Hardik Pandya', score: 65 },
    { name: 'Ravindra Jadeja', score: 95 },
    { name: 'R Ashwin', score: 55 },
    { name: 'Jasprit Bumrah', score: 110 },
    { name: 'Mohammed Shami', score: 25 },
    { name: 'Yuzvendra Chahal', score: 80 }
  ];

  // Filter the players with scores below 70 using arrow functions of ES6
  const playersBelow70 = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>Players Below 70</h2>
      <ul>
        {playersBelow70.map((player, index) => (
          <li key={index}>{player.name} - Score: {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
