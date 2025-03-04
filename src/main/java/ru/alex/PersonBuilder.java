package ru.alex;

public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст недопустимый!");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = null;
        if (name != null && surname != null && age != null) {
            person = new Person(name, surname, age);
        } else if (name != null && surname != null) {
            person = new Person(name, surname);
        }
        if (address != null) {
            person.setAddress(address);
        }
        if (name == null || surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей!");
        }
        return person;
    }
}