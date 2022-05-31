package dsa.atlassian.filecollection.exceptions;

public abstract class FileSystemException extends RuntimeException {

    private String message;

    private String errorCode;

    public FileSystemException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public FileSystemException(String message) {
        this(message, null);
    }

}
