package hw2.task3;

import edu.hw2.task3.Connections.ConnectionException;
import edu.hw2.task3.Connections.FaultyConnection;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class FaultyConnectionTest {
    private FaultyConnection faultyConnection;
    private Random mockRandom;

    @BeforeEach void objectsInitialization() {
        faultyConnection = new FaultyConnection();
        mockRandom = Mockito.mock(Random.class);
    }

    @Test @DisplayName("Проблемное соединение выполняет команду") void testFaultyConnectionFails() {
        // given
        when(mockRandom.nextDouble()).thenReturn(1.0);
        faultyConnection.setRandom(mockRandom);

        // when & then
        assertDoesNotThrow(() -> faultyConnection.execute("apt update && apt upgrade -y"));
    }

    @Test @DisplayName("Проблемное соединение падает") void testFaultyConnectionCompletesCommad() {
        // given
        when(mockRandom.nextDouble()).thenReturn(0.1);
        faultyConnection.setRandom(mockRandom);

        // when & then
        assertThrows(ConnectionException.class, () -> faultyConnection.execute("apt update && apt upgrade -y"));
    }
}


