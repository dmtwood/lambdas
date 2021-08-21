package be.dimitrigevers.sterrenbeelden;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class SterrenbeeldenUsingMethodRefs {

    private static final Path MYPATH = Paths.get("opgave/sterrenbeelden.txt");

    public static void main(String[] args) {

        try (
                Stream<String> myStream = Files.lines(MYPATH)
                ) {
                myStream
                        .map(String::toUpperCase)
                        .forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
