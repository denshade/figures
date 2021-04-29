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

    @Test
    void testDrawLineInv()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(9,9,0,0, map);
        for (int y = 0; y < 10; y++) {
            assertEquals(1, map[y][y]);
        }
    }

    @Test
    void testDrawLineFlat()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,0,9,0, map);
        for (int x = 0; x < 10; x++) {
            assertEquals(1, map[0][x]);
        }
    }

    @Test
    void testDrawLineFlatDown()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,9,0,0, map);
        for (int y = 0; y < 10; y++) {
            assertEquals(1, map[y][0]);
        }
    }

    @Test
    void testDrawLineFlatDown2()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,9,0,5, map);
        for (int y = 5; y < 10; y++) {
            assertEquals(1, map[y][0]);
        }
    }

    @Test
    void testDrawLineFlatDown3()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,9,1,5, map);
        assertEquals("============================= [5]0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "1 0 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "=============================", ConnectionChecker.printMap(map, 10));
    }

    @Test
    void testDrawLineFlatDown4()
    {
        int[][] map = new int[10][10];
        FiguresPointLines.lineTo(0,9,2,5, map);
        assertEquals("============================= [5]0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "0 0 0 0 0 0 0 0 0 0 \n" +
                "1 0 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "0 1 0 0 0 0 0 0 0 0 \n" +
                "=============================", ConnectionChecker.printMap(map, 10));
    }

}