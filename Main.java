import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("no arguments");
            return;
        }
        if (Objects.equals(args[0], "-R")) {
            int countLine = 5;
            if (args.length == 2) {
                countLine = Integer.parseInt(args[1]);
            }
            List<String> lines = readFile("output.txt", countLine);
            for (String line : lines) {
                System.out.println(line);
            }
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

    public static List<String> readFile(String filename, int stringNumber) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int count = 1;
            for (String line; (line = br.readLine()) != null && count <= stringNumber; count++) {
                lines.add(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return lines;
    }
}