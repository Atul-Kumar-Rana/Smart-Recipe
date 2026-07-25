import React from 'react';

const BookDetails = () => {
  return (
    <div style={{ padding: '15px', border: '1px solid #007bff', margin: '10px', textAlign: 'left', borderRadius: '5px' }}>
      <h3>Book Details</h3>
      <p><strong>Title:</strong> React for Beginners</p>
      <p><strong>Author:</strong> Jane Doe</p>
      <p><em>This component was rendered using an <strong>if-else</strong> statement.</em></p>
    </div>
  );
};

export default BookDetails;
