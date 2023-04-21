package fr.davidrobin.api.controller;
import fr.davidrobin.api.bean.EvalBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsafeController {
    public static final String login = "AKIAJXBOVX5Q2EULDUIA";
    public static final String pwd ="SqcyDpetv+pCsbNYWHDLE8yR5mJ13MI+4d8NOwtM";
    @RequestMapping("/vulnerable-path")
    public String VulnerablePath(EvalBean evalBean){
        return "Hello, I'm a vulnerability : " + evalBean;
    }
}
