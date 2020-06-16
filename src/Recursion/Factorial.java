package Recursion;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int number) {
        if (number == 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number");
        int number = s.nextInt();
        System.out.println("Factorial of " + number + " is " + factorial(number));
    }
}
