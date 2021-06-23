package com.booknara.practice.oop;

import java.util.Objects;

public class Person {
    private String name;
    private String city;
    private String phone;

    public Person(String name, String city, String phone) {
        this.name = name;
        this.city = city;
        this.phone = phone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(city, person.city) &&
                Objects.equals(phone, person.phone);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, city, phone);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
