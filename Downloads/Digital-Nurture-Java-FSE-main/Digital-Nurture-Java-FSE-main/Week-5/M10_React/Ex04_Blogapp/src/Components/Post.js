import React, { Component } from 'react';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => response.json())
      .then(data => {
        // Displaying the first 10 posts for simplicity
        this.setState({ posts: data.slice(0, 10) });
      })
      .catch(error => {
        console.error("Error fetching data: ", error);
      });
  }

  componentDidMount() {
    this.loadPosts();
  }

  componentDidCatch(error, errorInfo) {
    // As per the exercise requirements
    alert("An error occurred in the component: " + error.toString());
  }

  render() {
    return (
      <div style={{ textAlign: 'left', margin: '0 auto', maxWidth: '800px' }}>
        <h2>Latest Blog Posts</h2>
        {this.state.posts.map(post => (
          <div key={post.id} style={{ borderBottom: '1px solid #ccc', padding: '10px 0' }}>
            <h3 style={{ color: '#2c3e50', textTransform: 'capitalize' }}>{post.title}</h3>
            <p style={{ color: '#34495e' }}>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;
