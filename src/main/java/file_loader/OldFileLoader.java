package file_loader;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OldFileLoader {

    private final String directoryPath;

    public OldFileLoader(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public ArrayList<String> loadFileNames() {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory");
        }

        ArrayList<String> fileNames = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files != null)  {
            for (File file: files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        else {
            System.out.println("No files found in given directory");
        }

        for (String fileName: fileNames) {
            System.out.println(fileName);
        }

        return fileNames;
    }

    public void readFilesContent() throws FileNotFoundException {
        ArrayList<String> fileNames = loadFileNames();

        for (String fileName: fileNames) {
            readIndividualFile(fileName);
        }
    }

    private void readIndividualFile(String fileName) throws FileNotFoundException {
        String filePath = directoryPath + File.separator + fileName;
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException(fileName + " is not a valid file");
        }
        else {
            String extension = getFileExtension(fileName);
            StringBuilder content = new StringBuilder();
            try (Scanner scanner = new Scanner(new FileInputStream(file))) {
                while (scanner.hasNextLine()) {
                    content.append(scanner.nextLine()).append(System.lineSeparator());
                }
            }
            System.out.println(fileName + ":\n" + content);
        }
    }

    private String getFileExtension(String fileName) {
        if(fileName == null || fileName.lastIndexOf('.') == -1) {
            System.out.println("No extension found for " + fileName);
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

}
