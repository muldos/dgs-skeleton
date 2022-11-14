package fr.davidrobin.api.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UnsafeController {
    @GetMapping("/vulnerable-path")
    public String VulnerablePath(){
        return "Hello, I'm a vulnerability";
    }
}
