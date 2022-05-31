package dsa.atlassian.filecollection.exceptions;

public class InvalidInputException extends FileSystemException {

    public InvalidInputException(String message, String errorCode) {
        super(message, errorCode);
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
