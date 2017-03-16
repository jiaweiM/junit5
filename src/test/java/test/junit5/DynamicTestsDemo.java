package test.junit5;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * The standard @Test annotation in JUnit Jupiter described in Annotations is very similar to the @Test annotation in
 * JUnit 4. Both describe methods that implement test cases. These test cases are static in the sense that they are
 * fully specified at compile time, and their behavior cannot be changed by anything happening at runtime. Assumptions
 * provide a basic form of dynamic behavior but are intentionally rather limited in their expressiveness.
 *
 * In addition to these standard tests a completely new kind of test programming model has been introduced in JUnit
 * Jupiter. This new kind of test is a dynamic test which is generated at runtime by a factory method that is annotated
 * with @TestFactory.
 *
 * In contrast to @Test methods, a @TestFactory method is not itself a test case but rather a factory for test cases.
 * Thus, a dynamic test is the product of a factory. Technically speaking, a @TestFactory method must return a Stream,
 * Collection, Iterable, or Iterator of DynamicTest instances. These DynamicTest instances will then be executed lazily,
 * enabling dynamic and even non-deterministic generation of test cases.
 *
 * As with @Test methods, @TestFactory methods must not be private or static and may optionally declare parameters to be
 * resolved by ParameterResolvers.
 *
 * A DynamicTest is a test case generated at runtime. It is composed of a display name and an Executable. Executable is
 * a @FunctionalInterface which means that the implementations of dynamic tests can be provided as lambda expressions or
 * method references.
 */
class DynamicTestsDemo {

    // This will result in a JUnitException!
    @TestFactory
    List<String> dynamicTestsWithInvalidReturnType() {
        return Arrays.asList("Hello");
    }

    @TestFactory
    Collection<DynamicTest> dynamicTestsFromCollection() {
        return Arrays.asList(
                dynamicTest("1st dynamic test", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Iterable<DynamicTest> dynamicTestsFromIterable() {
        return Arrays.asList(
                dynamicTest("3rd dynamic test", () -> assertTrue(true)),
                dynamicTest("4th dynamic test", () -> assertEquals(4, 2 * 2))
        );
    }

    @TestFactory
    Iterator<DynamicTest> dynamicTestsFromIterator() {
        return Arrays.asList(
                dynamicTest("5th dynamic test", () -> assertTrue(true)),
                dynamicTest("6th dynamic test", () -> assertEquals(4, 2 * 2))
        ).iterator();
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of("A", "B", "C").map(
                str -> dynamicTest("test" + str, () -> { /* ... */ }));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        // Generates tests for the first 10 even integers.
        return IntStream.iterate(0, n -> n + 2).limit(10).mapToObj(
                n -> dynamicTest("test" + n, () -> assertTrue(n % 2 == 0)));
    }

    @TestFactory
    Stream<DynamicTest> generateRandomNumberOfTests() {

        // Generates random positive integers between 0 and 100 until
        // a number evenly divisible by 7 is encountered.
        Iterator<Integer> inputGenerator = new Iterator<Integer>() {

            Random random = new Random();
            int current;

            @Override
            public boolean hasNext() {
                current = random.nextInt(100);
                return current % 7 != 0;
            }

            @Override
            public Integer next() {
                return current;
            }
        };

        // Generates display names like: input:5, input:37, input:85, etc.
        Function<Integer, String> displayNameGenerator = (input) -> "input:" + input;

        // Executes tests based on the current input value.
        ThrowingConsumer<Integer> testExecutor = (input) -> assertTrue(input % 7 != 0);

        // Returns a stream of dynamic tests.
        return DynamicTest.stream(inputGenerator, displayNameGenerator, testExecutor);
    }

}