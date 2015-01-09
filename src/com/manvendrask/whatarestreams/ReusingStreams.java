package com.manvendrask.whatarestreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class ReusingStreams {

    // sum of squares of all odd integers from 1 to 5

    public void functional() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers.stream()
                .filter(ReusingStreams::oddNumber) // Lazy operation
                .map(ReusingStreams::square); // Lazy operation

        int sum = 0;
        sum = stream.reduce(0, ReusingStreams::sum); // Eager operation

        System.out.println("Functional: Sum of odd integers: " + sum);

        stream.reduce(0, ReusingStreams::sum); // Causes java.lang.IllegalStateException

    }

    static private boolean oddNumber(int number) {
        System.out.println("oddNumber called for: " + number);
        return number % 2 == 1;
    }

    static int square(int number) {
        System.out.println("square called for: " + number);
        return number * number;
    }

    static private int sum(int number1, int number2) {
        System.out.println("sum called for: " + number1 + ", " + number2);
        return number1 + number2;
    }


    public static void main(String... args) {

        ReusingStreams reusingStreams = new ReusingStreams();
        reusingStreams.functional();

    }
}
