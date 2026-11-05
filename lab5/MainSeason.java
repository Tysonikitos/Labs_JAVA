import java.util.ArrayList;

enum Season {
    WINTER, SPRING, SUMMER, AUTUMN
}

class Month {
    String name;
    Season season;

    public Month(String name, Season season) {
        this.name = name;
        this.season = season;
    }
}

public class MainSeason {
    public static void main(String[] args) {
        ArrayList<Month> months = new ArrayList<>();
        months.add(new Month("Январь", Season.WINTER));
        months.add(new Month("Февраль", Season.WINTER));
        months.add(new Month("Март", Season.SPRING));
        months.add(new Month("Апрель", Season.SPRING));
        months.add(new Month("Май", Season.SPRING));
        months.add(new Month("Июнь", Season.SUMMER));
        months.add(new Month("Июль", Season.SUMMER));
        months.add(new Month("Август", Season.SUMMER));
        months.add(new Month("Сентябрь", Season.AUTUMN));
        months.add(new Month("Октябрь", Season.AUTUMN));
        months.add(new Month("Ноябрь", Season.AUTUMN));
        months.add(new Month("Декабрь", Season.WINTER));

        System.out.println("Летние месяцы:");
        for (Month m : months) {
            if (m.season == Season.SUMMER) {
                System.out.println(m.name);
            }
        }
    }
}