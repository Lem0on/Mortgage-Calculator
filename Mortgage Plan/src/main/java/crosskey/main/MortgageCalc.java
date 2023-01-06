package crosskey.main;

import java.util.List;

public class MortgageCalc {
    private final List<Prospect> prospectList;

    public MortgageCalc(List<Prospect> prospectList) {
        this.prospectList = prospectList;
    }

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

    public void print() {
        int count = 1;
        for(Prospect p : prospectList) {
            double result = calculate(p.getInterest(), p.getYears(), p.getTotalLoan());
            String formattedResult = String.format("%.2f", result);
            System.out.println("Prospect "+count+": "+p.getName()+" wants to borrow "+p.getTotalLoan()+
                                " € for a period of "+p.getYears()+" years and pay "+formattedResult+" € each month");
            count++;
        }
    }

    private double pow(double num, double power) {
        double result = num;

        for(int i = 1; i < power; i++) {
            result = result * num;
        }

        return result;
    }

    /*private double round(double num) {
        double x = num * 100.0;
        x += 0.5;
        x = (long) x;
        x /= 100.0;
        System.out.println(x);
        return x;
    }*/
}
