package fr.adventofcodes;

public class ValueExtractor {

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
}
