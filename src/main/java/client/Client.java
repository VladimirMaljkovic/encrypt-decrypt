package client;

import file_loader.DirectoryScanner;
import file_loader.FileLoader;
import file_loader.FileLoaderFactory;
import file_loader.OldFileLoader;

import java.io.File;
import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        String filesDirPath = "src/main/resources/static/inputFiles";

        DirectoryScanner directoryScanner = new DirectoryScanner(filesDirPath);
        directoryScanner.loadFileNames();

        for (String fileName: directoryScanner.getFileNames()) {
            try {
                FileLoader fileLoader = FileLoaderFactory.getFileLoader(directoryScanner.getFileExtension(fileName));
                fileLoader.loadFile(filesDirPath + File.separator + fileName);
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
