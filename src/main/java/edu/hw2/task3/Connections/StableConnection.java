package edu.hw2.task3.Connections;

import java.util.logging.Logger;

public class StableConnection implements Connection {
    private Logger logger;

    public StableConnection() {
        logger = Logger.getLogger(StableConnection.class.getName());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override

    public void execute(String command) {
        logger.info("Выполнение операциии в рамках СТАБИЛЬНОГО соединения ");
    }

    @Override public void close() throws Exception {
        logger.info("СТАБИЛЬНОЕ соединение завершило операцию; ресурсы высвобождены");
    }
}
