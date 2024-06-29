package client;

import file_loader.OldFileLoader;

import java.io.IOException;

public class Client {

    public static void main(String[] args) throws IOException {
        String directoryPath = "static/inputFiles";

        OldFileLoader textFileLoader = new OldFileLoader(directoryPath);
        textFileLoader.readFilesContent();
    }
}
