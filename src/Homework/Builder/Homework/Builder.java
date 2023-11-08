package Homework.Builder.Homework;

public interface Builder {

    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setYear(int year);
    Person createPerson();
}
