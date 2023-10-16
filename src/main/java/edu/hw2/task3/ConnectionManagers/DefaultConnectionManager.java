package edu.hw2.task3.ConnectionManagers;

import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final double faultyConnectionReturningChance;
    private Random random;

    @SuppressWarnings("MagicNumber") public DefaultConnectionManager() {
        this.faultyConnectionReturningChance = 0.3;
        this.random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override public Connection getConnection() {
        return (random.nextDouble() > faultyConnectionReturningChance) ? new StableConnection()
            :
            new FaultyConnection();
    }
}
