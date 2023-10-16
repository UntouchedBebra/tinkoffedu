package hw2.task3;

import edu.hw2.task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.task3.Connections.Connection;
import edu.hw2.task3.Connections.FaultyConnection;
import edu.hw2.task3.Connections.StableConnection;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class DefaultConnectionManagerTest {
    private DefaultConnectionManager defaultConnectionManager;
    private Random mockRandom;

    @BeforeEach void objectsInitialization() {
        defaultConnectionManager = new DefaultConnectionManager();
        mockRandom = Mockito.mock(Random.class);
    }

    @Test @DisplayName("Возвращение стабильного соединения через стандартный менеджер соединений")
    void testStableConnectionReturningFromDefaultConnectionManager() {
        // given
        defaultConnectionManager.setRandom(mockRandom);
        when(mockRandom.nextDouble()).thenReturn(0.4);

        // when
        Connection newConnection = defaultConnectionManager.getConnection();

        // then
        assertTrue(newConnection instanceof StableConnection);
    }

    @Test @DisplayName("Возвращение проблемного соединения через стандартный менеджер соединений")
    void testFaultyConnectionReturningFromDefaultConnectionManager() {
        // given
        defaultConnectionManager.setRandom(mockRandom);
        when(mockRandom.nextDouble()).thenReturn(0.1);

        // when
        Connection newConnection = defaultConnectionManager.getConnection();

        // then
        assertTrue(newConnection instanceof FaultyConnection);
    }

}
