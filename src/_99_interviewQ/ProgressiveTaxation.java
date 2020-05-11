/*
 * Progressive taxation
 * The nation of examplania has the following income tax brackets:
 * income cap       marginal tax rate
 * 10,000           0.00 (0%)
 * 30,000           0.10 (10%)
 * 100,000          0.25 (25%)
 * --               0.40 (40%)
 * Given a whole number income amount up to 100,000,000, find the amount of tax
 * owned in examplania. Round down to a whole number.
 * One aspect of progressive taxation is that increasing your income will never
 * decrease the amount of tax you owe, or your overall tax rate.
 */
package _99_interviewQ;

/**
 *
 * @author I300939
 */
public class ProgressiveTaxation {
    int tax = 0;
    public int tax(int income, int[] cap, double[] rate) {
        for (int i = cap.length - 1; i >= 0; i--) {
            if (income > cap[i]) {
                tax = (int)((income - cap[i]) * rate[i]);
                for (int j = i - 1; j >=1; j--) {
                    tax += (cap[j+1] - cap[j]) * rate[j];
                }
                break;
            }
        }
        return tax;
    }
    
    public static void main(String[] args) {
        ProgressiveTaxation me = new ProgressiveTaxation();
        int[] cap = new int[] {0, 10000, 30000, 100000};
        double[] rate = new double[] {0, 0.1, 0.25, 0.4};
        System.out.println("150000 tax: " + me.tax(150000, cap, rate));
        System.out.println("50000 tax: " + me.tax(50000, cap, rate));
        System.out.println("25000 tax: " + me.tax(25000, cap, rate));
        System.out.println("5000 tax: " + me.tax(5000, cap, rate));
    }
}
