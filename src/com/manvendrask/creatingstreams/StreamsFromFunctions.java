package com.manvendrask.creatingstreams;

import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class StreamsFromFunctions {

    void iterate() {

        Stream<Long> naturalNumbers = Stream.iterate(1L, x -> x + 1).limit(10); // Show the usage of skip(long)

        Stream<Long> oddNaturalNumbers = Stream.iterate(1L, x -> x + 2).limit(10);

        naturalNumbers.forEach(x-> System.out.print(x + " "));

        System.out.println("\n--------------------------------------------");

        oddNaturalNumbers.forEach(x-> System.out.print(x + " "));
    }

    void generate() {

        Stream.generate(Math::random).limit(10).forEach(x-> System.out.print(x + " "));
    }


    public static void main(String... args) {

        StreamsFromFunctions streamsFromFunctions = new StreamsFromFunctions();
        streamsFromFunctions.iterate();
        System.out.println("\n--------------------------------------------");
        streamsFromFunctions.generate();
    }
}
