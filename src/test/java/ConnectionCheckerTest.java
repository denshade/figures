import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionCheckerTest {

    @Test
    void check_is_connected() {
        var map = new int[10][10];
        var checker = new ConnectionChecker(10);
        assertFalse(checker.check_is_connected(map));
        for (int y = 0; y < 10; y++) {
            map[y][y] = 1;
            map[9-y][y] = 1;
        }
        assertTrue(checker.check_is_connected(map));
    }
}