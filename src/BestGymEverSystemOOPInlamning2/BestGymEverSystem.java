package BestGymEverSystemOOPInlamning2;

import java.io.IOException;
import java.util.List;

public class BestGymEverSystem {
    private String inFilePathString = ".\\src\\Sprint2Inlamning\\filMedlemmar.txt";
    public BestGymEverSystem() throws IOException {
        List<Member> membersList = IOUtil.readDataFromFile(inFilePathString);

        List<Member> membersCategory = MemberCategory.getMemberCategory(membersList);
    }

    public static void main(String[] args) throws IOException {
        BestGymEverSystem bge = new BestGymEverSystem();
    }
}
