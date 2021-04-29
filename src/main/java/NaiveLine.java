public class NaiveLine {
    public static void lineTo(int startX, int startY, int stopX, int stopY, int[][] map)
    {
        if (startX > stopX) {
            lineTo(stopX, stopY, startX, startY, map);
        }
        double dx = stopX - startX;
        double dy = stopY - startY;
        //if (Math.abs(dx) > Math.abs(dy)) {
        for (double x = startX; x <= stopX; x++){
            double y = startY + dy*(x - startX) / dx;
            map[(int)y][(int)x] = 1;
        }

        if (dx == 0) {
            for (int y = Math.min(startY, stopY); y <= Math.max(startY, stopY); y++) {
                map[y][startX] = 1;
            }
            return;
        }
    }
}
