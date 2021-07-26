package fr.davidrobin.api.mutation;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;

import org.springframework.beans.factory.annotation.Value;

import fr.davidrobin.api.bean.Show;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ShowMutation {
    @Value("${app.jsondb.folder}")
    private String dbfolder;

    @DgsData(parentType = "Mutation", field = "addShow")
    public Show addShow(DataFetchingEnvironment dataFetchingEnvironment) {
        System.out.println("db folder " + this.dbfolder);
        Map<String, Object> input = dataFetchingEnvironment.getArgument("input");
        ShowInput showInput = new ObjectMapper().convertValue(input, ShowInput.class);

        return new Show(showInput.getTitle(), showInput.getReleaseYear());
    }
}

class ShowInput {
    private String title;
    private int releaseYear;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}