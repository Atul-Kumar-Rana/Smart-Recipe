import React, { Component } from 'react';

class CounterEvents extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  // Say Hello static message
  sayHello = () => {
    alert("Hello from React!");
  }

  // Increment value and invoke Say Hello
  handleIncrement = () => {
    this.setState((prevState) => ({
      counter: prevState.counter + 1
    }));
    this.sayHello();
  }

  // Decrement value
  handleDecrement = () => {
    this.setState((prevState) => ({
      counter: prevState.counter - 1
    }));
  }

  // Function which takes "welcome" as an argument
  sayWelcome = (msg) => {
    alert(msg);
  }

  // Synthetic event OnPress
  handleOnPress = (event) => {
    alert("I was clicked");
    console.log("Synthetic Event triggered: ", event);
  }

  render() {
    return (
      <div style={{ borderBottom: '2px solid #ccc', paddingBottom: '20px', marginBottom: '20px' }}>
        <h2>Event Handling Examples</h2>
        <h3>Counter: {this.state.counter}</h3>
        
        <div>
          <button onClick={this.handleIncrement} style={{ margin: '5px', padding: '10px', cursor: 'pointer' }}>
            Increment
          </button>
          <button onClick={this.handleDecrement} style={{ margin: '5px', padding: '10px', cursor: 'pointer' }}>
            Decrement
          </button>
        </div>
        
        <div style={{ marginTop: '20px' }}>
          <button onClick={() => this.sayWelcome("welcome")} style={{ margin: '5px', padding: '10px', cursor: 'pointer' }}>
            Say Welcome
          </button>
          
          <button onClick={this.handleOnPress} style={{ margin: '5px', padding: '10px', cursor: 'pointer' }}>
            OnPress Synthetic Event
          </button>
        </div>
      </div>
    );
  }
}

export default CounterEvents;
