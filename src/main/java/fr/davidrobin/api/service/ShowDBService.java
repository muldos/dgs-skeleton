package fr.davidrobin.api.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.davidrobin.api.bean.Show;

@Component("showDBService")
public class ShowDBService {
    @Value("${app.jsondb.folder}")
    private String dbfolder;

    public List<Show> getShowsList() {
        List<Show> listShow = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File dbFile = new File(this.dbfolder + "/shows-db.json");
            InputStream inputStream = new FileInputStream(dbFile);
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String showsJsonText = bufferedReader.lines().collect(Collectors.joining("\n"));
            listShow = objectMapper.readValue(showsJsonText, new TypeReference<List<Show>>() {
            });
            bufferedReader.close();
            return listShow;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listShow;
    }
}
