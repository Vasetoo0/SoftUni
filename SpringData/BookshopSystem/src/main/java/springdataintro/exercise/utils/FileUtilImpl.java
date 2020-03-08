package springdataintro.exercise.utils;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Component
public class FileUtilImpl implements FileUtil {

    @Override
    public String[] readFileContent(String filePath) throws IOException {

        File file = new File(filePath);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;

        Set<String> data = new LinkedHashSet<>();

        while ((line = reader.readLine()) != null) {

            if(!line.isEmpty()) {
                data.add(line);
            }
        }
        return data.toArray(new String[0]);
    }
}
