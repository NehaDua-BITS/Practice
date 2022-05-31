package dsa.atlassian.votingsystem.exceptions;

public class InvalidInputException extends VotingSystemException {
    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, String errorCode) {
        super(message, errorCode);
    }
}
