import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SegmentedSieveOfEratosthenesTest {

    @Test
    void calculate() {
        List<Integer> ans = new ArrayList<>(Arrays.asList(2,3,5,7));
        assertEquals(ans, SegmentedSieveOfEratosthenes.calculate(1,10));
    }
}