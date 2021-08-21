package be.dimitrigevers.sterrenbeelden;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class SterrenbeeldenLezer {

    // makes it work from terminal => java Sterrenbeelden.java
    private static final Path absPathDirect = Paths.get("D:\\Java\\lambdas\\opgave\\sterrenbeelden.txt");

    public static void main(String[] args) {

        // try with resources to auto close source after use
        try (
            Stream<String> myStream = Files.lines(absPathDirect)
        ) {
            myStream.forEach(line -> System.out.println(line.toUpperCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // idem without stream
        leesSterrenbeelden();

        System.out.println("Enter a substring to search for in the list");
        Scanner scanner = new Scanner(System.in);
        String searchString = scanner.nextLine();
        try (
                Stream<String> myStream = Files.lines(absPathDirect)
        ) {
            myStream.filter(line -> line.contains(searchString)).forEach(System.out::println);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private static void leesSterrenbeelden() {
        System.out.println("abs path: " + absPathDirect );
        try ( BufferedReader bufReader = Files.newBufferedReader(absPathDirect) ) {
            for (String line; ( line = bufReader.readLine() ) != null;) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
