package dsa.atlassian.votingsystem.exceptions;

public abstract class VotingSystemException extends RuntimeException {

    protected String message;

    protected String errorCode;

    public VotingSystemException(String message) {
        this(message, null);
    }

    public VotingSystemException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
