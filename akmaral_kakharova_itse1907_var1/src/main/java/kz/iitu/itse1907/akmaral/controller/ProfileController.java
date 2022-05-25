package kz.iitu.itse1907.akmaral.controller;


import kz.iitu.itse1907.akmaral.model.Profile;
import kz.iitu.itse1907.akmaral.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    Logger logger = LoggerFactory.getLogger(ProfileService.class);

    private ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/allProfiles")
    @ResponseStatus(HttpStatus.OK)
    public List<Profile> findAll() throws InterruptedException {

        return profileService.findAll();
    }


}
