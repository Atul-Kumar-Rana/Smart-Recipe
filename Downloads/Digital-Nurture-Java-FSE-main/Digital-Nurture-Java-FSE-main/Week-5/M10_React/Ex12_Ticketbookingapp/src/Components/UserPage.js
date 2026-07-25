import React from 'react';

const UserPage = () => {
  return (
    <div style={{ padding: '20px', border: '1px solid green', marginTop: '20px', textAlign: 'left', maxWidth: '500px', margin: '20px auto' }}>
      <h2>User View: Book Tickets</h2>
      <p>Welcome back! You can now book tickets for your selected flights.</p>
      <form onSubmit={(e) => { e.preventDefault(); alert("Ticket Booked Successfully!"); }}>
        <label>
          Select Flight: 
          <select style={{ marginLeft: '10px', padding: '5px' }}>
            <option>Flight 101</option>
            <option>Flight 202</option>
            <option>Flight 303</option>
          </select>
        </label>
        <br /><br />
        <button style={{ padding: '10px 20px', backgroundColor: 'green', color: 'white', cursor: 'pointer', border: 'none' }}>
          Book Now
        </button>
      </form>
    </div>
  );
};

export default UserPage;
