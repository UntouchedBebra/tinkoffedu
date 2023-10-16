package hw2.task3;

import edu.hw2.task3.ConnectionManagers.ConnectionManager;
import edu.hw2.task3.ConnectionManagers.FaultyConnectionManager;
import edu.hw2.task3.Connections.Connection;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.hw2.task3.Connections.FaultyConnection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FaultyConnectionManagerTest {
    @Test
    @DisplayName("Возврат проблемного соединения проблемным менеджером")
    void testFaultyConnectionReturningFromFaultyConnectionManager() {
        // given
        ConnectionManager faultyConnectionManager = new FaultyConnectionManager();

        // when
        Connection resultConnection = faultyConnectionManager.getConnection();

        // then
        assertTrue(resultConnection instanceof FaultyConnection);
    }
}
