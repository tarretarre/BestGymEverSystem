package BestGymEverSystemOOPInlamning2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberCategory {

    public static String calculatePeriod(LocalDate paymentDate, LocalDate todayDate)
    {
        Period period = Period.between(paymentDate, todayDate);
        return String.format("%d years, %d months, %d days", period.getYears(), period.getMonths(), period.getDays());
    }

    public static List<Member> getMemberCategory(List<Member> allMembers) {
        final String outFilePathString = ".\\src\\Sprint2Inlamning\\PT.txt";

        try (Scanner sc = new Scanner(System.in)) {

            List<Member> onlyMembers = new ArrayList<>();

            System.out.println("Ange fullständigt namn eller personnummer (10 siffror): ");
            String input = sc.nextLine();

            LocalDate todayDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            for (Member m : allMembers) {
                if (input.equalsIgnoreCase(m.getName()) || input.equalsIgnoreCase(m.getSsn())) {
                    LocalDate latestPaymentDateFormatted = LocalDate.parse(m.getLatestPayment(), formatter);

                    Period period = Period.between(latestPaymentDateFormatted, todayDate);

                    if (period.getYears() == 0 && period.getMonths() <= 12) {
                        System.out.println("Angiven person är medlem och betalade för " +
                                calculatePeriod(latestPaymentDateFormatted, todayDate) + " sedan.");
                        onlyMembers.add(m);
                        try {
                            IOUtil.writeDataToFile(outFilePathString, onlyMembers);
                        } catch (IOException e) {
                            System.out.println("Ett fel inträffade vid skrivning till fil." + e.getMessage());
                        }
                    } else {
                        System.out.println("Personens medlemskap har förfallit.");
                    }
                    return allMembers;
                }
            }
            System.out.println("Personen är inte medlem på Best Gym Ever.");
        } catch (Exception e) {
            System.out.println("Ett fel har inträffat " + e.getMessage());
        }
        return allMembers;
    }
}
