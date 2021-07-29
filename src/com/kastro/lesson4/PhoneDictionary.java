package com.kastro.lesson4;
//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи,
// а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.
// Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
// взаимодействие с пользователем через консоль и т.д).
// Консоль использовать только для вывода результатов проверки телефонного справочника.

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> dictionary = new ArrayList<>();

    public void add(String surname, String phoneNumber) {
        dictionary.add(new Person(surname, phoneNumber));
    }

    public List<String> get(String surname) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Person person : dictionary ) {
            if (surname.equals(person.getSurname())) {
                phoneNumbers.add(person.getPhoneNumber());
            }
        }
        return phoneNumbers;
    }
}
