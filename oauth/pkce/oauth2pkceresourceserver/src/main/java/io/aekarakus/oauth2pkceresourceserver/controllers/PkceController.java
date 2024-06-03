package io.aekarakus.oauth2pkceresourceserver.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PkceController {

    @GetMapping("/demo")
    public String pkceHello(){

        return "Hello fron PKCE!";
    }
}
