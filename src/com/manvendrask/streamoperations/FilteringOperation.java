package com.manvendrask.streamoperations;

import com.manvendrask.core.Programmer;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author Manvendra SK
 */
public class FilteringOperation {

    void filterIntegers() {

        IntStream.rangeClosed(1, 5) // Yes there is also range() method.
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);
    }

    void filterProgrammers() {

        Function<Programmer, String> getProgrammerName = p -> p.getName();

        Predicate<Programmer> isFemaleProgrammer = p -> p.isFemale();

        Programmer.programmers()
                .stream()
                .filter(Programmer::isFemale)
                .map(Programmer::getName)
                .forEach(System.out::println);
    }

    void filterMultiProgrammers() {

        Function<Programmer, String> getProgrammerName = p -> p.getName();

        Predicate<Programmer> isMaleProgrammer = p -> p.isMale();
        Predicate<Programmer> isEarningMoreThan5000 = p -> p.getIncome() > 5000;

        Predicate<Programmer> isMaleAndEarningMoreThan5000 = p -> p.isMale() && p.getIncome() > 5000;

        Programmer.programmers()
                .stream()
//                .filter(Programmer::isMale)
//                .filter(isEarningMoreThan5000)
                .filter(isMaleAndEarningMoreThan5000) // or this
                .map(Programmer::getName)
                .forEach(System.out::println);
    }

    public static void main(String... args) {

        FilteringOperation filteringOperation = new FilteringOperation();
        filteringOperation.filterIntegers();

        System.out.println("--------------------------------------------");

        filteringOperation.filterProgrammers();

        System.out.println("--------------------------------------------");
        filteringOperation.filterMultiProgrammers();
    }
}
