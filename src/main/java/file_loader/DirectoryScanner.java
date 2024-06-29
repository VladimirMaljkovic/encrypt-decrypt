package file_loader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DirectoryScanner {
    private final String directoryPath;
    private final ArrayList<String> fileNames;

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

    public void load() {
        loadFileNames();
        loadFiles();
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

    public void loadFiles() {
        for (String fileName: this.getFileNames()) {
            try {
                FileLoader fileLoader = FileLoaderFactory.getFileLoader(this.getFileExtension(fileName));
                fileLoader.loadFile(directoryPath + File.separator + fileName);
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid directory or file type: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
