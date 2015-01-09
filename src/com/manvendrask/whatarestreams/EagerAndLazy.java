package com.manvendrask.whatarestreams;

import com.sun.deploy.security.SecureStaticVersioning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class EagerAndLazy {

    // sum of squares of all odd integers from 1 to 5

    public void functional() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Stream<Integer> stream = numbers.stream()
                .filter(EagerAndLazy::oddNumber) // Lazy operation
                .map(EagerAndLazy::square); // Lazy operation

        int sum = 0;
        sum = stream.reduce(0, EagerAndLazy::sum); // Eager operation. Try commenting this line.

        System.out.println("Functional: Sum of odd integers: " + sum);

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
        EagerAndLazy eagerAndLazy = new EagerAndLazy();
        eagerAndLazy.functional();
    }
}
