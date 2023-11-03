package com.example.StudentRegistration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        String years;
        switch (age % 10) {
            case 1 -> years = "год";
            case 2, 3, 4 -> years = (age / 10)  % 10 == 1 ? "лет" :"года";
            default -> years = "лет";
        }
        return id + ". " + firstName + " " + lastName + " " + age + " " + years;
    }
}
