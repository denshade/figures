import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class ConnectionChecker
{
    private int maxsize;

    public ConnectionChecker(int maxsize){
        this.maxsize = maxsize;
    }
    public boolean check_is_connected(int[][] map) {
        int[][] paintedMap = clone_2D_map(map);
        if (paintedMap[0][0] != 1) {
            return false;
        }
        paintNeighbours(paintedMap, 0,0);
        return paintedMap[0][0] == 2 && paintedMap[0][maxsize - 1] == 2 && paintedMap[maxsize - 1][0] == 2 && paintedMap[maxsize - 1][maxsize - 1] == 2;
    }


    public static int[][] clone_2D_map(int[][] map) {
        return Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
    }
    private  void paintNeighbours(int[][] map, int x, int y)
    {
        map[y][x] = 2;
        java.util.List<Point> pointsToCheck = List.of(new Point(x - 1, y - 1), new Point( x, y - 1),
                new Point(x + 1, y - 1),new Point (x + 1, y),new Point (x + 1, y + 1), new Point(x, y + 1),new Point (x - 1, y + 1));
        for (Point point : pointsToCheck) {
            if (point.x < 0 || point.y < 0) {
                continue;
            }
            if (point.x > maxsize - 1 || point.y > maxsize - 1) {
                continue;
            }
            if (map[point.y][point.x] == 1) {
                paintNeighbours(map, point.x, point.y);
            }
        }
    }
    public static String printMap(int[][] map, int maxsize) {
        StringBuilder mapStr = new StringBuilder("============================= [" + count_nr_pixels_lit(map, maxsize) + "]\n");
        for (int y = 0; y < maxsize; y++) {
            for (int x = 0; x < maxsize; x++) {
                mapStr.append(map[y][x]).append(" ");
            }
            mapStr.append("\n");
        }
        mapStr.append("=============================");
        return mapStr.toString();
    }

    public static int count_nr_pixels_lit(int[][] map_without_pixel, int maxsize) {
        int counter = 0;
        for (int y =0; y < maxsize; y++)
            for (int x =0; x < maxsize; x++) {
                if (map_without_pixel[y][x] == 1) {
                    counter++;
                }
            }
        return counter;
    }

}
