package fr.davidrobin.api.controller;
import fr.davidrobin.api.bean.EvalBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsafeController {
    @RequestMapping("/vulnerable-path")
    public String VulnerablePath(EvalBean evalBean){
        return "Hello, I'm a vulnerability : " + evalBean;
    }
}
