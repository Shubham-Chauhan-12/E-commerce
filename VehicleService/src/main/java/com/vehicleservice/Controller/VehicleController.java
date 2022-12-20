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
@RequestMapping("/vehicles/v1")
@CrossOrigin
public class VehicleController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/save-vehicle")
    public ResponseEntity<?> saveVehicleDetail(@RequestBody VehiclesData adminDataObj) throws VehicleAlreadyExistException {
        try {
            return new ResponseEntity<>(vehicleService.saveAllVehiclesDetails(adminDataObj), HttpStatus.CREATED);
        }
        catch (VehicleAlreadyExistException e) {
            throw new VehicleAlreadyExistException();
        }

        catch (Exception e){
            return new ResponseEntity<>("OOps Server Error! please try again after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/get-vehicle")
    public ResponseEntity<?> fetchAllVehicles() throws VehicleNotExistException {
        try {
            return new ResponseEntity<>(vehicleService.fetchAllVehiclesDetails(), HttpStatus.OK);
        }
        catch (VehicleNotExistException e) {
            throw new VehicleNotExistException();
        }
        catch (Exception e) {
            return new ResponseEntity<>("OOps Server Error! please try again after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-vehicle/{vehicleId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int vehicleId) throws VehicleNotExistException {
        try {
            return new ResponseEntity<>(vehicleService.deleteVehicleDetailsById(vehicleId),HttpStatus.ACCEPTED);
        }
        catch (VehicleNotExistException e){
            throw new VehicleNotExistException();
        }
        catch (Exception e){
            return new ResponseEntity<>("OOps Server Error! please try again after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update-vehicle")
    public ResponseEntity<?> updateVehicleDetail(@RequestBody VehiclesData vehiclesData){
        return new ResponseEntity<>(vehicleService.updateVehicleDetails(vehiclesData),HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-byModel/{vehicleModel}")
    public ResponseEntity<?> fetchByVehicleModel(@PathVariable String vehicleModel) {

            return new ResponseEntity<>(vehicleService.findByVehicleModel(vehicleModel),HttpStatus.OK);


    }
}
