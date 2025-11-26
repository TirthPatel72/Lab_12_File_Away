import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();
        int idCounter = 1;
        String more;

        do {
            String firstName = SafeInput.getNonZeroLengthString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLengthString(in, "Enter Last Name");
            String id = String.format("%06d", idCounter++);
            String email = SafeInput.getNonZeroLengthString(in, "Enter Email");
            int year = SafeInput.getRangedInt(in, "Enter Year of Birth", 1900, 2025);

            String record = String.format("%s, %s, %s, %s, %d", firstName, lastName, id, email, year);
            records.add(record);

            more = String.valueOf(SafeInput.getYNConfirm(in, "Add another record?"));

        } while (more.equalsIgnoreCase("Y"));

        String fileName = SafeInput.getNonZeroLengthString(in, "Enter filename to save (without extension)") + ".csv";

        try (FileWriter writer = new FileWriter("src/" + fileName)) {
            for (String rec : records) {
                writer.write(rec + "\n");
            }
            System.out.println("Data saved to src/" + fileName);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}