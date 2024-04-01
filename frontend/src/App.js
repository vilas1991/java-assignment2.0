import logo from "./logo.svg";
import "./App.css";
import HomeScreen from "./components/screens/HomeScreen";
import LoginScreen from "./components/screens/LoginScreen";
import RegisterScreen from "./components/screens/RegisterScreen";
import AdminScreen from "./components/screens/AdminScreen";
// import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from "./components/header/Header";
import PageNotFound from "./components/screens/PageNotFound";
import {
  BrowserRouter as Router,
  Route,
  Link,
  Switch,
  Routes,
  Navigate,
  useNavigate,
} from "react-router-dom";
import UserScreen from "./components/screens/UserScreen";
import { useEffect, useState } from "react";

function App() {

  const [role, setRole] = useState(localStorage.getItem("userInfo"));


  // const [userLogin, setUserLogin] = useState("");
  
  // const [userInfo, setUserInfo] = useState("")

  //get userinfo from local storage
  
// useEffect(() => {
 

//   }, [userLogin])
  // let role = localStorage.getItem("userInfo");
  // setUserLogin(role)
 
  

  // const handleLogout = () => {
  //   localStorage.removeItem("userInfo");
  //   // setUserLogin("")
  //   role=""
  //   Navigate('/login');
  // };
  const handleLogout = () => {
    localStorage.removeItem("userInfo");
    setRole(null);
    // Redirect to login page
    window.location.href = "/login";
};



  return (
    <>
    <Router>
      <div>

      {role && (
          <button onClick={handleLogout} className="btn btn-danger">Logout</button>
        )}
        {/* Centralized container for login and register links */}
        <div className="d-flex justify-content-center mt-4">
          {/* Conditionally render login and register links if logged out */}
          {!role && (
            <nav>
              <ul className="list-unstyled d-flex">
                <li className="mx-2">
                  <Link to="/login" className="btn btn-primary">Login</Link>
                </li>
                <li className="mx-2">
                  <Link to="/register" className="btn btn-success">Register</Link>
                </li>
              </ul>
            </nav>
          )}
        </div>

        {role === "admin" ? (
          <>
            <Routes>
              <Route path="/admin" element={<AdminScreen />} />
            </Routes>
            </>
        ) :
        
        
        role === "user" ? (
         <>
          {/* <Link to="/login" onClick={handleLogout}>Logout</Link>  */}
          {/* <button onClick={handleLogout}>Logout</button>  */}
          <Routes>
            <Route path="/userdata" element={<UserScreen />} />
            
          </Routes>
          </>
        ) : (
          <>

{/* <nav>
              <ul>
                <li>
                  <Link to="/login">Login</Link>
                </li>
                <li>
                  <Link to="/register">Register</Link>
                </li>
              </ul>
            </nav> */}

            <Routes>
              <Route path="/login" element={<LoginScreen />} />
              <Route path="/register" element={<RegisterScreen />} />
              <Route exact path="" element={<HomeScreen />} />
              {/* <Route exact path="*" element={<PageNotFound />} /> */}
            </Routes>
            </>
        )}
      </div>
    </Router>


    


</>
    
  );
}

export default App;
