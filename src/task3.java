import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class task3 {

    public static void main(String[] args) {
        String filePath = "D:\\ГОУАЙТИ\\дз10\\words.txt";
        Map<String, Integer> wordFrequencyMap = countWordFrequency(filePath);
        printWordFrequency(wordFrequencyMap);
    }

    public static Map<String, Integer> countWordFrequency(String filePath) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Розбиваємо рядок на слова, використовуючи пробіли як роздільник
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Збільшуємо лічильник для поточного слова
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordFrequencyMap;
    }

    public static void printWordFrequency(Map<String, Integer> wordFrequencyMap) {
        // Сортуємо слова за кількістю входжень у зворотньому порядку
        wordFrequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}
