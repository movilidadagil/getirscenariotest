package pageobjects;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/* Created by JavaUnifiedTester   hasanaligul  2019-11-27  */
public class FileUtils {
    public FileUtils() {
    }

    public static String readFileContentsAsString(String fileLocation) throws Exception {
        StringBuffer result = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));

        String line;
        while((line = reader.readLine()) != null) {
            result.append(line);
            if (reader.ready()) {
                result.append('\n');
            }
        }

        reader.close();
        return result.toString();
    }

    public static void saveStringInFile(String fileLocation, String content) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation, false));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public static Path createTemporaryDirectory() throws Exception {
        return Files.createTempDirectory("testframework-");
    }
}
