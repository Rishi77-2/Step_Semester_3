package practice_problems;

public class PiggyBank {
    private double savings;
    private final String bankId;

    public PiggyBank(String bankId) {
        this.bankId = bankId;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.println("Savings = " + savings);
        } else {
            System.out.println("Invalid deposit");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected");
        } else {
            savings -= amount;
            System.out.println("Savings = " + savings);
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings = " + pb.getSavings());
    }
}