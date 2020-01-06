package com.example.concurrent;

import com.example.concurrent.entity.Employee;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;
@SpringBootTest
public class TestLambda {

    List<Employee> employees = Arrays.asList(
            new Employee(11,"I001","王五",22),
            new Employee(22,"I002","李四",35),
            new Employee(33,"I003","张三",22),
            new Employee(44,"I004","赵六",28),
            new Employee(55,"I004","吴二",26));

    @Test
    public void functionT () {
        String[] s = functionI("qweaczfa", (str) -> str.toString());
        for (int i = 0; i < s.length; i++) {
            System.out.println("------------------ " + s[i]);
        }
        Map map = new HashMap();
    }
    public String[] functionI (String s, Function<Object, String> f) {
        String[] ss = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ss[i] = f.apply(s.charAt(i));
        }
        return ss;
    }

    @Test
    public void supplierT () {
        List list = supplierI(10, () -> (int)(Math.random() * 100));
        list.forEach(System.out :: println);
        // System.out.println();
        // System.out.println((int)(Math.random() * 100));
        list.parallelStream();
    }

    public List supplierI (int n, Supplier<Integer> s) {
        List list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer val = s.get();
            list.add(val);
        }
        return list;
    }


    @Test
    public void consumerT () {
        consumerI(100.22, m -> System.out.println("l;kjas;dakd;a" + m));
    }
    public void consumerI (Double money, Consumer<Double> m) {
        m.accept(money);
    }


    @Test
    public void test1() {
        Collections.sort(employees, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return  e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        });

        employees.forEach(System.out :: println);
    }
}
