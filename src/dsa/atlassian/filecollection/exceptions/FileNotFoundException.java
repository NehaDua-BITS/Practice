package dsa.atlassian.filecollection.exceptions;

public class FileNotFoundException extends FileSystemException {

    public FileNotFoundException(String message, String errorCode) {
        super(message, errorCode);
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
