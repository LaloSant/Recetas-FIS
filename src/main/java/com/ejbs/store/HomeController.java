package com.ejbs.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home", "/welcome"})
    public String index() {
        return "index.html";
    }

}
