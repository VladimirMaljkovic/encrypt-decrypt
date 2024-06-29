package file_loader.implementations;

import file_loader.FileLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TextFileLoader implements FileLoader {

    @Override
    public void loadFile(String filePath) throws IOException {
        File file = new File(filePath);
        
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException(fileName + " is not a valid file");
        }
        else {
            StringBuilder content = new StringBuilder();
            try (Scanner scanner = new Scanner(new FileInputStream(file))) {
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append(System.lineSeparator());
                }
            }
            System.out.println(fileName + ":\n" + content);
        }
    }
}
