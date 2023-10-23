package edu.hw2.task3.Connections;

public class ConnectionException extends RuntimeException {
    public ConnectionException(String info) {
        super(info);
    }

    public ConnectionException(String info, Throwable parent) {
        super(info, parent);
    }
}
