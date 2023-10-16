package edu.hw2.task3.Connections;

public interface Connection extends AutoCloseable {
    void execute(String command);
}
