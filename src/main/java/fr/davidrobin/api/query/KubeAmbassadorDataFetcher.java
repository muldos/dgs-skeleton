package fr.davidrobin.api.query;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import org.springframework.beans.factory.annotation.Value;

import fr.davidrobin.api.bean.KubeAmbassador;

@DgsComponent
public class KubeAmbassadorDataFetcher {

    private static final String TOKEN_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/token";
    private static final String CERT_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/ca.crt";
    private static final String NAMESPACE_PATH = "/var/run/secrets/kubernetes.io/serviceaccount/namespace";

    @Value("${app.pod.name}")
    private String podName;

    @DgsQuery
    public KubeAmbassador kubeinfo() {
        // token path

        KubeAmbassador k = new KubeAmbassador();
        if (this.podName.equals("no pod name")) {// not running in k8s
            this.populateDummyData(k);
        } else {
            String token = "not found";
            String namespace = "not found";
            String cert = "not found";
            try {
                token = readFromInputStream(new FileInputStream(TOKEN_PATH));
                cert = readFromInputStream(new FileInputStream(CERT_PATH));
                namespace = readFromInputStream(new FileInputStream(NAMESPACE_PATH));
            } catch (Exception e) {
                System.err.println("error while getting k8s credentials data");

            }
            k.setToken(token);
            k.setCert(cert);
            k.setNamespace(namespace);
        }

        return k;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line);
            }
        }
        return resultStringBuilder.toString();
    }

    private void populateDummyData(KubeAmbassador k) {
        k.setToken("dummy token");
        k.setCert("dummy cert");
        k.setNamespace("dummy namespace");
    }
}
