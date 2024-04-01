import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginScreen = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8083/api/users/login', {
                username: username,
                password: password
            });
            const userData = response.data;
            localStorage.setItem('userInfo', response.data.role);
            console.log(userData)
            if (userData.role==="user") {
                navigate('/userdata', { state: { userData: userData } });
                
            } else {
                // navigate('/admin', { state: { userData: userData } });
                window.location.href = "/admin";
            }
        } catch (error) {
            setError('Invalid username or password');
        }
    };

    return (
        <div className="container d-flex justify-content-center align-items-center" style={{ minHeight: "100vh" }}>
        <div className="card p-4">
          <h2 className="text-center mb-4">Login</h2>
          <form onSubmit={handleSubmit}>
            <div className="mb-3">
              <label className="form-label">Username:</label>
              <input type="text" className="form-control" value={username} onChange={(e) => setUsername(e.target.value)} required />
            </div>
            <div className="mb-3">
              <label className="form-label">Password:</label>
              <input type="password" className="form-control" value={password} onChange={(e) => setPassword(e.target.value)} required />
            </div>
            <button type="submit" className="btn btn-primary">Login</button>
          </form>
          {error && <p className="mt-3 text-danger">{error}</p>}
        </div>
      </div>
    );
};

export default LoginScreen;
