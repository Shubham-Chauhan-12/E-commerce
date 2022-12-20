package com.niit.UserAuthentication.controller;

import com.niit.UserAuthentication.domain.UserModel;
import com.niit.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.UserAuthentication.service.SecurityTokenGenerator;
import com.niit.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RequestMapping("/userservice")
@RestController
@CrossOrigin
public class UserController
{
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?>  saveUser(@RequestBody UserModel userModel) throws UserAlreadyExistException {
        return  new ResponseEntity<>(userService.addUser(userModel), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody UserModel user ){
             Map<String, String> secretkey = new HashMap<>();

            System.out.println("1");
            UserModel unique = userService.loginCheckUser(user.getEmail(), user.getPassword());
            System.out.println("2");
            secretkey = securityTokenGenerator.generateToken(unique);
            System.out.println(secretkey);
            return new ResponseEntity<>(secretkey, HttpStatus.OK);


    }

    @GetMapping("/api/v1/userview-vehicle")
    public ResponseEntity<?> vehiclesView(){
            return new ResponseEntity<>(userService.fetchAllVehicles(),HttpStatus.OK);
    }

    @GetMapping("/api/v1/userview-vehicle/{vehicleModel}")
    public ResponseEntity<?> vehicleByModel(@PathVariable String vehicleModel){
        return new ResponseEntity<>(userService.fetchByModel(vehicleModel),HttpStatus.OK);
    }


    @GetMapping("/viewAll")
    public ResponseEntity<?> allUserView(){
        return new ResponseEntity<>(userService.fetchalluser(),HttpStatus.OK);
    }

}
