package Homework.Builder.BuilderLombok;
/*
@Value – это неизменяемый вариант @Data. С этой аннотацией Lombok по умолчанию делает все поля private и final.
 Кроме того, сеттеры не генерируются, а класс как таковой помечается final. Таким образом, от этого класса нельзя
  наследовать. Точно как и в случае с @Data, создаются реализации toString(), equals() и hashCode().
 */


import lombok.Value;

import java.time.LocalDate;
import java.time.LocalTime;

@Value
public final class BirthInfo {

    LocalDate birthday;
    LocalTime birthtime;
    String birthplace;
    Double weight;
    Double height;

    public static BirthInfo info() {
        return new BirthInfo(LocalDate.of(2000, 8, 11), LocalTime.of(12, 15), "New York", 3.5, 54.5);
    }

}
