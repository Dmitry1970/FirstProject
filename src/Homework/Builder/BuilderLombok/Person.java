package Homework.Builder.BuilderLombok;

/*
@Data – это сокращенная аннотация, сочетающая возможности:
 @ToString,
 @EqualsAndHashCode,
 @Getter,
 @Setter,
@RequiredArgsConstructor.
 Это, в частности, дает нам геттеры для всех полей, сеттеры для всех нефинальных полей, правильные реализации toString,
 equals и hashCode, охватывающие все поля класса, а также конструктор для всех финальных полей.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {

    private String firstName;
    private String lastName;
    private int year;
    private Address address;
    private BirthInfo birthInfo;
}
