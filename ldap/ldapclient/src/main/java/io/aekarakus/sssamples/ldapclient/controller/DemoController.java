package io.aekarakus.sssamples.ldapclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public String hello(){
        return "Hello world!";
    }
}
