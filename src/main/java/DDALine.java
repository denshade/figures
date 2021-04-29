public class DDALine {
    public static void lineTo(int x1, int y1, int x2, int y2, int[][] map)
    {
        double dx = (x2 - x1);
        double dy = (y2 - y1);
        double step;
        if (Math.abs(dx) >= Math.abs(dy))
            step = Math.abs(dx);
        else
            step = Math.abs(dy);
        dx = dx / step;
        dy = dy / step;
        double x = x1;
        double y = y1;
        int i = 1;
        while (i <= step) {
            map[(int)y][(int)x] = 1;
            x = x + dx;
            y = y + dy;
            i = i + 1;
        }
    }
}
