package test.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;

/**
 * @author JiaweiMao 2017.03.16
 * @since 1.0.0
 */
public class StandardTests {

    @BeforeAll
    static void initAll() {
    }

    @BeforeEach
    void init() {
    }

    @Test
    void succeedingTest() {
    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    static void tearDownAll() {
    }

}
