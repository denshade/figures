import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguresPointLinesTest {

    @Test
    void testDrawLine()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,0,9,9, map);
        for (int y = 0; y < 10; y++) {
            assertEquals(1, map[y][y]);
        }
    }

}