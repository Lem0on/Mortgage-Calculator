package crosskey.main;

public class Prospect {
    private final String name;
    private final double totalLoan;
    private final double interest;
    private final double years;

    public Prospect(String name, double totalLoan, double interest, double years) {
        this.name = name;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public double getYears() {
        return years;
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "name='" + name + '\'' +
                ", totalLoan=" + totalLoan +
                ", interest=" + interest +
                ", years=" + years +
                '}';
    }
}
