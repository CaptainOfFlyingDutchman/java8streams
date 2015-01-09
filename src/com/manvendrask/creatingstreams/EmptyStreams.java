package com.manvendrask.creatingstreams;

import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class EmptyStreams {

    void emptyStream() {
        Stream<String> singleStream = Stream.empty();
        singleStream.forEach(System.out::println);
    }


    public static void main(String... args) {

        EmptyStreams streamFromValues = new EmptyStreams();
        streamFromValues.emptyStream();
    }
}
