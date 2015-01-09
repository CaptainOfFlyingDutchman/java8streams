package com.manvendrask.creatingstreams;

import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class StreamsFromValues {

    void singleStringStream() {
        Stream<String> singleStream = Stream.of("ME");
        singleStream.forEach(System.out::println);
    }

    void multipleStringStream() {
        Stream<String> multipleStream = Stream.of("I", "Me", "You");
        multipleStream.forEach(System.out::println);
    }

    void numbersStream() {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .filter(x -> x % 2 == 1)
                .map(x -> x * x)
                .reduce(0, Integer::sum);
        System.out.println("Sum is : " + sum);
    }

    public static void main(String... args) {

        StreamsFromValues streamsFromValues = new StreamsFromValues();
        streamsFromValues.singleStringStream();
        System.out.println("--------------------------------------------");
        streamsFromValues.multipleStringStream();
        System.out.println("--------------------------------------------");
        streamsFromValues.numbersStream();
    }
}
