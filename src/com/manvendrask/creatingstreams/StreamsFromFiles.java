package com.manvendrask.creatingstreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class StreamsFromFiles {

    void readFile(String filePath) {

        Path path  = Paths.get(filePath);

        if (!Files.exists(path)) {
            System.out.println("The file " + path.toAbsolutePath() + " doesn't exist.");
            return;
        }

        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String... args) {

        StreamsFromFiles streamsFromFiles = new StreamsFromFiles();
        streamsFromFiles.readFile("src/com/manvendrask/creatingstreams/StreamsFromFiles.java");
    }
}
