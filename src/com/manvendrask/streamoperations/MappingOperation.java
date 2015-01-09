package com.manvendrask.streamoperations;

import com.manvendrask.core.Programmer;

import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author Manvendra SK
 */
public class MappingOperation {

    void mapIntegers() {

        IntStream.rangeClosed(1, 5) // Yes there is also range() method.
                .map(x -> x * x)
                .forEach(System.out::println);
    }

    void mapProgrammers() {

        Function<Programmer, String> getProgrammerName = p -> p.getName();

        Programmer.programmers()
                .stream()
                .map(getProgrammerName)
//                .map(Programmer::getName)
                .forEach(System.out::println);
    }

    public static void main(String... args) {

        MappingOperation mappingOperation = new MappingOperation();
        mappingOperation.mapIntegers();

        System.out.println("--------------------------------------------");

        mappingOperation.mapProgrammers();
    }
}
