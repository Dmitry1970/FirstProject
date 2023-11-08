package Homework.Builder.Homework;

import java.util.Scanner;

public class Director {  // создание экземпляра Person

    public Builder createPerson(Builder builder) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        builder.setFirstName(scanner.next());
        System.out.print("Введите фамилию: ");
        builder.setLastName(scanner.next());
        System.out.print("Введите год рождения: ");
        builder.setYear(scanner.nextInt());
        return builder;
    }
}
