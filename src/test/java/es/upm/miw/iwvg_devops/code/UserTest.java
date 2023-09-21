package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


class UserTest {
    AutoCloseable openMocks;
    private User user;

    @Mock
    private Fraction mockFraction;

    @BeforeEach
    void beforeEachFunction() {
        openMocks = MockitoAnnotations.openMocks(this);
        user = new User("1", "Jorge", "Da Silva", new ArrayList<>());
        when(mockFraction.toString()).thenReturn("1/5");
    }

    @Test
    void testGetId() {
        Assertions.assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        Assertions.assertEquals("Jorge", user.getName());
    }

    @Test
    void testSetName() {
        user.setName("Jorg");
        Assertions.assertEquals("Jorg", user.getName());
    }

    @Test
    void testGetFamilyName() {
        Assertions.assertEquals("Da Silva", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        user.setFamilyName("DaSilva");
        Assertions.assertEquals("DaSilva", user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        Assertions.assertIterableEquals(List.of(), user.getFractions());
    }

    @Test
    void testSetFractions() {
        user.setFractions(List.of(mockFraction));
        Assertions.assertIterableEquals(List.of(mockFraction), user.getFractions());
    }

    @Test
    void testAddFraction() {
        user.addFraction(mockFraction);
        Assertions.assertIterableEquals(List.of(mockFraction), user.getFractions());
    }

    @Test
    void testFullName() {
        Assertions.assertEquals("Jorge Da Silva", user.fullName());
    }

    @Test
    void testInitials() {
        Assertions.assertEquals("J.", user.initials());
    }

    @Test
    void testToStringFractionsEmpty() {
        String expectedString = "User{" +
                "id='" + "1" + '\'' +
                ", name='" + "Jorge" + '\'' +
                ", familyName='" + "Da Silva" + '\'' +
                ", fractions=" + "[]" +
                '}';
        Assertions.assertEquals(expectedString, user.toString());
    }

    @Test
    void testToStringFractionsDefined() {
        user.addFraction(mockFraction);
        String expectedString = "User{" +
                "id='" + "1" + '\'' +
                ", name='" + "Jorge" + '\'' +
                ", familyName='" + "Da Silva" + '\'' +
                ", fractions=" + "[1/5]" +
                '}';
        Assertions.assertEquals(expectedString, user.toString());
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }
}
