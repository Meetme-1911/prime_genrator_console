import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SegmentedSieveOfEratosthenes {
    static List<Integer> primeNumbers = new ArrayList<>();
    static int[] array;
    static int[] primes;
    public static List<Integer> calculate(int n, int m) {
        int j = 0;
        int sqrtOfEndingValue = (int) Math.sqrt(m);
        array = new int[sqrtOfEndingValue + 1];
        primes = new int[sqrtOfEndingValue + 1];

        initialise(sqrtOfEndingValue + 1);
        for (int i = 2; i <= sqrtOfEndingValue; i++) {
            if (array[i] == 1) {
                primes[j] = i;
                j++;
                for (int k = i + i; k <= sqrtOfEndingValue; k += i) {
                    array[k] = 0;
                }
            }
        }
        int diff = (int) (m - n + 1);
        array = new int[diff];
        initialise(diff);
        for (int k = 0; k < j; k++) {
            int div = (int) (n / primes[k]);
            div *= primes[k];
            while (div <= m) {
                if(div>=n && primes[k]!=div)
                    array[(int) (div-n)] = 0;
                div += primes[k];
            }
        }
        for (int i = 0; i < diff; i++) {
            if (array[i] == 1 && (i+n) !=1)
            {
                primeNumbers.add((i+n));
                System.out.println(i + n);
            }
        }
        return primeNumbers;
    }
    public static void initialise(int s) {
        for (int i = 0; i < s; i++) {
            array[i] = 1;
        }
    }

    public static void main(String[] arg) {
        int t, n, m;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for (int i = 0; i < t; i++) {
            n = in.nextInt();
            m = in.nextInt();
            calculate(n, m);
            System.out.println();
        }
        in.close();
    }
}
