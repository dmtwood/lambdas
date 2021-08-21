package be.dimitrigevers.countrycodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LastLandSorted {

    private static final Path MYPATH = Paths.get("opgave/landcodes.txt");

    public static void main(String[] args) {

        try (
                Stream<String> countries = Files.lines(MYPATH)
        ) {
                countries.map(line -> line.substring(line.indexOf(" ") + 1))
                        .max(String::compareTo)
                        .ifPresent(System.out::println);
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
