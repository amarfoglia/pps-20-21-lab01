import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
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
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }
}
