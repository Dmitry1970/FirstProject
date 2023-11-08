package Homework.Builder.BuilderLombok;

public class PersonMain {
    public static void main(String[] args) {
        Person person = Person.builder()
                .firstName("Вася")
                .lastName("Васильев")
                .year(2000)
                .address(new Address("Russia", "Moscow", "Severanaya", 15))
                .birthInfo(BirthInfo.info())
                .build();

        System.out.println(person);
    }
}
