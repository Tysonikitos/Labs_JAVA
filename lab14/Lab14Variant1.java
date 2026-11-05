import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.Random;

public class Lab14Variant1 {

    public static void main(String[] args) {
        System.out.println("=== ВЫПОЛНЕНИЕ ЛАБОРАТОРНОЙ РАБОТЫ № 14 (Вариант 1) ===\n");
        
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        System.out.println("--- Задача 1: Информация о группе и файле ---");
        String filename = "group_info.txt";
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Специальность: 5-04-0612-02");
            writer.println("Разработка и сопровождение программного обеспечения информационных систем");
            writer.println("Группа: ПО-11");
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File(filename);
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Файл существует: " + file.exists());
        
        System.out.println("\nСодержимое файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void task2() {
        System.out.println("--- Задача 2: 10 целых чисел и поиск минимума ---");
        String filename = "f_integers.txt";
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите 10 целых чисел (через пробел или Enter):");
            for (int i = 0; i < 10; i++) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                } else {
                    writer.println(0);
                    scanner.next(); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Считанные из файла числа: ");
        int min = Integer.MAX_VALUE;
        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextInt()) {
                int num = fileScanner.nextInt();
                System.out.print(num + " ");
                if (num < min) {
                    min = num;
                }
            }
            System.out.println("\nМинимальное значение: " + min);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void task3() {
        System.out.println("--- Задача 3: Распределение чисел по файлам (кратные 3) ---");
        String f = "f_random.txt";
        String g = "g_mult3.txt";
        String h = "h_other.txt";
        Random random = new Random();

        try (PrintWriter writerF = new PrintWriter(new FileWriter(f))) {
            for (int i = 0; i < 15; i++) {
                writerF.println(random.nextInt(100) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner readerF = new Scanner(new File(f));
             PrintWriter writerG = new PrintWriter(new FileWriter(g));
             PrintWriter writerH = new PrintWriter(new FileWriter(h))) {

            while (readerF.hasNextInt()) {
                int num = readerF.nextInt();
                if (num % 3 == 0) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
            System.out.println("Числа успешно распределены. Кратные 3 записаны в '" + g + "', остальные — в '" + h + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void task4() {
        System.out.println("--- Задача 4: Средняя влажность воздуха ---");
        String filename = "humidity.txt";
        Scanner scanner = new Scanner(System.in);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите 12 вещественных значений влажности воздуха (%):");
            for (int i = 0; i < 12; i++) {
                if (scanner.hasNextDouble()) {
                    writer.println(scanner.nextDouble());
                } else {
                    writer.println(0.0);
                    scanner.next();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            double sum = 0;
            int count = 0;
            while (fileScanner.hasNextDouble()) {
                sum += fileScanner.nextDouble();
                count++;
            }
            if (count > 0) {
                System.out.println("Средняя влажность воздуха: " + (sum / count) + "%");
            } else {
                System.out.println("Файл пуст.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void task5() {
        System.out.println("--- Задача 5: Подсчет отрицательных чисел ---");
        String filename = "f_negatives.txt";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < 10; i++) {
                writer.println(random.nextInt(61) - 30);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(new File(filename))) {
            int negativeCount = 0;
            System.out.print("Сгенерированные числа в файле: ");
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.print(num + " ");
                if (num < 0) {
                    negativeCount++;
                }
            }
            System.out.println("\nКоличество отрицательных чисел: " + negativeCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}