class Book {
    String title;
    String author;
    int pages;

    static int totalBooks = 0;
    static int totalPages = 0;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;

        totalBooks++;
        totalPages += pages;
    }

    public static double getAveragePages() {
        if (totalBooks == 0) {
            return 0;
        }
        return (double) totalPages / totalBooks;
    }

    public void displayInfo() {
        System.out.println("Книга: \"" + title + "\", Автор: " + author + ", Страниц: " + pages);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Мастер и Маргарита", "М. А. Булгаков", 480);
        Book b2 = new Book("Преступление и наказание", "Ф. М. Достоевский", 608);
        Book b3 = new Book("Java. Полное руководство", "Г. Шилдт", 1344);
        Book b4 = new Book("Старик и море", "Э. Хемингуэй", 112);

        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();
        b4.displayInfo();

        System.out.println("----------------------------------------");
        System.out.println("Всего книг в библиотеке: " + Book.totalBooks);
        System.out.println("Общее количество страниц: " + Book.totalPages);
        System.out.printf("Среднее количество страниц: " + Book.getAveragePages());
    }
}