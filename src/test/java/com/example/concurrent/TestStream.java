package com.example.concurrent;

import com.example.concurrent.entity.Employee;
import com.example.concurrent.entity.Employee.Status;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
public class TestStream {

    List<Employee> employees = Arrays.asList(
            new Employee(11,"I001","王五",29, Status.BBB),
            new Employee(22,"I002","李四",35, Status.AAA),
            new Employee(33,"I003","张三",22, Status.DDD),
            new Employee(44,"I004","赵六",28, Status.AAA),
            new Employee(55,"I005","吴二",26, Status.CCC),
            new Employee(66,"I006","刘大",36, Status.CCC),
            new Employee(77,"I007","田七",36, Status.BBB));


    @Test
    public void test3 () {

    }

    @Test
    public void test2 () {
        Integer[] nums = {1,2,3,4,5};
        Arrays.stream(nums).map(x -> x*x).forEach(System.out :: println);
    }

    @Test
    public void test1 () {
        Stream<Integer> stream = Stream.iterate(0, x -> x + 1 );
        stream.limit(10).forEach(System.out :: println);
    }
}
