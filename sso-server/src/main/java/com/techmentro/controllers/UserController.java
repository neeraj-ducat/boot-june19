package com.techmentro.controllers;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableResourceServer
@RestController
public class UserController {


@GetMapping("/user")
Principal getUser(Principal principal) {
    return principal;
}
}
