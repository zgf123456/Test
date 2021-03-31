package com.zgf.Test.java8.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgf
 * @date 2021-03-30 下午4:55
 */
public class TestMaxPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 20, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 22, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 30, "female", "New York"));
        personList.add(new Person("Owen", 9500, 35, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 40, "female", "New York"));

//        personList.stream().max(Comparator.comparing((p1, p2) -> {p1.getSalary() > p2.get}))
    }
}
