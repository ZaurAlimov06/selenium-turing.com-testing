import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxCalculatorTest {

    MaxCalculator calculator;

    @Before
    public void setUp() {
       calculator = new MaxCalculator(); 
    }

    @Test
    public void baseMaxTests() {
        assertEquals("Max of 3 and 5 must be 5", 5, calculator.max(3, 5));
        assertEquals("Max of 10 and 7 must be 10", 10, calculator.max(10, 7));
        assertEquals("Max of -5 and -2 must be -2", -2, calculator.max(-5, -2));
        assertEquals("Max of 3 and 3 must be 3", 3, calculator.max(3, 3));
    }
}
