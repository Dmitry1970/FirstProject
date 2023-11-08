package Homework.Builder.Homework;

public class PersonMain {
    public static void main(String[] args) {
        Builder builder = new PersonBuilder();
        Director director = new Director();
        builder = director.createPerson(builder);
        System.out.println(builder.createPerson());
    }
}
