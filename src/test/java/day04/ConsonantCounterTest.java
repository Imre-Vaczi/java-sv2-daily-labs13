package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConsonantCounterTest {

    @Test
    void testGetStatistics() {
        ConsonantCounter cc = new ConsonantCounter();
        String input = "Bilbo is a cunning dog.";

        Map<Character, Integer> expected = Map.of('b',2,'c', 1, 'd', 1, 'g', 2, 'l', 1, 'n', 3, 's', 1);

        assertEquals(expected, cc.getStatistics(input));
    }

}