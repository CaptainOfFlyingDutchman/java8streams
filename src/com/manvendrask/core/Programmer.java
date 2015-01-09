package com.manvendrask.core;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

/**
 * @author Manvendra SK
 */
public class Programmer {

    public static enum Gender {MALE, FEMALE}

    private long id;
    private String name;
    private Gender gender;
    private LocalDate dob;
    private double income;

    public Programmer(long id, String name, Gender gender, LocalDate dob, double income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.income = income;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public boolean isFemale() {
        return this.gender == Gender.FEMALE;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s, %.2f)", id, name, gender, dob, income);
    }

    public static List<Programmer> programmers() {
        Programmer ken = new Programmer(1, "Ken", Gender.MALE, LocalDate.of(1943, Month.FEBRUARY, 4), 6000.0);
        Programmer linus = new Programmer(2, "Linus", Gender.MALE, LocalDate.of(1969, Month.DECEMBER, 28), 7100.0);
        Programmer ada = new Programmer(3, "Ada", Gender.FEMALE, LocalDate.of(1815, Month.DECEMBER, 10), 8700.0);
        Programmer donald = new Programmer(4, "Donald", Gender.MALE, LocalDate.of(1938, Month.JANUARY, 10), 1800.0);
        Programmer danielle = new Programmer(5, "Danielle", Gender.FEMALE, LocalDate.of(1955, Month.OCTOBER, 28), 2420.0);
        Programmer bill = new Programmer(6, "Bill", Gender.MALE, LocalDate.of(1949, Month.FEBRUARY, 19), 12400.0);
        return Arrays.asList(ken, linus, ada, donald, danielle, bill);
    }
}
