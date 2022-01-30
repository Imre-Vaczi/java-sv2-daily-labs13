package day04;

import java.util.*;

public class ConsonantCounter {

    private Map<Character, Integer> stat = new TreeMap<>();
    private List<Character> cons = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');

    public Map<Character, Integer> getStat() {
        return stat;
    }

    public Map<Character, Integer> getStatistics(String text) {
        for(Character ch : text.toLowerCase(Locale.ROOT).toCharArray()) {
            refreshMap(text, ch);
        }
        return getStat();
    }

    private void refreshMap(String text, Character ch) {
        if (stat.containsKey(ch) & cons.contains(ch)) {
            stat.put(ch, stat.get(ch) +1 );
        } else {
            if (cons.contains(ch)) {
                stat.put(ch, 1);
            }
        }
    }
}
