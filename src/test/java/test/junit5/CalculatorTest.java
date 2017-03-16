package test.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JiaweiMao 2017.03.16
 * @since 1.0.0
 */
@Tag("Addition tag for class or method")
@DisplayName("Calculator")
        // the name of the test class or method
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll // run once before all methods
    public static void init() {
        System.out.println("Start testing");
    }

    @BeforeEach // run before every method
    public void create() {
        this.calculator = new Calculator();
    }

    @AfterEach // run after every method
    public void destroy() {
        this.calculator = null;
    }

    @AfterAll // run once after all methods
    public static void cleanup() {
        System.out.println("Finish testing");
    }

    @Test // It is a test method
    @DisplayName("Test 1 + 2 = 3")
    public void testAdd() {
        assertEquals(3, this.calculator.add(1, 2));

        assertNotEquals(4, 1 + 2);

        assertNotSame(new Object(), new Object());

        Object obj = new Object();
        assertSame(obj, obj);

        assertFalse(1 > 2);
        assertTrue(1 < 2);

        assertNull(null);
        assertNotNull(new Object());

        assertArrayEquals(new int[]{1, 2}, new int[]{1, 2});

        assertAll("Math",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0));

        assertThrows(ArithmeticException.class, () -> System.out.println(1 / 0));

        // make a test failed.
        fail("This should fail");
    }

    @Test
    @DisplayName("Test 3 - 2 = 1")
    public void testSubtract() {
        assertEquals(1, this.calculator.subtract(3, 2));
    }

    @Disabled // disable test class or method
    @Test
    @DisplayName("disabled test")
    public void ignoredTest() {
        System.out.println("This test is disabled");
    }

}