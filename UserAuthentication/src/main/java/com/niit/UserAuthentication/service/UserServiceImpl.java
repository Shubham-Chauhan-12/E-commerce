package com.niit.UserAuthentication.service;

import com.niit.UserAuthentication.Proxy.UserProxy;
import com.niit.UserAuthentication.domain.UserModel;
import com.niit.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    private UserRepository userRepository;
    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserProxy userProxy) {
        this.userRepository = userRepository;
        this.userProxy = userProxy;
    }

    @Override
    public UserModel addUser(UserModel user) throws UserAlreadyExistException {
        if (userRepository.findById(user.getUserId()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        else {
            return userRepository.save(user);
        }

    }

    @Override
    public UserModel loginCheckUser(String email, String password) {
        UserModel detail = userRepository.findByEmailAndPassword(email, password);
        return detail;
    }


    @Override
    public List<UserModel> fetchAllVehicles() {

        return userProxy.getProxy();
    }

    @Override
    public List<UserModel> fetchalluser() {
        return userRepository.findAll();
    }

    @Override
    public UserModel fetchByModel(String vehicleModel) {
//        userProxy.getProxy();
        return userProxy.searchVehicle(vehicleModel);
    }
}
