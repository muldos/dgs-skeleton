package fr.davidrobin.api.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/health")
public class Healthcheck {
	private Boolean status = Boolean.TRUE;
    @ResponseBody
    @GetMapping("/status")
	public ResponseEntity<String> healthy() {
		ResponseEntity<String> response = (this.status) ? new ResponseEntity<String>("ok",HttpStatus.OK) : new ResponseEntity<String>("ko",HttpStatus.SERVICE_UNAVAILABLE);
		return response;
	}

	@ResponseBody
    @GetMapping("/off")
	public String setOff() {
		this.status = Boolean.FALSE;
		return "health status was set off";
	}

	@ResponseBody
    @GetMapping("/on")
	public String setOn() {
		this.status = Boolean.TRUE;
		return "health status was set on";
	}
}
