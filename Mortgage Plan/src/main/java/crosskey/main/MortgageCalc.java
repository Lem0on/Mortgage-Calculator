package crosskey.main;

import java.util.List;

/**
 * Defines a list of prospects and a way to calculate monthly payments
 */
public class MortgageCalc {
    private final List<Prospect> prospectList;

    public MortgageCalc(List<Prospect> prospectList) {
        this.prospectList = prospectList;
    }

    /**
     *
     * @param interest the yearly interest
     * @param years in how many years the mortgage will be paid of
     * @param loan the total loan
     * @return the monthly cost
     */
    public double calculate(double interest, double years, double loan) {
        double result;

        double monthlyInterest = (interest/100)/12;
        double payments = years*12;
        double bracket1 = monthlyInterest*(pow(1+monthlyInterest, payments));
        double bracket2 = pow(1+monthlyInterest, payments) - 1;
        result = loan*(bracket1/bracket2);

        return result;
    }

    public List<Prospect> getProspectList() {
        return prospectList;
    }

    /**
     * prints the prospects
     */
    public void print() {
        int count = 1;
        for(Prospect p : prospectList) {
            double result = calculate(p.interest(), p.years(), p.totalLoan());
            // monthly cost displayed with two decimal places
            String formattedResult = String.format("%.2f", result);
            System.out.println("Prospect "+count+": "+p.name()+" wants to borrow "+p.totalLoan()+
                               " € for a period of "+p.years()+" years and pay "+formattedResult+" € each month" +
                               "\n-------------------------------------------------------------------------------------------------");
            count++;
        }
    }

    /**
     *
     * @param num the number to be raised
     * @param power the power to raise to
     * @return the result of the calculation
     */
    private double pow(double num, double power) {
        double result = num;

        for(int i = 1; i < power; i++) {
            result = result * num;
        }

        return result;
    }

    // Alternative to using formatted printing, will round to two decimal places
    /*private double round(double num) {
        double x = num * 100.0;
        x += 0.5;
        x = (long) x;
        x /= 100.0;
        System.out.println(x);
        return x;
    }*/
}
