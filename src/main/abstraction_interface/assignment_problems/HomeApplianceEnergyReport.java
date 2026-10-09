package assignment_problems;

import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    abstract String getType();

    double calculateUnits() {
        return getPower() * hours / 1000;
    }

    double calculateCost(double units) {
        return units * 8;
    }
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }

    String getType() {
        return "FRIDGE";
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    String getType() {
        return "AC";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class Television extends Appliance {
    Television(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }

    String getType() {
        return "TV";
    }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    String getType() {
        return "WASHER";
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);

            saverRequested[i] =
                    input.length == 3 && input[2].equalsIgnoreCase("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AirConditioner(hours);
                    break;
                case "TV":
                    appliances[i] = new Television(hours);
                    break;
                case "WASHER":
                    appliances[i] = new WashingMachine(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                            "Invalid appliance type");
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i] &&
                    !(appliance instanceof SaverMode)) {
                System.out.println(
                        appliance.getType() + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}