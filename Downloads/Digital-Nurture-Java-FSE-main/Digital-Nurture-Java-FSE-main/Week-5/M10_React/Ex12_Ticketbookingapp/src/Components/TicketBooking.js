import React, { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

class TicketBooking extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  handleLoginClick = () => {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick = () => {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;
    
    // Using Element Variables to conditionally render the button
    let button;
    if (isLoggedIn) {
      button = <button onClick={this.handleLogoutClick} style={{ padding: '10px 20px', cursor: 'pointer' }}>Logout</button>;
    } else {
      button = <button onClick={this.handleLoginClick} style={{ padding: '10px 20px', cursor: 'pointer' }}>Login</button>;
    }

    return (
      <div style={{ textAlign: 'center', margin: '20px' }}>
        <h1>Welcome to Ticket Booking App</h1>
        
        {/* Render the element variable */}
        {button}
        
        {/* Conditional rendering for the specific page components */}
        {isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default TicketBooking;
