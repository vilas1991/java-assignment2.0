import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <>
    <Link to="/login" className="btn btn-outline-light mx-1">
      {/* <span classNameName="btn btn-outline-light m-1  my-sm-0 mx-1"> */}
      Login
      {/* </span> */}
    </Link>

    <Link to="/register" className="btn btn-outline-light mx-1">
      {/* <span classNameName="btn btn-outline-light m-1 my-sm-0 mx-1"> */}
      Register
      {/* </span> */}
    </Link>
  </>
  )
}

export default Header