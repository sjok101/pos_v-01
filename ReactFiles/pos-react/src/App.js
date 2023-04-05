import logo from './logo.svg';
import './App.css';
import styled, { createGlobalStyle, keyframes, css } from "styled-components";

const Button = styled.button`
  background-color: black;
  color: white;
  font-size: 20px;
  padding: 10px 60px;
  border-radius: 5px;
  margin: 10px 0px;
  cursor: pointer;
`
;
// Usage


function sayHello() {
  alert('You clicked me!');
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          hey guys.
          <Button onClick={sayHello}>
            Disabled Button
          </Button>
        </p>
        
      </header>
    </div>
  );
}

export default App;
