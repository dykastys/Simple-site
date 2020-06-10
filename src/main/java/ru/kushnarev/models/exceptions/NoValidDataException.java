package ru.kushnarev.models.exceptions;

public class NoValidDataException extends DaoBusinessException {

    public NoValidDataException(String message) {
        super(message);
    }

    public NoValidDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
