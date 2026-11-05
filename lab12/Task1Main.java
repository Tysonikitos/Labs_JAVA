import java.util.LinkedHashMap;
import java.util.Map;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Имя='" + name + "', Зарплата=" + salary;
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Manager {" + super.toString() + ", Команда=" + teamSize + " чел.}";
    }
}

class Engineer extends Employee {
    private String specialization;

    public Engineer(String name, int id, double salary, String specialization) {
        super(name, id, salary);
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Engineer {" + super.toString() + ", Специализация='" + specialization + "'}";
    }
}

class Intern extends Employee {
    private int duration;

    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Intern {" + super.toString() + ", Стажировка=" + duration + " мес.}";
    }
}

public class Task1Main {
    public static void main(String[] args) {
        Map<String, Employee> employees = new LinkedHashMap<>();

        Employee m1 = new Manager("Иван", 101, 3500.0, 10);
        Employee m2 = new Manager("Ольга", 102, 3800.0, 15);
        Employee m3 = new Manager("Сергей", 103, 3200.0, 8);

        Employee e1 = new Engineer("Алексей", 201, 2800.0, "Backend");
        Employee e2 = new Engineer("Дмитрий", 202, 2700.0, "Frontend");
        Employee e3 = new Engineer("Елена", 203, 2900.0, "DevOps");

        Employee i1 = new Intern("Анна", 301, 800.0, 3);
        Employee i2 = new Intern("Павел", 302, 850.0, 6);

        employees.put(m1.getName(), m1);
        employees.put(m2.getName(), m2);
        employees.put(m3.getName(), m3);
        employees.put(e1.getName(), e1);
        employees.put(e2.getName(), e2);
        employees.put(e3.getName(), e3);
        employees.put(i1.getName(), i1);
        employees.put(i2.getName(), i2);

        System.out.println("=== Все ключи и значения Map<String, Employee> ===");
        for (Map.Entry<String, Employee> entry : employees.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + " -> Значение: " + entry.getValue());
        }
    }
}