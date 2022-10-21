import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PrimeNumberTest {

    @Test
    void bruteForceInRangeMethod() {
        List<Integer> ans = new ArrayList<>(Arrays.asList(2,3,5,7));
        assertEquals(ans, PrimeNumber.bruteForceInRangeMethod(1,10));
    }

    @Test
    void sieveOfEratosthenes() {
        List<Integer> ans = new ArrayList<>(Arrays.asList(2,3,5,7));
        assertEquals(ans, PrimeNumber.sieveOfEratosthenes(10));
    }

}