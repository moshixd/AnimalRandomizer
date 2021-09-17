package com.animalRandomizer.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // Endpoint that maps to greeting() method
    // @RequestParam binds value of query string param 'name' into 'name'
    // Value of 'name' is added to Model object - making it accessible to View Template
    // Thymeleaf performs server-side rendering of HTML
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required = false,
    defaultValue = "world") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
