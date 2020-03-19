package springdata.jsonparsing.productshop.utils;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public interface FileUtil {

    String readFileContent(String filePath) throws IOException;

    void write(String content, String filePath) throws IOException;


}
