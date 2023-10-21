package edu.hw2.task3.ConnectionManagers;

import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final double DEFAULT_CHANCE_TO_THROW_FAULTY_CONNECTION = 0.3;
    private final double faultyConnectionReturningChance;
    private Random random;

    public DefaultConnectionManager() {
        this.faultyConnectionReturningChance = DEFAULT_CHANCE_TO_THROW_FAULTY_CONNECTION;
        this.random = new Random();
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public Connection getConnection() {
        return (random.nextDouble() > faultyConnectionReturningChance) ? new StableConnection()
            :
            new FaultyConnection();
    }
}
