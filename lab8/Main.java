class Vehicle {
    private String brand;
    public int year;
    private int speed;

    public Vehicle(String brand, int year, int speed) {
        this.brand = brand;
        this.year = year;
        this.speed = speed;
    }
    public void test1(){
        System.out.println("Тест1");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void move() {
        System.out.println("Транспортное средство движется");
    }

    public void displayInfo() {
        System.out.println("Марка: " + brand + ", Год: " + year + ", Скорость: " + speed + " км/ч");
    }
}

class Car extends Vehicle {
    private int doors;

    public Car(String brand, int year, int speed, int doors) {
        super(brand, year, speed);
        super.year = year;
        
    }

    public int getDoors() {
        return doors;
    }
    public void test(){
        System.out.println("Тест");
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println("Едет по дороге");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  км/ч, Дверей: " + doors + super.year);
    }

    public void openTrunk() {
        System.out.println(getBrand() + ": багажник открыт");
    }
}

class Plane extends Vehicle {
    private int altitude;


    public Plane(String brand, int year, int speed, int altitude) {
        super(brand, year, speed);
        this.altitude = altitude;
        
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println("Летит в небе");
    }

    @Override
    public void displayInfo() {
        System.out.println("Самолет -> Марка: " + getBrand() + ", Год: " + getYear() +
                           ", Скорость: " + getSpeed() + " км/ч, Высота полета: " + altitude + " м");
    }

    public void takeOff() {
        System.out.println(getBrand() + ": выполняет взлет");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[5];

        vehicles[0] = new Car("Toyota", 2020, 210, 4);
        vehicles[1] = new Car("BMW", 2022, 250, 2);
        vehicles[2] = new Car("Audi", 2019, 230, 4);

        vehicles[3] = new Plane("Boeing 737", 2018, 850, 10000);
        vehicles[4] = new Plane("Airbus A320", 2021, 840, 11000);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.move();

            if (v instanceof Car) {
                ((Car) v).openTrunk();
            } else if (v instanceof Plane) {
                ((Plane) v).takeOff();
            }
            System.out.println();
            
        }
        Vehicle v = new Car("Toyota", 2020, 210, 4);
        Car c = new Car("Toyota", 2020, 210, 4);

    }
}