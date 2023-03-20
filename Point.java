package Data_Table;

public class Point {
    protected int x;
    protected int y;
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;

    }
    public Point(Point p) {
        x = p.x;
        y = p.y;
    }
}
