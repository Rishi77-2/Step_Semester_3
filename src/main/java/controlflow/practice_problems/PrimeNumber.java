package controlflow.practice_problems;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < number; i++) {

            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("Is the number " + number + " a Prime number? true");
        } else {
            System.out.println("Is the number " + number + " a Prime number? false");
        }
    }
}