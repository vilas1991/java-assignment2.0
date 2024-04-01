import React from 'react';
import { useLocation } from 'react-router-dom';

const UserScreen = () => {
    const location = useLocation();
    const userData = location.state.userData;

    console.log("user data", userData);

    return (
        <div className="card">
      <div className="card-body">
        <h2 className="card-title">User Data</h2>
        <p className="card-text"><strong>User Name:</strong> {userData.username}</p>
        <p className="card-text"><strong>DOB:</strong> {userData.dob}</p>
        <p className="card-text"><strong>Phone Number:</strong> {userData.phoneNumber}</p>
        <p className="card-text"><strong>Current Time:</strong> {new Date().toLocaleString()}</p>
        <p className="card-text"><strong>Address:</strong> {userData.addressResponse.addressLineFirst}, {userData.addressResponse.addressLineSecond}, {userData.addressResponse.postalCode}</p>
      </div>
    </div>
    );
};

export default UserScreen;
