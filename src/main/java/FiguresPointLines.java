import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
public class FiguresPointLines {

    private static int MAX_SIZE = 1000;
    private static ConnectionChecker connectionChecker = new ConnectionChecker(MAX_SIZE);

    public static void main(String[] args) {
        for (int k = 0; k < MAX_SIZE / 2; k++) {
            int[][] map = new int[MAX_SIZE][MAX_SIZE];
            map[0][0] = 1;
            map[0][MAX_SIZE - 1] = 1;
            map[MAX_SIZE - 1][0] = 1;
            map[MAX_SIZE - 1][MAX_SIZE - 1] = 1;

            Point p1 = new Point(k, MAX_SIZE/2);
            Point p2 = new Point(MAX_SIZE - 1 - k, MAX_SIZE/2);

            map[p1.y][p1.x] = 1;
            map[p2.y][p2.x] = 1;
            lineTo(0,0,p1.x, p1.y, map);
            lineTo(0,MAX_SIZE - 1,p1.x, p1.y, map);
            //lineTo (0, 0) -> p1
            //lineTo (max_size - 1, 0) -> p1

            lineTo(MAX_SIZE - 1,MAX_SIZE - 1, p2.x, p2.y, map);
            lineTo(MAX_SIZE - 1,0,p2.x, p2.y, map);

            lineTo(p1.x, p1.y, p2.x, p2.y, map);
            //System.out.println(ConnectionChecker.printMap(map, MAX_SIZE));

            if (connectionChecker.check_is_connected(map)) {
                System.out.println(ConnectionChecker.count_nr_pixels_lit(map, MAX_SIZE));//pixels tellen is geen goede manier om afstand te berekenen.

                //System.out.println(ConnectionChecker.printMap(map, MAX_SIZE));
//                System.out.println(map.);

            }
        }
    }

    public static void lineTo(int startX, int startY, int stopX, int stopY, int[][] map)
    {
        DDALine.lineTo(startX, startY, stopX, stopY, map);
    }



    private static int[][] bestSolution;
    private static int best_nr_of_pixels_lit = MAX_SIZE*MAX_SIZE;

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
