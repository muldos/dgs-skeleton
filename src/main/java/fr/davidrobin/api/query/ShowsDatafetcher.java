package fr.davidrobin.api.query;

import java.util.List;
import java.util.stream.Collectors;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import fr.davidrobin.api.bean.Show;
import fr.davidrobin.api.service.ShowDBService;

@DgsComponent
public class ShowsDatafetcher {

    @Value("${app.jsondb.folder}")
    private String dbfolder;

    @Autowired
    private ShowDBService showDBService;

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        List<Show> shows = showDBService.getShowsList();
        if (titleFilter == null) {
            return shows;
        }
        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

}
