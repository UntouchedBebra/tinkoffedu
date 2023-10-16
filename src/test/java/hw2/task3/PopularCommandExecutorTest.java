package hw2.task3;

import edu.hw2.task3.ConnectionManagers.ConnectionManager;
import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.ConnectionException;
import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class PopularCommandExecutorTest {
    private ConnectionManager mockManager;
    private PopularCommandExecutor executor;

    @BeforeEach public void objectsInitialization() {
        mockManager = Mockito.mock(ConnectionManager.class);
        executor = new PopularCommandExecutor(mockManager, 10);
    }

    @Test @DisplayName("Невыполнение команды в течение n-го кол-ва попыток с выдачей результирующего исключения ")
    void testConnectionFailsToExecuteTaskWithinAllAttempts() {
        // given
        Connection mockConnection = Mockito.mock(FaultyConnection.class);
        when(mockConnection.toString()).thenReturn("FaultyConnection");
        doThrow(new ConnectionException("При выполнении операции было разорвано соединение")).when(mockConnection)
            .execute(Mockito.anyString());

        when(mockManager.getConnection()).thenReturn(mockConnection);

        // when
        ConnectionException connectionException =
            Assertions.assertThrows(ConnectionException.class, () -> executor.updatePackages());

        // then
        Assertions.assertTrue(connectionException.getMessage().contains("Неуспешное выполнение операции"));
    }
}
