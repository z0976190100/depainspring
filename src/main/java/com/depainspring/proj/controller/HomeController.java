package com.depainspring.proj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

        @GetMapping("/")
        public String indexResponse(){
            String indexResponse = "index";
            return indexResponse;
        }

    @PostMapping("/users")
    public String usersResponse(){
        String indexResponse = "index";
        return indexResponse;
    }
}
