package day04;

import java.util.*;

public class VowelCounter {

    private Map<Character, Integer> stat = new TreeMap<>();
    private List<Character> vows = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public Map<Character, Integer> getStat() {
        return stat;
    }

    public Map<Character, Integer> getStatistics(String text) {
        for(Character ch : text.toLowerCase(Locale.ROOT).toCharArray()) {
            if (stat.containsKey(ch) & vows.contains(ch)) {
                stat.put(ch, stat.get(ch) +1 );
            } else {
                if (vows.contains(ch)) {
                    stat.put(ch, 1);
                }
            }
        }
        return getStat();
    }
}
