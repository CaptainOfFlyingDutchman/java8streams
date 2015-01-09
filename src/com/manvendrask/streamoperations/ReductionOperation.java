package com.manvendrask.streamoperations;

import com.manvendrask.core.Programmer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Manvendra SK
 */
public class ReductionOperation {

    void reducingIntegersTraditionally() {
        // Create the list of integers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Declare an accumulator called sum and initialize (or seed) it to zero
        int sum = 0;

        // Accumulate the partial results in sum
        for (int num : numbers) {
            sum = sum + num;
        }

        System.out.println(sum);
    }

    void reducingInteger() {

        int sum = IntStream.rangeClosed(1, 5)
                .reduce(0, (x, y) -> x + y); // We used previously Integer::sum. This is Static method reference.

        System.out.println(sum);
    }

    void sumProgrammersIncomeTraditionally() {

        double sum = 0.0;

        for (Programmer programmer : Programmer.programmers()) {

            // Map the Person to his income double
            double income = programmer.getIncome();

            // Accumulate the partial result in sum
            sum = sum + income;
        }

        System.out.println(sum);
    }

    void sumProgrammersIncome() {

        double sum = Programmer.programmers()
                .stream()
                .map(Programmer::getIncome)
                .reduce(0D, Double::sum);

        System.out.println("Total income is : " + sum);
    }

    void calculateMaxInteger() {
        OptionalInt max = IntStream.of(1, 5, 4, 2, 3)
                .reduce(Integer::max);

        max.ifPresent(x -> System.out.println("Max is : " + max.getAsInt()));

    }

    void calculateMaxEarningProgrammer() {
        Optional<Programmer> programmer = Programmer.programmers()
                .stream()
                .reduce((programmer1, programmer2) -> {
                    return programmer1.getIncome() > programmer2.getIncome() ? programmer1 : programmer2;
                });

        programmer.ifPresent(p -> System.out.println("Max earning programmer is : " + p.getName()));
    }

    void specializedOperations() {
        System.out.println("Sum of numbers is : " + Stream.of(1, 2, 3, 4, 5).mapToInt(x -> x).sum());
        System.out.println("Max number is : " + Stream.of(1, 2, 5, 4, 3).max(Comparator.comparingInt(x -> x)));
        System.out.println("Max number is : " + Stream.of(1, 2, 5, 4, 3).mapToInt(x -> x).max());

        System.out.println("Sum of programmers' income is : " + Programmer.programmers()
                .stream().mapToDouble(Programmer::getIncome).sum());

        System.out.println("Max earning programmer is : " + Programmer.programmers()
                .stream()
                .max(Comparator.comparingDouble(Programmer::getIncome)));
    }

    public static void main(String... args) {

        ReductionOperation reductionOperation = new ReductionOperation();
        reductionOperation.reducingInteger();

        System.out.println("--------------------------------------------");

        reductionOperation.sumProgrammersIncome();

        System.out.println("--------------------------------------------");
        reductionOperation.calculateMaxInteger();

        System.out.println("--------------------------------------------");
        reductionOperation.calculateMaxEarningProgrammer();

        System.out.println("--------------------------------------------");
        reductionOperation.specializedOperations();
    }
}
