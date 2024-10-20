package fr.adventofcodes;

import java.util.function.BiFunction;

public class ValueExtractor {

    private static char getLastDigit(String digits) {
        return digits.charAt(digits.length() - 1);
    }

    private static char getFirstDigit(String digits) {
        return digits.charAt(0);
    }

    public int extract(String string) {

        var digits = string.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .reduce("", String::concat);

        if (digits.isEmpty()) {
            return 0;
        }

        var firstDigit = getFirstDigit(digits);
        var lastDigit = getLastDigit(digits);

        BiFunction<Character, Character, String> toString = (first, last) -> String.valueOf(first) + last;

        return Integer.parseInt(toString.apply(firstDigit, lastDigit));
    }
}
