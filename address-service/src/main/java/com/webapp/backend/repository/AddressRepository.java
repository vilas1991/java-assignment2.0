package com.webapp.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.backend.responce.Address;

@Repository
public interface AddressRepository  extends JpaRepository<Address, Long> {

}
