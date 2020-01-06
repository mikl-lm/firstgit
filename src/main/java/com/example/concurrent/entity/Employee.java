package com.example.concurrent.entity;

public class Employee {
    private Integer empId;
    private String empNo;
    private String name;
    private Integer age;
    private Status status;

    public Employee() {
    }

    public Employee(Integer empId, String empNo, String name, Integer age) {
        this.empId = empId;
        this.empNo = empNo;
        this.name = name;
        this.age = age;
    }

    public Employee(Integer empId, String empNo, String name, Integer age, Status status) {
        this.empId = empId;
        this.empNo = empNo;
        this.name = name;
        this.age = age;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empNo='" + empNo + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static enum Status {
        AAA,
        BBB,
        CCC,
        DDD;
    }
}
