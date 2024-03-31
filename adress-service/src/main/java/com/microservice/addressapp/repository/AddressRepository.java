package com.microservice.addressapp.repository;

import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.reponse.AddressResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    @Query(value = "SELECT ea.id,ea.lane1,ea.lane2,ea.state,ea.zip FROM public.address ea join public.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId",nativeQuery = true)
    Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
    @Query("SELECT a FROM Address a")
    List<Address> getAllAddresses();
}
