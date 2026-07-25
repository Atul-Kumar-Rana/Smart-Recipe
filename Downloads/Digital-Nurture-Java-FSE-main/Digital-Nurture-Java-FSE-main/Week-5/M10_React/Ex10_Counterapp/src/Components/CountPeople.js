import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    // Initialize the state with entrycount and exitcount as 0
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  // Method to increase the entrycount value by 1
  updateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  }

  // Method to increase the exitcount value by 1
  updateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2>People Counter</h2>
        
        <div>
          <button 
            onClick={this.updateEntry} 
            style={{ padding: '10px 20px', margin: '10px', fontSize: '16px', cursor: 'pointer' }}
          >
            Login
          </button>
          
          <button 
            onClick={this.updateExit} 
            style={{ padding: '10px 20px', margin: '10px', fontSize: '16px', cursor: 'pointer' }}
          >
            Exit
          </button>
        </div>

        <div style={{ marginTop: '30px' }}>
          <h3>Entry Count: {this.state.entrycount}</h3>
          <h3>Exit Count: {this.state.exitcount}</h3>
        </div>
      </div>
    );
  }
}

export default CountPeople;
