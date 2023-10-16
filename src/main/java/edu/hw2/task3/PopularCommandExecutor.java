package edu.hw2.task3;

import edu.hw2.task3.ConnectionManagers.ConnectionManager;
import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.ConnectionException;
import java.util.logging.Logger;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    Logger logger;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
        logger = Logger.getLogger(PopularCommandExecutor.class.getName());
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        Connection connection = manager.getConnection();
        ConnectionException cause = null;
        for (int i = 0; i < maxAttempts; i++) {
            try (connection) {
                connection.execute(command);
                break;
            } catch (ConnectionException exception) {
                cause = exception;
            } catch (Exception ignored) {
                logger.info(String.format("Неуспешное закрытие ресурса %s", connection.toString()));
            }
        }

        if (cause != null) {
            throw new ConnectionException(String.format(
                "Неуспешное выполнение операции \"%s\" в рамках %d попыток",
                command,
                maxAttempts
            ), cause);
        } else {
            logger.info(String.format("Успешное выполнение операции \"%s\"", command));
        }
    }
}
