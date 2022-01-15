package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "<body style=text-align:center><h1 >Welcome to transilation api</h1><p style=margin:10px 5px 15px 20px>Here you find the way of making transilation to any language you choose<p/></body>";

    }
}
