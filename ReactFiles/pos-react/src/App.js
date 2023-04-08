import React from 'react';
import './App.css';
import styled, { createGlobalStyle, keyframes, css } from "styled-components";
import HeaderBar from './HeaderBar';
import Home from './Home';



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
    <React.Fragment>
      <HeaderBar />
      <Home />
      
    </React.Fragment>
  );
}

export default App;
