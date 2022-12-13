package com.vehicleservice.Services;

import com.vehicleservice.Domain.VehiclesData;
import com.vehicleservice.Exception.VehicleAlreadyExistException;
import com.vehicleservice.Exception.VehicleNotExistException;

import java.util.List;

public interface IVehicleService {

    VehiclesData saveAllVehiclesDetails(VehiclesData adminData) throws VehicleAlreadyExistException;

    List<VehiclesData> fetchAllVehiclesDetails() throws VehicleNotExistException;

    boolean deleteVehicleDetailsById(int vehicleId) throws VehicleNotExistException;

    VehiclesData findByVehicleModel(String vehicleModel) throws VehicleNotExistException;
}
