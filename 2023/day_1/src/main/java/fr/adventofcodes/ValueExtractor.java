package fr.adventofcodes;

import java.util.LinkedHashMap;
import java.util.Map;

public class ValueExtractor {

    private final LinkedHashMap<String, String> textNumbers = new LinkedHashMap<>(
            Map.of(
                    "one", "one1one",
                    "two", "two2two",
                    "three", "three3three",
                    "four", "four4four",
                    "five", "five5five",
                    "six", "six6six",
                    "seven", "seven7seven",
                    "eight", "eight8eight",
                    "nine", "nine9nine"
            )
    );

    private static String getLastDigit(String digits) {
        return String.valueOf(digits.charAt(digits.length() - 1));
    }

    private static String getFirstDigit(String digits) {
        return String.valueOf(digits.charAt(0));
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

        return Integer.parseInt(firstDigit.concat(lastDigit));
    }

    public int extractWithText(String string) {
        for (var entry : textNumbers.entrySet()) {
            if (string.contains(entry.getKey())) {
                string = string.replace(entry.getKey(), entry.getValue());
            }
        }
        return extract(string);
    }
}
