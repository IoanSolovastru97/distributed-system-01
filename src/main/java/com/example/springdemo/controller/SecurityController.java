package com.example.springdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@CrossOrigin
public class SecurityController {

    @RequestMapping(value = "/healthcare/login", method = RequestMethod.GET)
    @ResponseBody
    public Principal currentUserName(Principal principal) {
        return principal;
    }
}