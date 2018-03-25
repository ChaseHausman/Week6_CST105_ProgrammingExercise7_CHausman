/**
 * Program: Week6
 * File: PalindromicPrime.java
 * Summary: Displays the palindromic prime numbers between 0 and 100,000.
 * Author: Chase Hausman
 * Date: March 24, 2018
 */
public class PalindromicPrime {
    public static void main(String args[]) {
        for (int i = 1; i < 100000; i++) {
            if(isPrime(i) && isPalindromic(i)) {
                System.out.println(i);
            }
        }
    }

    // Determines if a number is a prime number or not (at least slowly)
    private static boolean isPrime(int number) {
        // Ignore if number is number 1
        if(number == 1) {
            return false;
        }

        // We only need to search the first half, since beyond that is only repetition.
        int stoppingPoint = (int) Math.ceil(Math.sqrt(number));

        // Loop through every integer between 2 and the stopping point
        for(int i = 2; i <= stoppingPoint; i++) {
            if(number % i == 0 && number != i) {
                return false;
            }
        }

        // If we make it through the entire loop without a failure, we can assume the result is true
        return true;
    }

    // Determines if a number is palindromic
    private static boolean isPalindromic(int number) {
        // Convert to a String where it's easier to look at the digits themselves
        String stringNumber = String.valueOf(number);

        // Quickly check first & last characters. If they're different we don't need to go any further.
        String first = stringNumber.substring(0, 1);
        String last = stringNumber.substring(stringNumber.length() - 1, stringNumber.length());
        if(!first.equals(last)) {
            return false;
        }

        // Make a string that is stringNumber backwards
        String stringNumberBackwards = "";
        for (int i = stringNumber.length() - 1; i >= 0; i--) {
            stringNumberBackwards = stringNumberBackwards.concat(stringNumber.substring(i, i + 1));
        }

        // If the forwards and backwards Strings are the same, it's true
        return stringNumberBackwards.equals(stringNumber);
    }
}
