class Employee {
    String fullname;
    double salary;

    public Employee(String fullname, double salary) {
        this.fullname = fullname;
        this.salary = salary;
    }
}

class Report {
    String str1 = "ФИО";
    String str2 = "ЗАРПЛАТА";
    public static void generateReport(Employee[] employees) {        
        // Шаблон: %-15s - фамилия (выравнивание по левому краю, ширина 15)
        // %10.2f - зарплата (выравнивание по правому краю, ширина 10, 2 знака после запятой)
        System.out.printf("%-15s | %10s%n", "ФИО", "ЗАРПЛАТА" );
        for (Employee emp : employees) {
            System.out.printf("%-15s | %10.2f%n", emp.fullname, emp.salary);
        }
    }
}

public class Z3 {
    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Иванов", 1250.50),
            new Employee("Петров", 3400.0),
            new Employee("Сидоров", 890.75)
        };

        Report.generateReport(employees);
    }
}