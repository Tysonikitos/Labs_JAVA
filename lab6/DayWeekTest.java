class DayWeek {
    private int value; 

    DayWeek() {
        value = 1; 
    }

    public int Get() {
        return value;
    }

    public void Set(int _value) {
        if ((_value >= 1) && (_value <= 7)) {
            value = _value;
        }
    }

    public String GetName() {
        String day = "Monday";
        switch (value) {
            case 2: day = "Tuesday"; break;
            case 3: day = "Wednesday"; break;
            case 4: day = "Thursday"; break;
            case 5: day = "Friday"; break;
            case 6: day = "Saturday"; break;
            case 7: day = "Sunday"; break;
        }
        return day;
    }
}

public class DayWeekTest {
    public static void main(String[] args) {
        DayWeek day = new DayWeek();
        System.out.println("По умолчанию: " + day.Get() + " (" + day.GetName() + ")");

        day.Set(5);
        System.out.println("После Set(5): " + day.Get() + " (" + day.GetName() + ")");

        day.Set(9); 
        System.out.println("После Set(9): " + day.Get() + " (" + day.GetName() + ")");
    }
}