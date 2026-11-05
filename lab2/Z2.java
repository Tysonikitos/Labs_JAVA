public class Z2 {
    public static void main(String[] args) {
        String sentence = "Разработка, отладка и испытание программ с использованием строк";
        
        String[] words = sentence.split("\\s+");
        
        System.out.println("Результат разбиения предложения на слова:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}