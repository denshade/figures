import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Figures {

    private static int MAX_SIZE = 10;


    public static void main(String[] args) {
        for(int retries = 0; retries < 20; retries++)
        {
            int[][] map = generateRandomMap();
            if (check_is_connected(map)) {
                pickOff(map,0);
                System.out.println(Arrays.deepToString(map));
//                System.out.println(map.);

            }

        }

    }

    private static int[][] bestSolution;
    private static int best_nr_of_pixels_lit = MAX_SIZE*MAX_SIZE;

    private static int[][] pickOff(int[][] map, int currentPosition) {
        for (; currentPosition < MAX_SIZE * MAX_SIZE; currentPosition++) {
            int y = currentPosition / MAX_SIZE;
            int x = currentPosition % MAX_SIZE;
            if (map[y][x] == 0) continue;
            //try with the pixel on,
            int[][] map_without_pixel = clone_2D_map(map);
            map_without_pixel[y][x] = 0;
            if (check_is_connected(map_without_pixel)) {
                int new_lit_pixels = count_nr_pixels_lit(map_without_pixel);
                if (new_lit_pixels < best_nr_of_pixels_lit) {
                    best_nr_of_pixels_lit = new_lit_pixels;
                    bestSolution = map_without_pixel;
                    printMap(map_without_pixel);
                }
                pickOff(map_without_pixel, currentPosition);
            }
            //try without.
        }
        return bestSolution;
    }

    private static void printMap(int[][] map) {

        System.out.println("============================= ["+count_nr_pixels_lit(map)+"]");
        for (int y = 0; y < MAX_SIZE; y++) {
            for (int x = 0; x < MAX_SIZE; x++) {
                System.out.print(map[y][x]+" ");
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

    private static int count_nr_pixels_lit(int[][] map_without_pixel) {
        int counter = 0;
        for (int y =0; y < MAX_SIZE; y++)
            for (int x =0; x < MAX_SIZE; x++) {
                if (map_without_pixel[y][x] == 1) {
                    counter++;
                }
            }
        return counter;
    }

    private static void paintNeighbours(int[][] map, int x, int y)
    {
        map[y][x] = 2;
        List<Point> pointsToCheck = List.of(new Point(x - 1, y - 1), new Point( x, y - 1),
                new Point(x + 1, y - 1),new Point (x + 1, y),new Point (x + 1, y + 1), new Point(x, y + 1),new Point (x - 1, y + 1));
        for (Point point : pointsToCheck) {
            if (point.x < 0 || point.y < 0) {
                continue;
            }
            if (point.x > MAX_SIZE - 1 || point.y > MAX_SIZE - 1) {
                continue;
            }
            if (map[point.y][point.x] == 1) {
                paintNeighbours(map, point.x, point.y);
            }
        }
    }

    private static boolean check_is_connected(int[][] map) {
        int[][] paintedMap = clone_2D_map(map);
        if (paintedMap[0][0] != 1) {
            return false;
        }
        paintNeighbours(paintedMap, 0,0);
        return paintedMap[0][0] == 2 && paintedMap[0][MAX_SIZE - 1] == 2 && paintedMap[MAX_SIZE - 1][0] == 2 && paintedMap[MAX_SIZE - 1][MAX_SIZE - 1] == 2;
    }

    private static int[][] clone_2D_map(int[][] map) {
        return Arrays.stream(map).map(int[]::clone).toArray(int[][]::new);
    }

    private static int[][] generateRandomMap() {
        Random r = new Random();
        int[][] bord = new int[MAX_SIZE][MAX_SIZE];
        for (int x = 0; x < MAX_SIZE; x++) {
            for (int y = 0; y < MAX_SIZE; y++) {
                bord[y][x] = r.nextInt(2);
            }
        }
        return bord;
    }
}
