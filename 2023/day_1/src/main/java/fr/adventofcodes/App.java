package fr.adventofcodes;

import java.nio.file.Files;
import java.nio.file.Path;

public class App {

    public static void main(String[] args) throws Exception {

        var url = App.class.getClassLoader().getResource("input.txt").getFile();
        var extractor = new ValueExtractor();

        Path path = Path.of(url);

        try (var lines = Files.lines(path)) {
            var partOneSum = lines.mapToInt(extractor::extract).sum();

            System.out.println("part 1 result: " + partOneSum);
        }

        try (var lines = Files.lines(path)) {
            var partTwoSum = lines.mapToInt(extractor::extractWithText).sum();

            System.out.println("part 2 result: " + partTwoSum);
        }
    }
}
