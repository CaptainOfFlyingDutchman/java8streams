package com.manvendrask.streamoperations;

import com.manvendrask.core.Programmer;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Manvendra SK
 */
public class CollectingData {

    // This method uses a Collection to hold the values. Here are 3 things required:
    // 1. Supplier -> This would return us a container to hold the results.
    // 2. Accumulator -> That accumulates the results and store into the container.
    // 3. Combiner -> That combines the partial results when stream operations performed in parallel.

    void collectProgrammers() {
//        Supplier<ArrayList<String>> supplier = () -> new ArrayList<>();
//        BiConsumer<ArrayList<String>, String> accumulator = (list, name) -> list.add(name);
//        BiConsumer<ArrayList<String>, ArrayList<String>> combiner = (list1, list2) -> list1.addAll(list2);

        Supplier<ArrayList<String>> supplier = ArrayList::new;
        BiConsumer<ArrayList<String>, String> accumulator = ArrayList::add;
        BiConsumer<ArrayList<String>, ArrayList<String>> combiner = ArrayList::addAll;

        System.out.println("Programmers : " + Programmer.programmers().
                stream()
                .map(Programmer::getName)
                .collect(supplier, accumulator, combiner));

    }

    void specializedCollectors() {
        System.out.println("Programmers List: " + Programmer.programmers().
                stream()
                .map(Programmer::getName)
                .collect(Collectors.toList()));

        System.out.println("Programmers Set: " + Programmer.programmers().
                stream()
                .map(Programmer::getName)
                .collect(Collectors.toSet()));
    }

    public static void main(String... args) {

        CollectingData collectingData = new CollectingData();
        collectingData.collectProgrammers();

        System.out.println("--------------------------------------------");

        collectingData.specializedCollectors();
    }
}
