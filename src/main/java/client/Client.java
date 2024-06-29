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
        directoryScanner.load();
    }


}
