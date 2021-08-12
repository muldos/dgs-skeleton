package fr.davidrobin.api.bean;

import org.springframework.stereotype.Component;

@Component
public class TechDetail {
    private String hostname;
    private String podName;
    private String podIp;

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getPodIp() {
        return podIp;
    }

    public void setPodIp(String podIp) {
        this.podIp = podIp;
    }

    private String authEndpoint;

    public String getAuthEndpoint() {
        return this.authEndpoint;
    }

    public void setAuthEndpoint(String authEndpoint) {
        this.authEndpoint = authEndpoint;
    }

    public String getHostname() {
        return this.hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

}
