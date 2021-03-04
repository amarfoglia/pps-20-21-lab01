import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private static final int ADDED_ELEMENTS = 3;
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
        assertEquals(Optional.of(ADDED_ELEMENTS-1), circularList.next());
    }

    @Test
    void testCircularityOnLastElement() {
        IntStream.range(0, ADDED_ELEMENTS).forEach(circularList::add);
        IntStream.range(0, ADDED_ELEMENTS).forEach(i -> circularList.next());
        assertEquals(Optional.of(0), circularList.next());
    }
}
