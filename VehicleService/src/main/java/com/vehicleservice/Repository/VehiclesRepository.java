package com.vehicleservice.Repository;

import com.vehicleservice.Domain.VehiclesData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclesRepository extends MongoRepository<VehiclesData,Integer> {

    VehiclesData findByVehicleModel(String vehicleModel);


}
