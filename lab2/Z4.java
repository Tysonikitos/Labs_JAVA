import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Z4 {
    public static void main(String[] args) {
        String text = "aeeea aeea aea axa axxa axxxa";
        
        // Регулярное выражение: 
        // a - начинается с 'a'
        // (e+|x+) - либо одна или более букв 'e', либо одна или более букв 'x'
        // a - заканчивается на 'a'
        Pattern pattern = Pattern.compile("a(e+|x+)a");
        Matcher matcher = pattern.matcher(text);

        System.out.println("Найденные совпадения:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}