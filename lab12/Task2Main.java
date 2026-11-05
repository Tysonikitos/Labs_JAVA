import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Student {
    private int id;
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(int id, String name, String group, int course, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }
}

public class Task2Main {

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getAverageGrade() < 3.0) {
                iterator.remove();
            } else {
                s.setCourse(s.getCourse() + 1);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("=== Студенты на " + course + " курсе ===");
        for (Student s : students) {
            if (s.getCourse() == course) {
                System.out.println("ID: " + s.getId() + ", Имя: " + s.getName() +
                                   ", Группа: " + s.getGroup() + ", Средний балл: " + s.getAverageGrade());
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Борис", "ПО-21", 2, Arrays.asList(4, 5, 4, 5)));
        students.add(new Student(2, "Игорь", "ПО-21", 2, Arrays.asList(2, 2, 3, 2)));
        students.add(new Student(3, "Анна", "ПО-21", 2, Arrays.asList(5, 4, 4, 5)));
        students.add(new Student(4, "Мария", "ПО-22", 1, Arrays.asList(5, 5, 5, 5)));
        students.add(new Student(5, "Денис", "ПО-22", 1, Arrays.asList(3, 3, 4, 4)));
        students.add(new Student(6, "Олег", "ПО-22", 1, Arrays.asList(2, 3, 2, 2)));

        processStudents(students);
        printStudents(students, 3);

        students.sort(Comparator.comparingDouble(Student::getAverageGrade).reversed()
                .thenComparing(Student::getName));

        System.out.println("\n=== Отсортированный список студентов ===");
        for (Student s : students) {
            System.out.printf("ID: %d | Имя: %s | Средний балл: %.2f%n",
                    s.getId(), s.getName(), s.getAverageGrade());
        }
    }
}