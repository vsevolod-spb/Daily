import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("no arguments");
            return;
        }

        String now = currentDateTime();

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            for (String arg : args) {
                String output = String.format("[%s] %s\n", now, arg);
                writer.write(output);
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Success");
    }

    public static String currentDateTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return currentTime.format(timeFormatter);
    }
}