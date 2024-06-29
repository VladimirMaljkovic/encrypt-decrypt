package file_loader;

import file_loader.implementations.TextFileLoader;
import file_loader.implementations.XLSFileLoader;
import file_loader.implementations.XLSXFileLoader;

public class FileLoaderFactory {

    public static FileLoader getFileLoader(String fileExtension) {
        switch (fileExtension.toLowerCase()) {
            case "txt":
            case "json":
            case "md":
            case "rtf":
            case "log":
            case "html":
            case "css":
                return new TextFileLoader();
            case "xls":
                return new XLSFileLoader();
            case "xlsx":
                return new XLSXFileLoader();
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        }
    }

}
