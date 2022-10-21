
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        int choice, choiceOfAlgo;
        int startValue;
        int endValue;
        boolean flag = true;
        boolean flagForSecondSwitch;

        while (flag) {

            System.out.println("================================================");
            System.out.println("Prime generator console application");
            System.out.println("================================================");
            System.out.println("1. Prime Numbers lower than a number");
            System.out.println("2. Prime Numbers between a range");
            System.out.println("3. Exit application");

            Scanner scanner = new Scanner(System.in);

            try {
                choice = scanner.nextInt();

                switch (choice) {

                    case 1:
                        flagForSecondSwitch = true;
                        while (flagForSecondSwitch) {

                            System.out.println("================================================");
                            System.out.println("Prime generator lower than a single number");
                            System.out.println("================================================");
                            System.out.println("1. Brute force approach ");
                            System.out.println("2. Sieve of eratosthenes ");
                            System.out.println("3. Go Back to Main Menu ");

                            choiceOfAlgo = scanner.nextInt();

                            switch (choiceOfAlgo) {
                                case 1:
                                    System.out.println("Please enter the number ");
                                    System.out.println("Number :");
                                    endValue = scanner.nextInt();

                                    if (endValue <= 0) {
                                        System.out.println("Please enter number greater than 0 .");
                                        break;
                                    }

                                    bruteForceInRangeMethod(0, endValue);
                                    break;
                                case 2:
                                    System.out.println("Please enter the number ");
                                    System.out.println("Number :");
                                    endValue = scanner.nextInt();

                                    if (endValue <= 0) {
                                        System.out.println("Please enter number greater than 0 .");
                                        break;
                                    }
                                    sieveOfEratosthenes(endValue);
                                    break;
                                case 3:
                                    flagForSecondSwitch = false;
                                    break;
                                default:
                                    System.out.println("Please enter a valid input");
                                    break;
                            }
                        }
                        break;

                    case 2:
                        flagForSecondSwitch = true;
                        while (flagForSecondSwitch) {
                            System.out.println("================================================");
                            System.out.println("Prime generator for a specific range");
                            System.out.println("================================================");
                            System.out.println("1. Brute force approach ");
                            System.out.println("2. Sieve of eratosthenes ");
                            System.out.println("3. Go Back to Main Menu ");

                            choiceOfAlgo = scanner.nextInt();

                            switch (choiceOfAlgo) {

                                case 1:
                                    System.out.println("Please enter the values :");
                                    System.out.println("startValue :");
                                    startValue = scanner.nextInt();
                                    System.out.println("endValue :");
                                    endValue = scanner.nextInt();

                                    if (startValue < 0 || endValue < 0) {
                                        System.out.println("Please enter positive values in numbers");
                                        break;
                                    } else if (startValue > endValue || startValue == endValue) {
                                        System.out.println("Please provide valid range .");
                                        break;
                                    }

                                    System.out.println("Prime numbers between " + startValue + " and " + endValue + " are :");
                                    bruteForceInRangeMethod(startValue, endValue);
                                    break;

                                case 2:

                                    System.out.println("Please enter the values :");
                                    System.out.println("startValue :");
                                    startValue = scanner.nextInt();
                                    System.out.println("endValue :");
                                    endValue = scanner.nextInt();
                                    if (startValue < 0 || endValue < 0) {
                                        System.out.println("Please enter positive values in numbers");
                                        break;
                                    } else if (startValue > endValue || startValue == endValue) {
                                        System.out.println("Please provide valid range .");
                                        break;
                                    }
                                    System.out.println("Prime numbers between " + startValue + " and " + endValue + " are :");
                                    SegmentedSieveOfEratosthenes.calculate(startValue, endValue);
                                    break;

                                case 3:
                                    flagForSecondSwitch = false;
                                    break;

                                default:
                                    System.out.println("Please enter a valid input");
                                    break;
                            }
                        }
                        break;
                    case 3:
                        flag = false;
                        break;
                    default:
                        System.out.println("Please enter valid value ");

                }
            } catch (Exception e) {
                System.out.println("Please Input valid number / less than 10^9");
            }

        }
    }

    public static List<Integer> bruteForceInRangeMethod(int startValue, int endValue) {

        List<Integer> ans = new ArrayList<>();

        if (startValue < 2 && endValue > 2) {
            System.out.print("2 ");
            ans.add(2);
        }
        startValue = Math.max(startValue, 3);
        if (startValue % 2 == 0) {
            ++startValue;
        }
        boolean primeFlag;

        for (int i = startValue; i < endValue; i = i + 2) {
            primeFlag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    primeFlag = false;
                    break;
                }
            }
            if (primeFlag) {
                ans.add(i);
                System.out.print(i + " ");

            }
        }
        System.out.println();
        return ans;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] prime = new boolean[(n + 1)];
        for (int i = 0; i <= n; i++) prime[i] = true;

        for (int j = 2; j <= Math.sqrt(n); j++) {
            if (prime[j]) {
                for (int i = (int) Math.pow(j, 2); i <= n; i += j)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return primeNumbers;
    }

}