package br.com.delogic.jfunk.data;

public class Success<E> {

    private final String message;
    private final E value;

    public Success(String message, E value) {
        if (value == null) {
            throw new IllegalArgumentException(String.format("Cannot create success for message %s with a null value", message));
        }
        this.message = message;
        this.value = value;
    }

    public Success(String message) {
        this.message = message;
        this.value = null;
    }

    public static final Success<Void> of(String message) {
        return new Success<Void>(message);
    }

    public static final <T> Success<T> of(String message, T value) {
        return new Success<T>(message, value);
    }

    public String getMessage() {
        return message;
    }

    public E getValue() {
        return value;
    }

}
