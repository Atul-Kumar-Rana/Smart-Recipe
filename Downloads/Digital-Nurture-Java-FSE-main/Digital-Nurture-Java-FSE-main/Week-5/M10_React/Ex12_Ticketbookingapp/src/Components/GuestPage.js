import React from 'react';

const GuestPage = () => {
  return (
    <div style={{ padding: '20px', border: '1px dashed orange', marginTop: '20px', textAlign: 'left', maxWidth: '500px', margin: '20px auto' }}>
      <h2>Guest View: Flight Details</h2>
      <p>Browse available flights, destinations, and schedules.</p>
      <ul>
        <li>Flight 101: New York to London (08:00 AM)</li>
        <li>Flight 202: Paris to Dubai (02:30 PM)</li>
        <li>Flight 303: Tokyo to Sydney (11:45 PM)</li>
      </ul>
      <p style={{ color: 'red', fontWeight: 'bold' }}>Please log in to book tickets.</p>
    </div>
  );
};

export default GuestPage;
