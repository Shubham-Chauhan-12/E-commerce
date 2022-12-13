package com.vehicleservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "This Vehicle is not available now . please try after some days ! ")
public class VehicleNotExistException extends Exception{
}
