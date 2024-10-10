package org.example;

import classes.Employee;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void taskThreeMain() {
        var salaryBound = 100000.00;
        ArrayList<Employee> employees = initializeEmployees();

        List<Employee> richEmployees = employees.stream()
                .filter(e -> e.getSalary() > salaryBound)
                .toList();

        System.out.printf("Employees with salary > %s:%n", salaryBound);
        richEmployees.forEach(e ->
                System.out.println(e.getFullName() + " --- " + e.getSalary()));

    }

    public static ArrayList<Employee> initializeEmployees() {
        // Data could be read from file, or a DB, or autogenerated --- that was the easiest way
        ArrayList<Employee> employees = new ArrayList<>(5);
        employees.add(new Employee("Natalie Saler", 21, "QA", 100.00));
        employees.add(new Employee("Liz Kovtun", 28, "DevOps", 130000.00));
        employees.add(new Employee("John Snow", 40, "Design", 110000.00));
        employees.add(new Employee("Jane Smith", 56, "Interdimensional Travel", 8500000.88));
        employees.add(new Employee("Richard Nate", 33, "Marketing", 9999999.99));
        return employees;
    }
}

