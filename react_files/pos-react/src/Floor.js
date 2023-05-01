import React from "react";
const Floor = () => {
    var floor = document.getElementByID("floor");
    const addTable = () => {
      floor.addTable();
    }


    return (
      <div className="Floor">
        <h2>Floor</h2>
        <div className="Table">
          <h3>table </h3>
        </div>
      </div>
    );
  }
   
  export default Floor;