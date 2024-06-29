package file_loader;

import java.io.File;
import java.util.ArrayList;

public class DirectoryScanner {
    private final String directoryPath;
    private ArrayList<String> fileNames;

    public DirectoryScanner(String directoryPath) {
        this.directoryPath = directoryPath;
        fileNames = new ArrayList<>();
    }

    public void loadFileNames() {
        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directoryPath + " is not a directory");
        }

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
    }



    public String getFileExtension(String fileName) {
        if(fileName == null || fileName.lastIndexOf('.') == -1) {
            System.out.println("No extension found for " + fileName);
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }

    public ArrayList<String> getFileNames() {
        return fileNames;
    }
}
