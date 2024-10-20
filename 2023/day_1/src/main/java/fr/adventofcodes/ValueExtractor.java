package fr.adventofcodes;

import static java.lang.Character.isDigit;
import static java.util.Objects.isNull;

public class ValueExtractor {

    public int extract(String string) {

        String firstNumber = null;
        String lastNumber = null;

        for (char c : string.toCharArray()) {

            if (isDigit(c)) {

                if (isNull(firstNumber)) {
                    firstNumber = String.valueOf(c);
                }

                if (c != firstNumber.charAt(0)) {
                    lastNumber = String.valueOf(c);
                }
            }
        }

        if (isNull(lastNumber)) {
            lastNumber = firstNumber;
        }

        return Integer.parseInt(firstNumber + lastNumber);
    }
}
