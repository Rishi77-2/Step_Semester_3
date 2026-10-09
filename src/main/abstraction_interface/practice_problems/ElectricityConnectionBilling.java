package practice_problems;

import java.util.Scanner;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();

    abstract String getType();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100) {
            return units * 5;
        }
        return 100 * 5 + (units - 100) * 7;
    }

    String getType() {
        return "HOME";
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }

    String getType() {
        return "SHOP";
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }

    String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double units = sc.nextDouble();

            switch (type) {
                case "HOME":
                    connections[i] = new Home(units);
                    break;
                case "SHOP":
                    connections[i] = new Shop(units);
                    break;
                case "FACTORY":
                    connections[i] = new Factory(units);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid connection type");
            }
        }

        double total = 0;

        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n",
                    connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}