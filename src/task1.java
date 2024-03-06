import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task1 {

    public static void main(String[] args) {
        // Вказуємо абсолютний шлях до файлу
        String filePath = "D:\\ГОУАЙТИ\\дз10\\file1.txt";
        validatePhoneNumbers(filePath);
    }

    public static void validatePhoneNumbers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // Удаляем лишние пробелы в начале и конце строки
                // Проверяем, соответствует ли строка одному из форматов номера телефона
                if (line.matches("\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
