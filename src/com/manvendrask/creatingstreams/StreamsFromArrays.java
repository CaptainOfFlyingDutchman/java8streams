package com.manvendrask.creatingstreams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class StreamsFromArrays {

    void integerArrayStream() {
        IntStream intStream = Arrays.stream(new int[]{1, 2, 3, 4, 5});
        intStream.forEach(System.out::println);
    }

    void stringArrayStream() {
        Stream<String> stringStream = Arrays.stream(new String[]{"I", "Me", "You"});
        stringStream.forEach(System.out::println);
    }

    public static void main(String... args) {

        StreamsFromArrays streamsFromArrays = new StreamsFromArrays();
        streamsFromArrays.integerArrayStream();
        System.out.println("--------------------------------------------");
        streamsFromArrays.stringArrayStream();
    }
}
