class Car {
    private String brand;
    private String model;
    private int year;
    private int mileage;

    public static int x;
    private int y;

    public int getY(){
        return y;
    }

    public void setY(int value){
        this.y = value;
    }

    public Car(String brand,String model,int year, int mileage,int y){
        this(brand, model, year, mileage);
        this.y = y;
    }
    public static void printP(){
        System.err.println(x);
    }
    public String printPa(){
        return "Параметры:" + brand +","+ model +"," +  mileage + x ;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Car(String brand, String model, int year, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void drive(int km) {
        if (km > 0) {
            this.mileage += km;
        }
    }

    public void displayInfo() {
        System.out.println("Марка: " + brand + ", Модель: " + model +
                           ", Год: " + year + ", Пробег: " + mileage + " км");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2021, 45000);
        car.displayInfo();

        car.drive(100);
        System.out.println("Обновленный пробег: " + car.getMileage() + " км");
        car.displayInfo();
    }
}