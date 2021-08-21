package be.dimitrigevers.acting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CountActeurs {

    private static final Path myPath = Paths.get("opgave/acteurs-actrices.csv");

    public static void main(String[] args) {

    try ( Stream<String> myStream = Files.lines(myPath) ) {

        System.out.println( myStream
                .filter( l -> l.substring(l.lastIndexOf(";")+1).equals("F") )
                .count());
    } catch (IOException ioException) {
        ioException.printStackTrace();
    }



        try ( Stream<String> myStream = Files.lines(myPath) ) {

            if ((myStream.anyMatch( l -> l.substring(0, l.indexOf(";") ).equals("Vicki")))
            ) {
                System.out.println("Vicki komt voor");
            } else {
                System.out.println("Vicki komt niet voor");
            }
        } catch (IOException ioException) {
        ioException.printStackTrace();
    }
}
}
