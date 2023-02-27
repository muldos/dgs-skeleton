package fr.davidrobin.api.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsafeController {
    @RequestMapping("/vulnerable-path")
    public String VulnerablePath(){
        return "Hello, I'm not a vulnerability " ;
    }
}
