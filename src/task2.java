import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) {
        String inputFilePath = "D:\\ГОУАЙТИ\\дз10\\file2.txt";
        String outputFilePath = "user.json";

        List<User> userList = readUsersFromFile(inputFilePath);
        writeUsersToJsonFile(userList, outputFilePath);
    }

    public static List<User> readUsersFromFile(String filePath) {
        List<User> userList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] headers = reader.readLine().split("\\s+"); // Отримуємо назви колонок з першого рядка
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");
                User user = new User();
                for (int i = 0; i < headers.length; i++) {
                    if (i < data.length) {
                        switch (headers[i]) {
                            case "name":
                                user.setName(data[i]);
                                break;
                            case "age":
                                user.setAge(Integer.parseInt(data[i]));
                                break;
                            // Додайте інші колонки, якщо вони є
                        }
                    }
                }
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static void writeUsersToJsonFile(List<User> userList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(userList);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class User {
        private String name;
        private int age;

        // Геттери і сеттери для полів name та age

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

      
