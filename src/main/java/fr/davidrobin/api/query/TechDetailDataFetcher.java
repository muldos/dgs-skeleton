package fr.davidrobin.api.query;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;

import fr.davidrobin.api.bean.TechDetail;

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
