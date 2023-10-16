package edu.hw2.task3.Connections;

import java.util.Random;
import java.util.logging.Logger;

public class FaultyConnection implements Connection {
    private Logger logger;
    private final double chanceToFailExecution;

    private Random random;

    @SuppressWarnings("MagicNumber") public FaultyConnection() {
        logger = Logger.getLogger(FaultyConnection.class.getName());
        random = new Random();
        chanceToFailExecution = 0.3;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override public void execute(String command) {
        if (random.nextDouble() < chanceToFailExecution) {
            throw new ConnectionException("При выполнении операции было разорвано соединение");
        } else {
            logger.info("Выполнение операциии в рамках ПРОБЛЕМНОГО соединения ");
        }
    }

    @Override public void close() throws Exception {
        logger.info("ПРОБЛЕМНОЕ соединение завершило операцию; ресурсы высвобождены");
    }
}
