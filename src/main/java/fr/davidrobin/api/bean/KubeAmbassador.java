package fr.davidrobin.api.bean;

import org.springframework.stereotype.Component;

@Component
public class KubeAmbassador {
    private String token;
    private String namespace;
    private String cert;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getCert() {
        return cert;
    }

    public void setCert(String cert) {
        this.cert = cert;
    }
}
