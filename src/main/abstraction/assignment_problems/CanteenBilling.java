package assignment_problems;

import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();

    abstract String getType();
}

class StudentCustomer extends Customer {
    StudentCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }

    String getType() {
        return "STUDENT";
    }
}

class StaffCustomer extends Customer {
    StaffCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }

    String getType() {
        return "STAFF";
    }
}

class GuestCustomer extends Customer {
    GuestCustomer(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }

    String getType() {
        return "GUEST";
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Customer[] bills = new Customer[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT":
                    bills[i] = new StudentCustomer(amount);
                    break;
                case "STAFF":
                    bills[i] = new StaffCustomer(amount);
                    break;
                case "GUEST":
                    bills[i] = new GuestCustomer(amount);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid customer type");
            }
        }

        double total = 0;

        for (Customer customer : bills) {
            double finalAmount = customer.calculateAmount();
            System.out.printf("%s: %.2f%n",
                    customer.getType(), finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}