package Advanced.Generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFiles {
    public static void main(String[] args) throws IOException {

        zipFiles();
    }
    private static void zipFiles() throws IOException {

        String classPath = "C:\\Users\\Vaseto\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\DefiningClasses\\CompanyRoaster\\Employee.java";
        String classTwoPath = "C:\\Users\\Vaseto\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\DefiningClasses\\CompanyRoaster\\Department.java";
        String mainPath = "C:\\Users\\Vaseto\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\DefiningClasses\\CompanyRoaster\\Advanced.IteratorsAndComparators.Main.java";
        String zipPathOut = "C:\\Users\\Vaseto\\IdeaProjects\\JavaAdvanced\\src\\Advanced\\DefiningClasses\\CompanyRoaster\\CompanyRoaster.zip";

        List<String> srcFiles = Arrays.asList(classPath,classTwoPath,mainPath);
        FileOutputStream fos = new FileOutputStream(zipPathOut);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            File fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

}
