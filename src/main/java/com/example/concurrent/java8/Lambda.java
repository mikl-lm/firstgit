package com.example.concurrent.java8;

import com.example.concurrent.entity.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(11,"I001","张三",22),
            new Employee(22,"I002","李四",32),
            new Employee(33,"I003","王五",42),
            new Employee(44,"I004","赵六",52));


        List<Employee> selectList = filtEmployee(employees, (e) -> e.getAge() > 30);
        selectList.forEach(System.out :: println);
        System.out.println();
        employees.stream().filter(e -> e.getAge() > 50).forEach(System.out :: println);
        System.out.println();
        employees.stream().map(e -> e.getName()).forEach(System.out :: println);
    }

    public static List<Employee> filtEmployee (List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> employees = new ArrayList<>();
        for (Employee e: list) {
            if (mp.test(e)) {
                employees.add(e);
            }
        }
        return employees;
    }
}
