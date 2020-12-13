package com.capgemini.employeepayroll.controllers;

import com.capgemini.employeepayroll.dtos.UserDTO;
import com.capgemini.employeepayroll.interfaces.IUser;
import com.capgemini.employeepayroll.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/user")
public class UserLoginController {

    @Autowired
    private IUser userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Response> loginUser(@Valid @RequestBody UserDTO userdto){
        Response response =userService.loginUser(userdto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
