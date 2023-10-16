package edu.hw2.task3.ConnectionManagers;

import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {

    @Override public Connection getConnection() {
        return new FaultyConnection();
    }
}
