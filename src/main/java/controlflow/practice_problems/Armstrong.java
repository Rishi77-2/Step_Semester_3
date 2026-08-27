package controlflow.practice_problems;

import java.util.Scanner;

public class Armstrong {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum = sum + digit * digit * digit;

            number = number / 10;
        }

        if (sum == originalNumber) {
            System.out.println("The number " + originalNumber + " is an Armstrong number");
        } else {
            System.out.println("The number " + originalNumber + " is not an Armstrong number");
        }
    }
}