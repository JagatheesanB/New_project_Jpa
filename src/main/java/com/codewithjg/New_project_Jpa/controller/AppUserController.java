package com.codewithjg.New_project_Jpa.controller;

import com.codewithjg.New_project_Jpa.model.AppUser;
import com.codewithjg.New_project_Jpa.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/login")
    public AppUser loginUser(@RequestBody AppUser appUser){
        return appUserService.login(appUser);
    }

    @PostMapping("/register")
    public AppUser registerUser(@RequestBody AppUser appUser){
        return appUserService.register(appUser);
    }


}
