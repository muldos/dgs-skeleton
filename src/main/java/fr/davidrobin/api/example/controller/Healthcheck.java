package fr.davidrobin.api.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Healthcheck {
    @ResponseBody
    @GetMapping("/health")
	public String healthy() {
		return "health : ok";
	}
}
