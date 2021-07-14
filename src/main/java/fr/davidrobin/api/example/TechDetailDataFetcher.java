package fr.davidrobin.api.example;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

@DgsComponent
public class TechDetailDataFetcher {
    @DgsQuery
    public TechDetail diagnosis() {
        TechDetail t = new TechDetail();
        try {
            t.setHostname(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            t.setHostname("unknown with error");
        }
        return t;
    }
}
