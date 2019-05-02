import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralCalculatorTest {

    private String actual;
    private String expected;
    private RomanNumeralCalculator calculator = new RomanNumeralCalculator();

    @Test
    public void onePlusOneIsTwo() {
        actual = calculator.add("I", "I");
        expected = "II";

        assertEquals(expected, actual);
    }

    @Test
    public void twoPlusTwoIsFour() {
        actual = calculator.add("II", "II");
        expected = "IV";

        assertEquals(expected, actual);
    }

    @Test
    public void fourPlusFourIsEight() {
        actual = calculator.add("IV" , "IV");
        expected = "VIII";

        assertEquals(expected, actual);
    }

    @Test
    public void fourPlusFiveIsNine() {
        actual = calculator.add("IV", "V");
        expected = "IX";

        assertEquals(expected, actual);
    }
}
