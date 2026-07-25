import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      inr: '',
      euro: null
    };
  }

  handleInputChange = (event) => {
    this.setState({ inr: event.target.value });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    // Assuming 1 Euro = ~90 INR for simple conversion
    const inrValue = parseFloat(this.state.inr);
    
    if (!isNaN(inrValue)) {
      const euroValue = inrValue / 90;
      this.setState({ euro: euroValue.toFixed(2) });
    } else {
      alert("Please enter a valid amount");
    }
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label style={{ fontSize: '18px' }}>
            Indian Rupees (INR): 
            <input 
              type="number" 
              value={this.state.inr} 
              onChange={this.handleInputChange} 
              style={{ marginLeft: '10px', padding: '5px' }}
            />
          </label>
          <button type="submit" style={{ marginLeft: '10px', padding: '5px 10px', cursor: 'pointer' }}>
            Convert to Euro
          </button>
        </form>
        
        {this.state.euro !== null && (
          <div style={{ marginTop: '15px' }}>
            <h3 style={{ color: 'green' }}>Equivalent Euro: € {this.state.euro}</h3>
          </div>
        )}
      </div>
    );
  }
}

export default CurrencyConvertor;
