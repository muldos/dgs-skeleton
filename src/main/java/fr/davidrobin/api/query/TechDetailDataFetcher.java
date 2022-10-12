package fr.davidrobin.api.query;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import org.springframework.beans.factory.annotation.Value;

import fr.davidrobin.api.bean.TechDetail;

@DgsComponent
public class TechDetailDataFetcher {

    @Value("${app.pod.name}")
    private String podName;

    @Value("${app.pod.ip}")
    private String podIp;

    @DgsQuery
    public TechDetail diagnosis() {
        TechDetail t = new TechDetail();
        t.setPodIp(this.podIp);
        t.setPodName(this.podName);
        try {
            t.setHostname(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            t.setHostname("unknown with error");
        }
        return t;
    }
}
