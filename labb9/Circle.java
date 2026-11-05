package labb9;
class Circle extends Shape {
    private double radius;

    public Circle(String color, double x, double y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        System.out.println("Рисую круг");
    }

    @Override
    public void displayInfo() {
        System.out.println("Круг -> Цвет: " + getColor() + ", Координаты: (" + getX() + ", " + getY() + "), Радиус: " + radius);
    }
}