package assignment_problems;

import java.util.Scanner;

interface NightService {
    double NIGHT_FACTOR = 1.20;
}

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    abstract String getType();

    double calculateFare() {
        return Math.max(km * getRate(), 100);
    }
}

class MiniCab extends Cab {
    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getType() {
        return "MINI";
    }
}

class SedanCab extends Cab implements NightService {
    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    String getType() {
        return "SEDAN";
    }

    double calculateNightFare() {
        return calculateFare() * NIGHT_FACTOR;
    }
}

class SUVCab extends Cab implements NightService {
    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    String getType() {
        return "SUV";
    }

    double calculateNightFare() {
        return calculateFare() * NIGHT_FACTOR;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            times[i] = sc.next().toUpperCase();

            switch (type) {
                case "MINI":
                    cabs[i] = new MiniCab(km);
                    break;
                case "SEDAN":
                    cabs[i] = new SedanCab(km);
                    break;
                case "SUV":
                    cabs[i] = new SUVCab(km);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid cab type");
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];
            double fare;

            if (times[i].equals("NIGHT")) {
                if (cab instanceof NightService) {
                    if (cab instanceof SedanCab) {
                        fare = ((SedanCab) cab).calculateNightFare();
                    } else {
                        fare = ((SUVCab) cab).calculateNightFare();
                    }
                } else {
                    System.out.println(
                            cab.getType() + ": night service not available");
                    continue;
                }
            } else {
                fare = cab.calculateFare();
            }

            System.out.printf("%s: %.2f%n", cab.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}