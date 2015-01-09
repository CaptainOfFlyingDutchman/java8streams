package com.manvendrask.whatarestreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class UnderstandingStreams {

    // sum of squares of all odd integers from 1 to 5

    public void functional() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> numbersStream = numbers.stream();

        Stream<Integer> oddNumbersStream = numbersStream.filter(x -> x % 2 == 1);

        Stream<Integer> squaredNumbersStream = oddNumbersStream.map(x-> x*x);

        int sum = squaredNumbersStream.reduce(0, (x, y) -> x + y);

        System.out.println("Functional: Sum of odd integers: " + sum);

    }


    public static void main(String... args) {

        UnderstandingStreams understandingStreams = new UnderstandingStreams();
        understandingStreams.functional();

    }
}
