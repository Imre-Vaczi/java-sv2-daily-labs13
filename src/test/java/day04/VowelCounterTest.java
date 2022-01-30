package day04;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class VowelCounterTest {

    @Test
    void testCountingVowels() {
        VowelCounter vc = new VowelCounter();
        String input = "Bilbo is a cunning dog.";

        Map<Character, Integer> expected = Map.of('a', 1, 'i', 3, 'o', 2, 'u', 1);

        assertEquals(expected, vc.getStatistics(input));
    }

}