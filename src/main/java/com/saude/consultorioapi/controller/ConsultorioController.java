package com.saude.consultorioapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultorioController {

    @GetMapping
    public String init(){
        return "Hello, World!";
    }
}

