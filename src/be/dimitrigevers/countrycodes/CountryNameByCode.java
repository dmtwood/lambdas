package be.dimitrigevers.countrycodes;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Scanner;

public class CountryNameByCode {
    private static final Path textFileUri = Paths.get("opgave/landcodes.txt");

    private static Optional<String> getCountryName(String countryCode) {

        try (BufferedReader myTextFileReader = Files.newBufferedReader(textFileUri)) {

            for (String textLine; (textLine = myTextFileReader.readLine()) != null; ) {
                if (textLine.substring(0, textLine.indexOf(' ')).equals(countryCode)) {
                    return Optional.of(textLine.substring(textLine.indexOf(' ') + 1) );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a country code");
        String countryCode = scanner.nextLine();

        getCountryName(countryCode).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Not in list.")
        );



    }

}
