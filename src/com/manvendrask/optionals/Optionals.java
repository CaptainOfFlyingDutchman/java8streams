package com.manvendrask.optionals;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Manvendra SK
 */
public class Optionals {

    void emptyOptional() {
        Optional<String> empty = Optional.empty();

        if (empty.isPresent())
            System.out.println("Optional contains value " + empty.get());
        else
            System.out.println("Optional is empty.");

    }

    void stringOptional() {
        Optional<String> stringOptional = Optional.of("I");

        if (stringOptional.isPresent())
            System.out.println("Optional contains value " + stringOptional.get());
        else
            System.out.println("Optional is empty.");

    }

    void useIfPresent() {
        Optional<String> stringOptional = Optional.of("I");

//        Consumer<String> optionalConsumer = x -> System.out.println("stringOptional contains : " + x);
//        stringOptional.ifPresent(optionalConsumer);
        stringOptional.ifPresent(x -> System.out.println("stringOptional contains : " + x));
    }

    void realUseOfOptional() {
        // This stream may end up empty after intermediate operations!
        OptionalInt maxOdd = IntStream.of(10, 20, 30, 37)  // Remove 37 from the list.
                .filter(x -> x % 2 == 1)
                .max();

        maxOdd.ifPresent(x-> System.out.println("maxOdd is : " + x));
    }

    public static void main(String... args) {

        Optionals optionals = new Optionals();
        optionals.emptyOptional();
        System.out.println("--------------------------------------------");

        optionals.stringOptional();

        System.out.println("--------------------------------------------");

        optionals.useIfPresent();

        System.out.println("--------------------------------------------");

        optionals.realUseOfOptional();
    }
}
