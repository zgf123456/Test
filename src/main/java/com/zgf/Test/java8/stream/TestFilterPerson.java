package com.zgf.Test.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zgf
 * @date 2021-03-30 下午4:45
 */
public class TestFilterPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 20, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 22, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 30, "female", "New York"));
        personList.add(new Person("Owen", 9500, 35, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 40, "female", "New York"));


        // 筛选员工中工资高于8000的人，并形成新的集合
        List<String> collect = personList.stream()
                .filter(p -> p.getSalary() > 8000)
                .map(p -> p.getName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect);
    }
}
