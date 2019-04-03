package de.ergo.propertyinsurance.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(path = "/ping")
    public String ping() {
        return "pong";
    }
}
