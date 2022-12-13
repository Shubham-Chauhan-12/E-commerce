package com.vehicleservice.Services;

import com.vehicleservice.Domain.VehiclesData;
import com.vehicleservice.Exception.VehicleAlreadyExistException;
import com.vehicleservice.Exception.VehicleNotExistException;
import com.vehicleservice.Repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService implements IVehicleService {

    private VehiclesRepository vehiclesRepository;

    @Autowired
    public VehicleService(VehiclesRepository vehiclesRepository) {
        this.vehiclesRepository = vehiclesRepository;
    }




    @Override
    public VehiclesData saveAllVehiclesDetails(VehiclesData vehiclesData) throws VehicleAlreadyExistException {
        if (vehiclesRepository.findById(vehiclesData.getVehicleId()).isEmpty()){
            throw new VehicleAlreadyExistException();
        }
        return vehiclesRepository.save(vehiclesData);
    }

    @Override
    public List<VehiclesData> fetchAllVehiclesDetails() throws VehicleNotExistException {
        if (vehiclesRepository.findAll().isEmpty()){
            throw new VehicleNotExistException();
        }
        return vehiclesRepository.findAll();
    }

    @Override
    public boolean deleteVehicleDetailsById(int vehicleId) throws VehicleNotExistException {
        if (vehiclesRepository.findById(vehicleId).isEmpty()){
            throw new VehicleNotExistException();
        }
        vehiclesRepository.deleteById(vehicleId);
        return true;
    }

    @Override
    public VehiclesData updateVehicleDetails(VehiclesData vehiclesData) {
        VehiclesData vehiclesData1 = null;
        Optional<VehiclesData> vehiclesById = vehiclesRepository.findById(vehiclesData.getVehicleId());

        if (vehiclesById.isPresent()){
            vehiclesData1 = vehiclesById.get();
            vehiclesData1.setVehicleId(vehiclesData.getVehicleId());
            vehiclesData1.setVehicleBrand(vehiclesData.getVehicleBrand());
            vehiclesData1.setVehicleModel(vehiclesData.getVehicleModel());
            vehiclesData1.setVehicleVariant(vehiclesData.getVehicleVariant());
            vehiclesData1.setVehicleColor(vehiclesData.getVehicleColor());
            vehiclesData1.setManufactureYear(vehiclesData.getManufactureYear());
            vehiclesData1.setPrice(vehiclesData.getPrice());

        }else {
            return new VehiclesData();
        }
        return vehiclesData1;
    }

    @Override
     public VehiclesData findByVehicleModel(String prodName) throws VehicleNotExistException {
        if (vehiclesRepository.findByVehicleModel(prodName).getVehicleModel().isEmpty()){
            throw new VehicleNotExistException();
        }
        return vehiclesRepository.findByVehicleModel(prodName);
    }
}
