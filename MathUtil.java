public class MathUtil {

    // 5 Static Methods

    /**
     * Checks whether a given number n is prime.
     * @param n The number to check.
     * @return true if n is prime, false otherwise.
     */
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
     * @param a First integer.
     * @param b Second integer.
     * @return The GCD of a and b.
     */
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /**
     * Computes the least common multiple (LCM) of two numbers.
     * @param a First integer.
     * @param b Second integer.
     * @return The LCM of a and b.
     */
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Returns the nth Fibonacci number.
     * @param n The position in the Fibonacci sequence.
     * @return The nth Fibonacci number.
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    /**
     * Calculates the factorial of a number n.
     * @param n The number to calculate the factorial for.
     * @return The factorial of n.
     */
    public static long factorial(int n) {
        if (n == 0) return 1;
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 5 Non-static Methods

    /**
     * Determines if the given number n is a perfect number.
     * @param n The number to check.
     * @return true if n is a perfect number, false otherwise.
     */
    public boolean isPerfectNumber(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                sum += i + (n / i == i ? 0 : n / i);
            }
        }
        return sum == n && n != 1;
    }

    /**
     * Computes the sum of the digits of the given number n.
     * @param n The number to compute the sum of digits for.
     * @return The sum of the digits of n.
     */
    public int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    /**
     * Reverses the digits of a number n.
     * @param n The number to reverse.
     * @return The number formed by reversing the digits of n.
     */
    public int reverseNumber(int n) {
        int reversed = 0;
        while (n != 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    /**
     * Checks if a number is an Armstrong number.
     * @param n The number to check.
     * @return true if n is an Armstrong number, false otherwise.
     */
    public boolean isArmstrongNumber(int n) {
        int original = n, sum = 0, digits = Integer.toString(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    /**
     * Finds the smallest prime number greater than n.
     * @param n The number to start searching from.
     * @return The next prime number after n.
     */
    public int nextPrime(int n) {
        int next = n + 1;
        while (!isPrime(next)) {
            next++;
        }
        return next;
    }

    // Main method for testing the functionality of the MathUtil class
    public static void main(String[] args) {
        // Test static methods
        System.out.println("Static Methods Testing:");
        System.out.println("Is 11 prime? " + isPrime(11));
        System.out.println("GCD of 48 and 18: " + gcd(48, 18));
        System.out.println("LCM of 12 and 15: " + lcm(12, 15));
        System.out.println("7th Fibonacci number: " + fibonacci(7));
        System.out.println("Factorial of 5: " + factorial(5));

        // Create an object of MathUtil to test non-static methods
        MathUtil util = new MathUtil();

        System.out.println("\nNon-static Methods Testing:");
        System.out.println("Is 28 a perfect number? " + util.isPerfectNumber(28));
        System.out.println("Sum of digits of 1234: " + util.sumOfDigits(1234));
        System.out.println("Reversed number of 5678: " + util.reverseNumber(5678));
        System.out.println("Is 153 an Armstrong number? " + util.isArmstrongNumber(153));
        System.out.println("Next prime after 14: " + util.nextPrime(14));
    }
}