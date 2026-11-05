package labb9;
abstract class Shape {
    private String color;
    private double x;
    private double y;

    public Shape(String color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void displayInfo() {
        System.out.println("Цвет: " + color + ", Координаты: (" + x + ", " + y + ")");
    }

    public abstract double calculateArea();
    public abstract void draw();
}