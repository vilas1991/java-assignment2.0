import React, { useState } from 'react';
import axios from 'axios';
import "./common.css"

const RegisterScreen = () => {
    const [userName, setUserName] = useState("");
    const [pass, setPass] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [dob, setDob] = useState("");
    const [phoneNo, setPhoneNo] = useState("");
    const [valid, setValid] = useState("invalid");
    const [role, setRole] = useState("user");
    const [errors, setErrors] = useState({});
    
    
    const [addressId, setAddressId] = useState();
    const [ addressLineFirst, setAddressLineFirst] = useState("");
    const [addressLineSecond, setAddressLineSecond] = useState("");
    const [postalcode, setPostalCode] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        if (validateForm()) {
            try {

                
                // const res = await axios.post('http://addressservice:8082/api/address/create', {
                //     addressLineFirst: addressLineFirst,
                //     addressLineSecond: addressLineSecond,
                //     postalCode: postalcode,
                // });

                // setAddressId(res.data.addressId)
                // console.log(res.data.addressId)


                
                    const response = await axios.post('http://localhost:8083/api/users/create', {
                    username: userName,
                    password: pass,
                    firstName: firstName,
                    lastName: lastName,
                    dob: dob,
                    addressLineFirst: addressLineFirst,
                    addressLineSecond: addressLineSecond,
                    postalCode: postalcode,
                    phoneNumber: phoneNo,
                    valid:valid,
                    role:role
                });

                
                alert('Registration successful!');
                setUserName("")
                setPass("")
                setFirstName("")
                setLastName("")
                setDob("")
                setPhoneNo("")

                setAddressLineFirst("")
                setAddressLineSecond("")
                setPostalCode("")

                // onRegister(response.data);
            } catch (error) {
                console.error('Registration failed:', error);
            }
        }
    };

    const validateForm = () => {
        let isValid = true;
        const errors = {};

        // Username validation
        if (!userName) {
            errors.username = 'Username is required';
            isValid = false;
        } else if (!/^[a-zA-Z]+$/.test(userName)) {
            errors.username = 'Username should not contain numbers';
            isValid = false;
        }

        // Password validation
        if (!pass) {
            errors.password = 'Password is required';
            isValid = false;
        } else if (!/^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]+)$/.test(pass)) {
            errors.password = 'Password should have letters and numbers';
            isValid = false;
        }

        // First name validation
          // First name validation
          if (!firstName) {
            errors.firstName = 'First Name is required';
            isValid = false;
        } else if (!/^[a-zA-Z]+$/.test(firstName)) {
            errors.firstName = 'First Name should only contain letters';
            isValid = false;
        }

        // Last name validation
        if (!lastName) {
            errors.lastName = 'Last Name is required';
            isValid = false;
        } else if (!/^[a-zA-Z]+$/.test(lastName)) {
            errors.lastName = 'Last Name should only contain letters';
            isValid = false;
        }

        // DOB validation
        if (!dob) {
            errors.dob = 'Date of Birth is required';
            isValid = false;
        }

        // Address validation
        // if (!address) {
        //     errors.address = 'Address is required';
        //     isValid = false;
        // }

        // Postal code validation
        if (!postalcode) {
            errors.postalcode = 'Postal Code is required';
            isValid = false;
        }

        // Phone number validation
        if (!phoneNo) {
            errors.phoneNo = 'Phone Number is required';
            isValid = false;
        } else if (!/^\d+$/.test(phoneNo)) {
            errors.phoneNo = 'Phone Number should be numerical';
            isValid = false;
        }

        setErrors(errors);
        return isValid;
    };

    return (
        <div className="container mt-5">
            <h2>Registration Form</h2>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="username" className="form-label">Username</label>
                    <input type="text" className="form-control" id="username" value={userName} onChange={(e) => setUserName(e.target.value)} placeholder="Enter username" />
                    {errors.username && <div className="error" >{errors.username}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" className="form-control" id="password" value={pass} onChange={(e) => setPass(e.target.value)} placeholder="Enter password" />
                    {errors.password && <div className="error">{errors.password}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="firstName" className="form-label">First Name</label>
                    <input type="text" className="form-control" id="firstName" value={firstName} onChange={(e) => setFirstName(e.target.value)} placeholder="Enter first name" />
                    {errors.firstName && <div className="error">{errors.firstName}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="lastName" className="form-label">Last Name</label>
                    <input type="text" className="form-control" id="lastName" value={lastName} onChange={(e) => setLastName(e.target.value)} placeholder="Enter last name" />
                    {errors.lastName && <div className="error">{errors.lastName}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="dob" className="form-label">Date of Birth</label>
                    <input type="text" className="form-control" id="dob" value={dob} onChange={(e) => setDob(e.target.value)} placeholder="Enter date of birth" />
                    {errors.dob && <div className="error">{errors.dob}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="address" className="form-label">Address line1</label>
                    <input type="text" className="form-control" id="address" value={addressLineFirst} onChange={(e) => setAddressLineFirst(e.target.value)} placeholder="Enter address" />
                    {errors.address && <div className="error">{errors.address}</div>}
                </div>
                <div className="mb-3">
                    <label htmlFor="address" className="form-label">Address line 2</label>
                    <input type="text" className="form-control" id="address" value={addressLineSecond} onChange={(e) => setAddressLineSecond(e.target.value)} placeholder="Enter address" />
                    {/* {errors.address && <div className="error">{errors.address}</div>} */}
                </div>
                <div className="row mb-3">
                    <div className="col">
                        <label htmlFor="postalcode" className="form-label">Postal Code</label>
                        <input type="text" className="form-control" id="postalcode" value={postalcode} onChange={(e) => setPostalCode(e.target.value)} placeholder="Enter postal code" />
                        {errors.postalcode && <div className="error">{errors.postalcode}</div>}
                    </div>
                    <div className="col">
                        <label htmlFor="phoneNo" className="form-label">Phone Number</label>
                        <input type="text" className="form-control" id="phoneNo" value={phoneNo} onChange={(e) => setPhoneNo(e.target.value)} placeholder="Enter phone number" />
                        {errors.phoneNo && <div className="error">{errors.phoneNo}</div>}
                    </div>
                    <div className="mb-3">
                    <label htmlFor="role" className="form-label">Role</label>
                    <select className="form-select" id="role" value={role} onChange={(e) => setRole(e.target.value)}>
                        <option value="user">User</option>
                        <option value="admin">Admin</option>
                    </select>
                </div>
                </div>
                <button type="submit" className="btn btn-primary">Register</button>
            </form>
        </div>
    );
};

export default RegisterScreen;
