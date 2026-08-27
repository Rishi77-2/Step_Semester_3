package controlflow.practice_problems;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int reversedNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number = number / 10;
        }

        if (reversedNumber == originalNumber) {
            System.out.println("The number " + originalNumber + " is a Palindrome");
        } else {
            System.out.println("The number " + originalNumber + " is not a Palindrome");
        }
    }
}