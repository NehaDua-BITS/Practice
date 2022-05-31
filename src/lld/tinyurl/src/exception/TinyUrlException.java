package lld.tinyurl.src.exception;

public class TinyUrlException extends RuntimeException {

    protected String msg;

    public TinyUrlException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
