package test.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author JiaweiMao 2017.03.16
 * @since 1.0.0
 */
@DisplayName("Calculator")
class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void init() {
        System.out.println("Start testing");
    }

    @BeforeEach
    public void create() {
        this.calculator = new Calculator();
    }

    @AfterEach
    public void destroy() {
        this.calculator = null;
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("Finish testing");
    }

    @Test
    @DisplayName("Test 1 + 2 = 3")
    public void testAdd() {
        assertEquals(3, this.calculator.add(1, 2));
    }

    @Test
    @DisplayName("Test 3 - 2 = 1")
    public void testSubtract() {
        assertEquals(1, this.calculator.subtract(3, 2));
    }

    @Disabled
    @Test
    @DisplayName("disabled test")
    public void ignoredTest() {
        System.out.println("This test is disabled");
    }

}