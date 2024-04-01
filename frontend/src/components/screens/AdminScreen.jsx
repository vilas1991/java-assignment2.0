import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Navigate, useLocation } from 'react-router-dom';


const AdminScreen = () => {
    const [users, setUsers] = useState([]);
    const [selectedUserId, setSelectedUserId] = useState(null);
    const [loading, setLoading] = useState(true);

    // const location = useLocation();
    // const userData = location.state.userData;
    // console.log(userData)

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        try {
            const response = await axios.get('http://localhost:8083/api/users');
            setUsers(response.data);
            console.log("msg", response.data)
            setLoading(false);
        } catch (error) {
            console.error('Error fetching users:', error);
        }
    };

    

    const handleSubmitValidation = async (user) => {
        try {
            const response = await axios.put(`http://localhost:8083/api/users/update/${user.id}`, {
                userId: user.id,
                username: user.username,
                password: user.password,
                firstName: user.firstName,
                lastName: user.lastName,
                dob: user.dob,
                address: user.address,
                postalCode: user.postalCode,
                phoneNumber: user.phoneNumber,
                valid: "valid",
                role: user.role
            });
            const updatedUser = response.data;
            setUsers(users.map(user => user.id === updatedUser.id ? updatedUser : user));
        } catch (error) {
            console.error('Error submitting validation:', error);
        }
    };

    const handleCheckboxChange = (userId, isChecked) => {
        if (isChecked) {
            setSelectedUserId(userId);
        } else {
            setSelectedUserId(null);
        }
    };

    const handleLogout = () => {
        localStorage.removeItem("userInfo");
        // Redirect to login page
        return <Navigate to="/login" />;
    };

    if (loading) {
        return <p>Loading...</p>;
    }

    return (
        <div>
            <h2>Admin Page</h2>
            {/* <button onClick={handleLogout}>Logout</button> */}
            <table className="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>DOB</th>
                        <th>Phone Number</th>
                        <th>Status</th>
                        <th>Validation</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {users.map(user => (
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.username}</td>
                            <td>{user.firstName}</td>
                            <td>{user.lastName}</td>
                            <td>{user.dob}</td>
                            <td>{user.phoneNumber}</td>
                            <td>{user.valid === "invalid" ? "✘" : "✔"}</td>
                            <td>
                                {user.valid === "invalid" ?
                                    <input
                                        type="checkbox"
                                        checked={user.validated}
                                        onChange={(e) => handleCheckboxChange(user.id, e.target.checked)}
                                    />
                                    : null}
                            </td>
                            <td>
                                {user.valid === "invalid" ?
                                    <button
                                        onClick={() => handleSubmitValidation(user)}
                                        disabled={!selectedUserId || selectedUserId !== user.id}>
                                        Submit Validation
                                    </button>
                                    : null}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default AdminScreen;
