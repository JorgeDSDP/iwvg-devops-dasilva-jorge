package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testUserDatabase() {
        assertEquals(6, new UsersDatabase().findAll().toList().size());
    }
}
