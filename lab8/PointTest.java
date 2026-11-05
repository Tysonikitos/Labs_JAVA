class Point1D {
    private int x;

    public Point1D(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }
}

class Point2D extends Point1D {
    private int y;

    public Point2D(int x, int y) {
        super(x);
        this.y = y;
    }

    public int getY() {
        return y;
    }
}

class Point3D extends Point2D {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D() {
        this(-1, -1, -1); 
    }

    public int getZ() {
        return z;
    }

    public void display() {
        System.out.println("Точка: (" + getX() + ", " + getY() + ", " + z + ")");
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(10, 20, 30);
        Point3D p2 = new Point3D();

        p1.display();
        p2.display();
    }
}