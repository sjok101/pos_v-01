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

 <Button onClick={sayHello}>
Disabled Button
</Button> 

function App() {
  return (
    <div className="App">
      <HeaderBar />
        <div className='content'>
          <Home />
          <button type="button" onClick={sayHello}>Click Me</button>
          
          </div>
        
      
    </div>
  );
}

export default App;
