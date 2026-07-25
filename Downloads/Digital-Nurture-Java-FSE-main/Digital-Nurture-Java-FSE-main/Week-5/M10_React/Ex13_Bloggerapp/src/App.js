import React, { Component } from 'react';
import BookDetails from './Components/BookDetails';
import BlogDetails from './Components/BlogDetails';
import CourseDetails from './Components/CourseDetails';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      showBook: true,
      showBlog: true,
      showCourse: true,
      selectedView: 'all' // 'all', 'book', 'blog', 'course'
    };
  }

  // Helper method for switch-case rendering
  renderSwitchComponent() {
    switch(this.state.selectedView) {
      case 'book':
        return <BookDetails />;
      case 'blog':
        return <BlogDetails />;
      case 'course':
        return <CourseDetails />;
      case 'all':
        return <p>Select a specific view below to test the switch statement.</p>;
      default:
        return null;
    }
  }

  render() {
    // 1. If-Else Conditional Rendering (using element variables)
    let bookComponent;
    if (this.state.showBook) {
      bookComponent = <BookDetails />;
    } else {
      bookComponent = <p>Book Details are hidden.</p>;
    }

    return (
      <div className="App" style={{ padding: '20px', maxWidth: '800px', margin: '0 auto' }}>
        <h1>ReactJS-HOL-13: Blogger App</h1>
        
        <h2>1. If-Else Statement</h2>
        {bookComponent}

        <h2>2. Ternary Operator</h2>
        {/* condition ? true : false */}
        {this.state.showBlog ? <BlogDetails /> : <p>Blog Details are hidden.</p>}

        <h2>3. Logical && Operator</h2>
        {/* condition && true */}
        {this.state.showCourse && <CourseDetails />}

        <hr style={{ margin: '40px 0' }} />

        <h2>4. Switch Statement Rendering</h2>
        <div style={{ marginBottom: '15px' }}>
          <button onClick={() => this.setState({ selectedView: 'book' })} style={{ margin: '5px', padding: '10px' }}>Show Book</button>
          <button onClick={() => this.setState({ selectedView: 'blog' })} style={{ margin: '5px', padding: '10px' }}>Show Blog</button>
          <button onClick={() => this.setState({ selectedView: 'course' })} style={{ margin: '5px', padding: '10px' }}>Show Course</button>
          <button onClick={() => this.setState({ selectedView: 'all' })} style={{ margin: '5px', padding: '10px' }}>Clear Selection</button>
        </div>
        
        {/* Evaluates the switch statement method */}
        {this.renderSwitchComponent()}

      </div>
    );
  }
}

export default App;
