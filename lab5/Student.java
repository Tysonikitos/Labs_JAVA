public class Student {
    String name;
    int age;
    String group;

    public Student(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public void displayInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Группа: " + group);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Никита", 19, "Т-391");
        Student student2 = new Student("Алексей", 20, "Т-392");

        student1.displayInfo();
        student2.displayInfo();
    }
}