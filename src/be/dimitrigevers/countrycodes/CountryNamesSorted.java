package be.dimitrigevers.countrycodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CountryNamesSorted {
    private static final Path countryNamesPath = Paths.get("opgave/landcodes.txt");

    public static void main(String[] args) {

        try (
            Stream<String>  countryStream = Files.lines(countryNamesPath)
        ){
            countryStream
                    .map(line -> line.substring(line.indexOf(" ") ) )
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
