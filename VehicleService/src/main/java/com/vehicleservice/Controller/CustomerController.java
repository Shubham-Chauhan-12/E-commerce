package com.vehicleservice.Controller;

import com.vehicleservice.Domain.VehiclesData;
import com.vehicleservice.Exception.VehicleAlreadyExistException;
import com.vehicleservice.Exception.VehicleNotExistException;
import com.vehicleservice.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/v1")
public class CustomerController {

    private VehicleService customerService;

    @Autowired
    public CustomerController(VehicleService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save-details")
    public ResponseEntity<?> saveCustomers(@RequestBody VehiclesData adminDataObj) throws VehicleAlreadyExistException {
        try {
            return new ResponseEntity<>(customerService.saveAllVehiclesDetails(adminDataObj), HttpStatus.CREATED);
        }
        catch (VehicleAlreadyExistException e) {
            throw new VehicleAlreadyExistException();
        }

        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-details")
    public ResponseEntity<?> fetchAllCustomers() throws VehicleNotExistException {
        try {
            return new ResponseEntity<>(customerService.fetchAllVehiclesDetails(), HttpStatus.FOUND);
        }
        catch (VehicleNotExistException e) {
            throw new VehicleNotExistException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-customer/{custId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int custId) throws VehicleNotExistException {
        try {
            return new ResponseEntity<>(customerService.deleteVehicleDetailsById(custId),HttpStatus.ACCEPTED);
        }
        catch (VehicleNotExistException e){
            throw new VehicleNotExistException();
        }
        catch (Exception e){
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/get-byProduct/{prodName}")
    public ResponseEntity<?> fetchByProductName(@PathVariable String prodName) throws VehicleNotExistException {
        try {
            return new ResponseEntity<>(customerService.findAllCustomerFromProductName(prodName),HttpStatus.FOUND);
        }
        catch (VehicleNotExistException e){
            throw new VehicleNotExistException();
        }
        catch (Exception e ){
            return new ResponseEntity<>("Server Error!!!try after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
