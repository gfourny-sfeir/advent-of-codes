package fr.adventofcodes;

import java.nio.file.Files;
import java.nio.file.Path;

public class App {

    public static void main(String[] args) throws Exception {

        var url = App.class.getClassLoader().getResource("input.txt").getFile();
        var extractor = new ValueExtractor();

        try (var lines = Files.lines(Path.of(url))) {
            var reduce = lines.mapToInt(extractor::extract).sum();

            System.out.println(reduce);
        }
    }
}
