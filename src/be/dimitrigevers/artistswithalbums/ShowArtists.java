package be.dimitrigevers.artistswithalbums;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ShowArtists {
    private static final Path textFilePath = Paths.get("opgave/albumsartists.txt");

    public static void main(String[] args) {
        try (
                Stream<String> artistsStream = Files.lines(textFilePath)
               // BufferedReader bufRead = Files.newBufferedReader(textFilePath)
        ) {
            // to run simultane, create a new stream
//                artistsStream
//                        .map(line -> line.substring(line.indexOf(',') +1) )
//                        .distinct()
//                        .sorted()
//                        .forEach(System.out::println);

            Map<String, List<String>> albumsByArtist = artistsStream.collect( Collectors
                    .groupingBy( line -> line.substring( line.indexOf(',')+1 ) )
            );

            albumsByArtist.entrySet().stream()
//                    .sorted( (entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                    .sorted(Map.Entry.comparingByKey())
                    .forEach( entry -> {
                                    System.out.println(entry.getKey());
                                    entry.getValue().stream()
                                            .map( line -> line.substring(0, line.indexOf(',')))
                                            .sorted()
                                            .forEach( album -> System.out.println("\t" + album));
                    }
                    );


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
