import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests
 * 20.1 will return 20:1 .1:1
 * .03 will return .01:3
 * 15.35 that will return 10:1 5:1 .25:1 .05:2
 * 0.00 will return array with all 0s
 * 2157.79 will return 20:107 10:1 5:1 2:1 .25:3 .01:4
 **/
class CashRegisterTest {
    private CashRegister testCashRegister = new CashRegister();
    private final float [] usDenominations = {.01f, .05f, .10f, .25f, 1f, 5f, 10f, 20f};
    private int [] smallestChange = new int[usDenominations.length];

    @Before
    public void setUpTests() {
        Arrays.fill(smallestChange, 0);
    }
    @Test
    public void testValue_20Decimal10() {
        smallestChange[smallestChange.length-1] = 1;
        smallestChange[2] = 1;
        assertArrayEquals(smallestChange, testCashRegister.findSmallestChange(usDenominations, 20.10f));
    }
    @Test
    public void testValue_Decimal03() {
        smallestChange[0] = 3;
        assertArrayEquals(smallestChange, testCashRegister.findSmallestChange(usDenominations, .03f));
    }
    @Test
    public void testValue_15Decimal35() {
        smallestChange = new int[] {0,0,1,1,0,1,1,0};
        assertArrayEquals(smallestChange, testCashRegister.findSmallestChange(usDenominations, 15.35f));
    }
    @Test
    public void testValue_0() {
        assertArrayEquals(smallestChange, testCashRegister.findSmallestChange(usDenominations, 0.00f));
    }
    @Test
    public void testValue_2157Decimal79() {
        smallestChange = new int[] {4,0,0,3,2,1,1,107};
        assertArrayEquals(smallestChange, testCashRegister.findSmallestChange(usDenominations, 2157.79f));
    }
}