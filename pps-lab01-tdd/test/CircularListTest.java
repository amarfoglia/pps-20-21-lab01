import lab01.tdd.CircularList;
import lab01.tdd.SelectStrategy;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int ADDED_ELEMENTS = 4;
    private static final int EVEN_ELEMENT   = 2;
    private static final int FIRST_ELEMENT  = 0;
    private static final int LAST_ELEMENT   = ADDED_ELEMENTS-1;
    private CircularList circularList;

    @BeforeEach
    void beforeEach() {
        circularList = new SimpleCircularList();
    }

    @Test
    void testInitialState() {
        assertTrue(circularList.isEmpty());
    }

    @Test
    void testAddition() {
        circularList.add(0);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSize() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        assertEquals(ADDED_ELEMENTS, circularList.size());
    }

    @Test
    void testNextOnEmptyList() {
        assertTrue(circularList.next().isEmpty());
    }

    @Test
    void testNextAfterAddition() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        IntStream.range(0, ADDED_ELEMENTS-1).forEach(i -> circularList.next());
        circularList.next().ifPresentOrElse(e -> assertEquals(LAST_ELEMENT, e), Assertions::fail);
    }

    @Test
    void testCircularityOnLastElement() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        IntStream.range(0, ADDED_ELEMENTS).forEach(i -> circularList.next());
        circularList.next().ifPresentOrElse(e -> assertEquals(FIRST_ELEMENT, e), Assertions::fail);
    }

    @Test
    void testCircularityOnFirstElement() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        circularList.previous();
        circularList.previous().ifPresentOrElse(e -> assertEquals(LAST_ELEMENT, e), Assertions::fail);
    }

    @Test
    void testPreviousOnEmptyList() {
        assertTrue(circularList.previous().isEmpty());
    }

    @Test
    void testPreviousAfterAddition() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        IntStream.range(0, ADDED_ELEMENTS).forEach(i -> circularList.previous());
        circularList.previous().ifPresentOrElse(e -> assertEquals(FIRST_ELEMENT, e), Assertions::fail);
    }

    @Test
    void testBackToLastElement() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        IntStream.range(0, ADDED_ELEMENTS-1).forEach(i -> circularList.next());
        circularList.previous().ifPresentOrElse(e -> assertEquals(LAST_ELEMENT, e), Assertions::fail);
    }

    @Test
    void testReset() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        circularList.next();
        circularList.reset();
        circularList.next().ifPresentOrElse(e -> assertEquals(FIRST_ELEMENT, e), Assertions::fail);
    }

    private final SelectStrategy evenStrategy = element -> element % 2 == 0;

    @Test
    void testEvenStrategy() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        circularList.next();
        circularList.next(evenStrategy).ifPresentOrElse(e -> assertEquals(EVEN_ELEMENT, e), Assertions::fail);
    }

    private final int MULTIPLE_TO_FIND = 2;
    private final SelectStrategy multipleOfStrategy = element -> element % MULTIPLE_TO_FIND == 0;

    @Test
    void testMultipleOfStrategy() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        circularList.next(); // go over zero element
        circularList.next(multipleOfStrategy).ifPresentOrElse(e -> assertEquals(EVEN_ELEMENT, e), Assertions::fail);
    }

    private final SelectStrategy equalsStrategy = element -> element == EVEN_ELEMENT;

    @Test
    void testEqualsStrategy() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        circularList.next(equalsStrategy).ifPresentOrElse(e -> assertEquals(EVEN_ELEMENT, e), Assertions::fail);
    }
}
