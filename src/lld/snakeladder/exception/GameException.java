package lld.snakeladder.exception;

public class GameException extends RuntimeException {

    protected String msg;

    public GameException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
