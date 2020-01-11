package main;

public class Mortgage {
    private double remainingPrincipal;
    private final double interest;
    private double totalPaid;
    private double monthlyPayment;

    public Mortgage(double principal, double interest, double years) {
        this.remainingPrincipal = principal;
        this.interest = interest;
        double annualPayment = (Math.pow((1 + interest), years) * principal * interest) / (Math.pow((1 + interest), years) -1);
        this.monthlyPayment = annualPayment / 12;

        System.out.println("Monthly payment is " + this.monthlyPayment);
        System.out.println("Total remaining is  " + this.monthlyPayment * years * 12);
    }

    public void makeMonthlyPayments() {
        this.totalPaid += this.monthlyPayment;
        this.remainingPrincipal = ((1 + (interest/12))*this.remainingPrincipal) - this.monthlyPayment;
    }

    public double getRemainingPrincipal() {
        return remainingPrincipal;
    }

    public static void test() {

        Mortgage m = new Mortgage(2000, 0.058, 10);
        m.makeMonthlyPayments();

        int i = 0;
        while (m.getRemainingPrincipal() > 0 ) {
            System.out.println("total unpaid is "+ m.getRemainingPrincipal());
            System.out.println("Making monthly payment...");
            m.makeMonthlyPayments();
            System.out.println("total unpaid is "+ m.getRemainingPrincipal());

            System.out.println("Payment count" + ++i);
        }


    }

    public double getTotalPaid() {
        return totalPaid;
    }
}
