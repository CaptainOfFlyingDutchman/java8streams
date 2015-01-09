package com.manvendrask.creatingstreams;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Manvendra SK
 */
public class StreamsFromCollections {

    void createStringStream() {

        Set<String> pronouns = new HashSet<>();
        pronouns.add("I");
        pronouns.add("Me");
        pronouns.add("You");

        pronouns.stream().forEach(System.out::println);
    }


    public static void main(String... args) {

        StreamsFromCollections streamsFromCollections = new StreamsFromCollections();
        streamsFromCollections.createStringStream();
    }
}
