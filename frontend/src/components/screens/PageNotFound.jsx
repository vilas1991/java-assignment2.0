import React from 'react'
import { Container } from 'reactstrap'

const PageNotFound = () => {
  return (
    <Container className="my-5">
    <Container className="py-5">
      <div class="row">
        <div class="col-md-12">
          <div class="error-template text-center">
            <h1>Oops!</h1>
            <h2>404 Not Found</h2>
            <div class="error-details">
              Sorry, an error has occured, Requested page not found!
            </div>
          </div>
        </div>
      </div>
    </Container>
  </Container>
  )
}

export default PageNotFound