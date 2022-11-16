package fr.davidrobin.api.controller;

import fr.davidrobin.api.bean.EvalBean;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnsafeController {

    // JFrog research remediation
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        String[] blackList = { "class.*", "Class.*", "*.class.*", ".*Class.*" };
        binder.setDisallowedFields(blackList);
    }
    // Vulnerable code for CVE-2022-22965
    // https://jfrog.com/blog/springshell-zero-day-vulnerability-all-you-need-to-know/
    @RequestMapping("/vulnerable-path")
    public String VulnerablePath(EvalBean evalBean) {

        return "Hello, I'm a vulnerability : " + evalBean;
    }
}
