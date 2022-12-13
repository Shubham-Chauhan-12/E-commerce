package com.vehicleservice.Services;

import com.vehicleservice.Domain.VehiclesData;
import com.vehicleservice.Exception.VehicleAlreadyExistException;
import com.vehicleservice.Exception.VehicleNotExistException;

import java.util.List;

public interface IVehicleService {

    VehiclesData saveAllVehiclesDetails(VehiclesData vehiclesData) throws VehicleAlreadyExistException;

    List<VehiclesData> fetchAllVehiclesDetails() throws VehicleNotExistException;

    boolean deleteVehicleDetailsById(int vehicleId) throws VehicleNotExistException;

    VehiclesData updateVehicleDetails(VehiclesData vehiclesData);

    VehiclesData findByVehicleModel(String vehicleModel) throws VehicleNotExistException;
}
