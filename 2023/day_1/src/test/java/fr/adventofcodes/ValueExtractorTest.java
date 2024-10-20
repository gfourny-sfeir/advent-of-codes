package fr.adventofcodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValueExtractorTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', textBlock = """
            1abc2                 | 12
            pqr3stu8vwx           | 38
            a1b2c3d4e5f           | 15
            treb7uchet            | 77
            7jlncfksix7rjgrpglmn9 | 79
            two8591mrvchg4        | 84
            """)
    void should_correctly_get_numbers(String string, int value) {

        var extractor = new ValueExtractor();

        var result = extractor.extract(string);

        assertThat(result).isEqualTo(value);
    }
}
