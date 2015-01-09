package com.manvendrask.streamoperations;

import com.manvendrask.core.Programmer;

import java.util.List;

/**
 * @author Manvendra SK
 */
public class IteratingStreams {

    void normalIteration() {

        Programmer.programmers()
                .stream()
                .filter(Programmer::isFemale)
                .forEach(System.out::println);

    }

    void operativeIteration() {

        List<Programmer> programmers = Programmer.programmers();

        System.out.println("Before custom operation on the list...\n" + programmers);

        // Increase female programmers' income by 10% ... Women oriented program.. :-P

        programmers.stream()
                .filter(Programmer::isFemale)
                .forEach(x -> x.setIncome(x.getIncome() * 1.10));

        System.out.println("\n\nAfter custom operation on the list...\n" + programmers);

    }

    public static void main(String... args) {

        IteratingStreams iteratingStreams = new IteratingStreams();
        iteratingStreams.normalIteration();

        System.out.println("--------------------------------------------");

        iteratingStreams.operativeIteration();
    }
}
