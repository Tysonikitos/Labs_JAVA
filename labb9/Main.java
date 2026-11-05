package labb9;

public class Main {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[5];

        shapes[0] = new Circle("Красный", 0, 0, 5);
        shapes[1] = new Circle("Синий", 2, 3, 10);
        shapes[2] = new Circle("Зеленый", -1, 4, 3);

        shapes[3] = new Rectangle("Желтый", 5, 5, 4, 6);
        shapes[4] = new Rectangle("Белый", 1, 2, 8, 5);

        for (Shape s : shapes) {
            s.displayInfo();
            s.draw();
            System.out.printf("Площадь: ", s.calculateArea());
        }
    }
}