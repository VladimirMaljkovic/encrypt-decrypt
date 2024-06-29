package file_loader;

import file_loader.implementations.JsonFileLoader;
import file_loader.implementations.TextFileLoader;
import file_loader.implementations.XLSFileLoader;
import file_loader.implementations.XLSXFileLoader;

public class FileLoaderFactory {

    public static FileLoader getFileLoader(String fileExtension) {
        switch (fileExtension.toLowerCase()) {
            case "txt":
                return new TextFileLoader();
            case "json":
                return new JsonFileLoader();
            case "xls":
                return new XLSFileLoader();
            case "xlsx":
                return new XLSXFileLoader();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        }
    }

}
