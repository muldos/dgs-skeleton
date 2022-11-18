package fr.davidrobin.api.controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsafeController {

    // JFrog research remediation
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        String[] blackList = { "class.*", "Class.*", "*.class.*", ".*Class.*" };
        binder.setDisallowedFields(blackList);
    }

    @GetMapping("/vulnerable-path")
    public String VulnerablePath() {

        return "Hello, I'm a vulnerability : " ;
    }
}
