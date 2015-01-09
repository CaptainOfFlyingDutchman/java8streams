package com.manvendrask.streamoperations;

import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class DebuggingStreams {

    void peekItems() {
        int sum = Stream.of(1, 2, 3, 4, 5)
                .peek(x -> System.out.println("Getting : " + x))
                .filter(x -> x % 2 == 1)
                .peek(x -> System.out.println("Filtered : " + x))
                .map(x -> x * x)
                .peek(x -> System.out.println("Mapped : " + x))
                .reduce(0, Integer::sum);

        System.out.println("Sum of odd numbers is : " + sum);
    }

    public static void main(String... args) {

        DebuggingStreams debuggingStreams = new DebuggingStreams();
        debuggingStreams.peekItems();
    }
}
