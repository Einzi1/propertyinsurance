package de.ergo.propertyinsurance.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class PingController {

    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }
}