package Homework.Builder.Homework;

import java.util.Scanner;

public class PersonBuilder implements Builder{
    private String firstName;
    private String lastName;
    private int year;

     @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public Person createPerson() {
        return new Person(firstName, lastName, year);
    }
}
