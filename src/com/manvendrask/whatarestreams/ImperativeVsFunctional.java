package com.manvendrask.whatarestreams;

import java.util.Arrays;
import java.util.List;

/**
 * @author Manvendra SK
 */
public class ImperativeVsFunctional {

    // sum of squares of all odd integers from 1 to 5

    public void imperative() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = 0;
        for (int n : numbers) {
            if (n % 2 == 1) {
                int square = n * n;
                sum += square;
            }
        }

        System.out.println("Imperative: Sum of odd integers: " + sum);
    }

    public void functional() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

            int sum = numbers.stream()
                    .filter(x -> x % 2 == 1)
                    .map(x -> x * x)
                    .reduce(0, (x, y) -> x + y); // Method reference can be Integer::sum

        System.out.println("Functional: Sum of odd integers: " + sum);


    }

    public static void main(String... args) {
        ImperativeVsFunctional imperativeVsFunctional = new ImperativeVsFunctional();

        imperativeVsFunctional.imperative();
        System.out.println("--------------------------------------------");
        imperativeVsFunctional.functional();

    }
}
