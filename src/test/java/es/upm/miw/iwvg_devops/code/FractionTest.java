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

    @Test
    void testAddWithLCMBeingOneDenominator() {
        Fraction fraction2 = new Fraction(2, 4);
        Assertions.assertEquals(new Fraction(7, 8), fraction.add(fraction2));
    }

    @Test
    void testAddWithLCMNotBeingOneDenominator() {
        Fraction fraction2 = new Fraction(2, 7);
        Assertions.assertEquals(new Fraction(37, 56), fraction.add(fraction2));
    }

    @Test
    void testIsProperTrue() {
        Assertions.assertTrue(fraction.isProper());
    }

    @Test
    void testIsProperFalse() {
        Assertions.assertFalse(new Fraction(8, 7).isProper());
    }

    @Test
    void testIsImproperTrue() {
        Assertions.assertTrue(new Fraction(8, 7).isImproper());
    }

    @Test
    void testIsImproperFalse() {
        Assertions.assertFalse(fraction.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Assertions.assertTrue(fraction.isEquivalent(new Fraction(6, 16)));
    }

    @Test
    void testMultiply() {
        Assertions.assertEquals(new Fraction(6, 40), fraction.multiply(new Fraction(2, 5)));
    }

    @Test
    void testDivide() {
        Assertions.assertEquals(new Fraction(15, 16), fraction.divide(new Fraction(2, 5)));
    }
}
