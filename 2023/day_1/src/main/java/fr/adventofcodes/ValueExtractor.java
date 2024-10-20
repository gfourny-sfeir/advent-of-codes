package fr.adventofcodes;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.stream.StreamSupport;

import static java.lang.Character.isDigit;
import static java.lang.Character.valueOf;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class ValueExtractor {

    public int extract(String string){

        String firstNumber = null;
        String lastNumber = null;

        var charArray = string.toCharArray();

        for (char c : charArray) {

            if (isDigit(c)) {

                if (isNull(firstNumber)) {
                    firstNumber = String.valueOf(c);
                }

                if (c != firstNumber.charAt(0)) {
                    lastNumber = String.valueOf(c);
                }
            }
        }

        if (isNull(lastNumber)){
            lastNumber = firstNumber;
        }

        return Integer.parseInt(firstNumber + lastNumber);
    }
}
