package crosskey.main;

/**
 * represents a prospect
 * @param name name of the person
 * @param totalLoan the total loan
 * @param interest the yearly interest
 * @param years amount of years to pay off the mortgage
 */
public record Prospect(String name, double totalLoan, double interest, double years) {

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
