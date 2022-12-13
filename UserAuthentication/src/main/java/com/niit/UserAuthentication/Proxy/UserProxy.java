package com.niit.UserAuthentication.Proxy;

import com.niit.UserAuthentication.domain.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "adminData-services",url = "adminData-services:8086")
public interface UserProxy {
    @GetMapping("/vehicles/v1/get-vehicle")
    List<UserModel> getProxy();

    @GetMapping("/vehicles/v1/get-byModel/{vehicleModel}")
    UserModel searchVehicle(@PathVariable String vehicleModel);
}
