import logo from './logo.svg';
import './App.css';
import {createBrowserRouter, RouterProvider, Route} from "react-router-dom";
import Login from "./components/pages/login/login";
import Inventories from "./components/pages/inventories/inventories";
import Kitchens from "./components/pages/kitchens/kitchens";
import Overview from "./components/pages/overview/overview";

const router =  createBrowserRouter([
    {
      path: "/",
      element: (<Login />)
    },
    {
      path: "/login",
      element: (<Login/>)
    },
    {
      path: "/inventories",
      element: (<Inventories/>)
    },
    {
      path: "/kitchens",
      element: (<Kitchens/>)
    },
    {
      path: "/overview",
      element: (<Overview/>)
    }
  ]);

function App() {
  return (
    <div className="App">
      <RouterProvider router={router}/>
    </div>
  );
}

export default App;
