package com.test.SpringBootApplication.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping({"/home","/"})
    public String getFrontend() {
        return "index";
    }
}