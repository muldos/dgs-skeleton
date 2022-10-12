package fr.davidrobin.api.mutation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import fr.davidrobin.api.bean.Show;
import fr.davidrobin.api.service.ShowDBService;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ShowMutation {
    @Value("${app.jsondb.folder}")
    private String dbfolder;
    @Autowired
    private ShowDBService showDBService;

    @DgsData(parentType = "Mutation", field = "addShow")
    public Show addShow(DataFetchingEnvironment dataFetchingEnvironment) {
        List<Show> listShow = showDBService.getShowsList();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> input = dataFetchingEnvironment.getArgument("input");
        ShowInput showInput = new ObjectMapper().convertValue(input, ShowInput.class);
        Show s = new Show(showInput.getTitle(), showInput.getPlatform(), showInput.getReleaseYear());
        if (listShow == null) {
            listShow = new ArrayList<Show>();
        }
        listShow.add(s);

        try {
            objectMapper.writeValue(new File(this.dbfolder + "/shows-db.json"), listShow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}

class ShowInput {
    private String title;
    private int releaseYear;
    private String platform;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}