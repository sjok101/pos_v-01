import React, {useState} from 'react';
import Popup from './components/Popups';

const Navbar = () => {
    let [floorNum,setFloorNum] = useState(1);
    const handleUp = () => {
        floorNum++;
        setFloorNum(floorNum);
      }
      const handleDown = () => {
        floorNum--;
        setFloorNum(floorNum);
      }

      const [buttonPopup, setButtonPopup] = useState(false);

    return (
      <nav className="navbar">
        <div className="links">
        <h1> Screens </h1> 
          <a href="/MainMenu" style={{ 
            padding: '10px',
            border: 'solid' ,
            backgroundColor: '#333',
          }}>Main Menu</a>
          <button onClick ={() => setButtonPopup(true)}  style={{ 
            padding: '10px',
            border: 'solid' ,
            backgroundColor: '#333', 
          }}>Edit Floor</button>
          <Popup trigger ={buttonPopup} setTrigger = {setButtonPopup}>
            <h3> poppppp</h3>
          </Popup>
          <a href="/CheckReserved" style={{ 
            padding: '10px',
            border: 'solid' ,
            backgroundColor: '#333', 
          }}> Check Reserved</a>
          <a href="/Kitchen" style={{ 
            padding: '10px',
            border: 'solid' ,
            backgroundColor: '#333',
          }}>Kitchen</a>
          <a href="/Tables" style={{ 
            padding: '10px',
            border: 'solid' ,
            backgroundColor: '#333',
          }}>Tables</a>
        </div>   
        <div className="Table">
        <h3> Tables </h3> 
        <button onClick ={handleUp} style={{
                //borderRadius: '20px',
                border: 'solid' ,
                padding: '10px',
                borderColor: '333',
            }}>addTable</button>
            <button onClick ={handleUp} style={{
                //borderRadius: '20px',
                border: 'solid' ,
                padding: '10px',
                borderColor: '333',
            }}>MoveTable</button>
        </div>   
        <div className="MFloor">
        <h2>Floor {floorNum} </h2> 
          <button onClick ={handleUp} style={{
                //borderRadius: '20px',
                border: 'solid' ,
                padding: '10px',
                borderColor: '333',
            }}>UP</button>
            <button onClick ={handleDown} style={{
                //borderRadius: '20px',
                border: 'solid',
                padding: '10px',
                borderColor: '333',
            }}>DOWN</button>  

        </div>
      </nav>
    );
  }
   
  export default Navbar;