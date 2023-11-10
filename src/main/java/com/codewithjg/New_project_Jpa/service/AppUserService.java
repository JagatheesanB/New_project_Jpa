package com.codewithjg.New_project_Jpa.service;


import com.codewithjg.New_project_Jpa.model.AppUser;
import com.codewithjg.New_project_Jpa.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;


    public AppUser login(AppUser appUser) {
        return appUserRepository.findUserByUserNameAndPassword
                (appUser.getUsername(), appUser.getPassword());
    }

    public AppUser register(AppUser appUser) {
        appUserRepository.save(appUser);
        return appUser;
    }
}
