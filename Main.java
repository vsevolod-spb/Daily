import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Main {
    public static void main(String[] args) {
        String now = currentDateTime();
        System.out.println("Hello, World");

        for (String arg : args) {

            String output = String.format("[%s] %s", now, arg);
            System.out.println(output);
        }
    }

    public static String currentDateTime() {
        LocalDateTime currentTime = LocalDateTime.now(); // Create a date object
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(timeFormatter);

    }
}