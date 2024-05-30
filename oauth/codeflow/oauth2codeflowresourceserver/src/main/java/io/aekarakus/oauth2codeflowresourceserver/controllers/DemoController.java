package io.aekarakus.oauth2codeflowresourceserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String demo(){
        return "This is from demo!";
    }
}
