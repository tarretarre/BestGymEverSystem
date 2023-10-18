package BestGymEverSystemOOPInlamning2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOUtil {
    public static List<Member> readDataFromFile(String readFromFile) {
        String firstLine;
        String secondLine;

        List<Member> membersList = new ArrayList<>();

        String[] membersDataFirstLine = new String[2];
        String[] membersDataSecondLine = new String[1];
        Path inFilePath = Paths.get(readFromFile);

        try (Scanner fileScanner = new Scanner(inFilePath)) {
            while (fileScanner.hasNext()) {
                firstLine = fileScanner.nextLine();
                membersDataFirstLine = firstLine.split(",");
                if (fileScanner.hasNext()) {
                    secondLine = fileScanner.nextLine();
                    membersDataSecondLine = new String[]{secondLine};
                }

                Member m = new Member(membersDataFirstLine[0].trim(),
                        membersDataFirstLine[1].trim(),
                        membersDataSecondLine[0].trim());

                membersList.add(m);
            }

        } catch (IOException e) {
            System.out.println("Fel inträffade vid inläsning av fil.");
        }
        return membersList;
    }

    public static void writeDataToFile(String writeToFilePath, List<Member> toPTList) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(writeToFilePath, true))) {
            for (Member member : toPTList) {
                printWriter.append("Medlem: " + member.getName() + ", Besöksdatum: " + LocalDate.now() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ett fel har inträffat: " + e.getMessage());
        }
    }
}
