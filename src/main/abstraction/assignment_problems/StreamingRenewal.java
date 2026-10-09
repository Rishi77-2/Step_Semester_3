package assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Subscription {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Subscription {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Subscription {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Subscription[] subscriptions = new Subscription[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC":
                    subscriptions[i] =
                            new BasicPlan(name, startDate);
                    break;
                case "STANDARD":
                    subscriptions[i] =
                            new StandardPlan(name, startDate);
                    break;
                case "PREMIUM":
                    subscriptions[i] =
                            new PremiumPlan(name, startDate);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan type");
            }
        }

        for (Subscription subscription : subscriptions) {
            System.out.println(subscription.name + ": "
                    + subscription.getRenewalDate());
        }

        sc.close();
    }
}