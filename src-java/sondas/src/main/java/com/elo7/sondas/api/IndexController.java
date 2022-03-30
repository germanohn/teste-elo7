package com.elo7.sondas.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController  {

    @GetMapping()
    public String get() {
        return "API das Sondas";
    }
}
