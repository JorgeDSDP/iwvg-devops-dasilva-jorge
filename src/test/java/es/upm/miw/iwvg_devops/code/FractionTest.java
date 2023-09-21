package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FractionTest {

    private Fraction fraction;

    @BeforeEach
    void beforeEachFunction() {
        fraction = new Fraction(3, 8);
    }

    @Test
    void testGetNumerator() {
        Assertions.assertEquals(3, fraction.getNumerator());
    }

    @Test
    void testSetNumerator() {
        fraction.setNumerator(4);
        Assertions.assertEquals(4, fraction.getNumerator());
    }

    @Test
    void testGetDenominator() {
        Assertions.assertEquals(8, fraction.getDenominator());
    }

    @Test
    void testSetDenominator() {
        fraction.setDenominator(4);
        Assertions.assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testDecimal() {
        Assertions.assertEquals(0.375, fraction.decimal());
    }
}
