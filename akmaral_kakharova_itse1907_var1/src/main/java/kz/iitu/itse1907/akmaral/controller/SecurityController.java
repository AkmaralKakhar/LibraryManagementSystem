package kz.iitu.itse1907.akmaral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class SecurityController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

}
