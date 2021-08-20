package be.dimitrigevers.sterrenbeelden;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SterrenbeeldenLezer {

//    private static final Path filePath = Paths.get("opgave/sterrenbeelden.txt");
//    private static final Path absPath = filePath.toAbsolutePath();

    // makes it work from terminal => java Sterrenbeelden.java
    private static final Path absPathDirect = Paths.get("D:\\Java\\lambdas\\opgave\\sterrenbeelden.txt");


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

    public static void main(String[] args) {
//        SterrenbeeldenLezer reader = new SterrenbeeldenLezer();
        leesSterrenbeelden();
    }
}
