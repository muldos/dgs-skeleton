package fr.davidrobin.api.query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import fr.davidrobin.api.bean.Show;

@DgsComponent
public class ShowsDatafetcher {

    @DgsQuery
    public List<Show> shows(@InputArgument String titleFilter) {
        List<Show> shows = this.getDatabaseResource();
        if (titleFilter == null) {
            return shows;
        }

        return shows.stream().filter(s -> s.getTitle().contains(titleFilter)).collect(Collectors.toList());
    }

    /*
     * The resource URL is not working in the JAR If we try to access a file that is
     * inside a JAR, It throws NoSuchFileException (linux), InvalidPathException
     * (Windows)
     * 
     * Resource URL Sample: file:java-io.jar!/json/file1.json
     */
    private List<Show> getDatabaseResource() {
        List<Show> listShow = null;
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            InputStream inputStream = classLoader.getResourceAsStream("data/shows-db.json");
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            String showsJsonText = new BufferedReader(streamReader).lines().collect(Collectors.joining("\n"));
            listShow = objectMapper.readValue(showsJsonText, new TypeReference<List<Show>>() {
            });
            return listShow;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listShow;
    }

}
