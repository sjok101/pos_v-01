import React from "react";
import Navbar from './Navbar';
import Floor from './Floor';
import {BrowserRouter as Router,Route,Switch } from 'react-router-dom';
import Kitchen from './Kitchen';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <div className="content">
          <Switch>
           <Route path="/Tables">
             <Floor />
            </Route>

            <Route path="/Kitchen">
              <Kitchen />
            </Route>

          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;
