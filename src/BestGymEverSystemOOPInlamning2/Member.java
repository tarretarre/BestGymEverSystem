package BestGymEverSystemOOPInlamning2;

public class Member {
    String ssn;
    String name;
    String latestPayment;

    public Member(String ssn, String name, String latestPayment) {
        this.ssn = ssn;
        this.name = name;
        this.latestPayment = latestPayment;
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public String getLatestPayment() {
        return latestPayment;
    }

    @Override
    public String toString() {
        return "ssn: " + ssn + '\'' +
                ", name: " + name + '\'' +
                ", latestPayment: " + latestPayment;
    }
}
