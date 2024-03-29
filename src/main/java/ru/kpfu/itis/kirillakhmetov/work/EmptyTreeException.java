package ru.kpfu.itis.kirillakhmetov.work;

public class EmptyTreeException extends RuntimeException {
    public EmptyTreeException() {
        super();
    }

    public EmptyTreeException(String message) {
        super(message);
    }

    public EmptyTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTreeException(Throwable cause) {
        super(cause);
    }
}
