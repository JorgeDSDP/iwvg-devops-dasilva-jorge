package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SearchesTest {
    @Test
    void testFindUserFamilyNameByUserNameDistinct() {
        assertEquals(List.of("Torres"), new Searches().findUserFamilyNameByUserNameDistinct("Paula")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFractionNumeratorByFamilyName() {
        assertEquals(List.of(2, 4, 0, 1, 1), new Searches().findFractionNumeratorByUserFamilyName("Torres")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFamilyNameByFractionDenominator() {
        assertEquals(List.of("López", "Torres"), new Searches().findUserFamilyNameByFractionDenominator(2)
                .collect(Collectors.toList()));
    }

    @Test
    void testFindFirstProperFractionByUserId() {
        assertEquals(new Fraction(1, 5), new Searches().findFirstProperFractionByUserId("3"));
    }

    @Test
    void testFindFirstProperFractionByUserIdButNullInstead() {
        assertNull(new Searches().findFirstProperFractionByUserId("4"));
    }

    @Test
    void findFractionMultiplicationByUserFamilyNameOnlyOneUser() {
        assertEquals(new Fraction(12, -240),
                new Searches().findFractionMultiplicationByUserFamilyName("López"));
    }

    @Test
    void findFractionMultiplicationByUserFamilyNameOnlyTwoUsers() {
        assertEquals(new Fraction(0, -360),
                new Searches().findFractionMultiplicationByUserFamilyName("Blanco"));
    }

    @Test
    void testFindDecimalFractionByNegativeSignFraction() {
        assertEquals(List.of(-0.2, -0.5, -0.0), new Searches().findDecimalFractionByNegativeSignFraction().toList());
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(2.0, 1.333), new Searches().findDecimalImproperFractionByUserName("Ana").toList());
    }
}
