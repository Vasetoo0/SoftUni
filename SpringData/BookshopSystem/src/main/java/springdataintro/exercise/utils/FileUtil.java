package springdataintro.exercise.utils;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public interface FileUtil {

    String[] readFileContent(String filePath) throws IOException;
}
