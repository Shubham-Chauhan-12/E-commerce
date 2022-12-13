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
        if (userRepository.findById(user.getEmailId()).isPresent()) {
            throw new UserAlreadyExistException();
        }
        else {
            return userRepository.save(user);
        }

    }

    @Override
    public UserModel loginCheck(String email, String userPassword) throws UserNotFoundException
    {
        UserModel user = userRepository.findByEmailIdAndPassword(email,userPassword);
        if(user!=null){ //authentication is ok
            return user;
        }
        else{ // authentication failed
            throw new UserNotFoundException();
        }

    }

    @Override
    public List<UserModel> fetchAllVehicles() {

        return userProxy.getProxy();
    }
    @Override
    public UserModel fetchByModel(String vehicleModel) {
        return userProxy.searchVehicle(vehicleModel);
    }
}
