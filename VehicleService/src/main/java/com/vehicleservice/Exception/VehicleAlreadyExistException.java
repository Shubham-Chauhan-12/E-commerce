package com.vehicleservice.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Same Vehicle already exist with the entries , please try with different entries !")
public class VehicleAlreadyExistException extends Exception{
}
