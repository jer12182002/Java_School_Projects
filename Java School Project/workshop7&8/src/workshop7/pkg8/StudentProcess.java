/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop7.pkg8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Optional;

/**
 *
 * @author Jason
 */
public class StudentProcess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Student[] students = {
            new Student("Jack", "Smith", 50.0, "IT"),
            new Student("Aaron", "Johnson", 76.0, "IT"),
            new Student("Maaria", "White", 35.8, "Business"), new Student("John", "White", 47.0, "Media"),
            new Student("Laney", "White", 62.0, "IT"),
            new Student("Jack", "Jones", 32.9, "Business"), new Student("Wesley", "Jones", 42.89, "Media")};

        List<Student> studentList = Arrays.asList(students);
        studentList = studentList
                .stream()
                .filter(p -> p != null)
                .collect(Collectors.toList());

        System.out.println("**********Task 1***************");
        System.out.println("Complete Student list:");
        System.out.println(studentList.toString().replace("[", "").replace("]", "").replace(", ", "").trim());

        System.out.println("\n\n**********Task 2***************");
        System.out.println("Students who got 50.0-100.0 sorted by grade");
        List<Student> studentList2 = studentList
                .stream()
                .filter(p -> p.gradeGetter() >= 50 && p.gradeGetter() <= 100)
                .collect(Collectors.toList());
        Collections.sort(studentList2, Comparator.comparingDouble(s -> s.gradeGetter()));
        //Collections.sort(studentList,Comparator.comparingDouble(Student::gradeGetter)); both work!

        System.out.println(studentList2.toString().replace("[", "").replace("]", "").replace(", ", "").trim());

        System.out.println("\n\n**********Task 3***************");
        System.out.println(studentList2.stream().findFirst().get());

        System.out.println("\n\n**********Task 4***************");
        System.out.println("Students in ascending order by last name then first:");
        studentList = studentList
                .stream()
                .sorted(Comparator.comparing(Student::lastNGetter).thenComparing(Student::firstNGetter))
                .collect(Collectors.toList());

        System.out.println(studentList.toString().replace("[", "").replace("]", "").replace(", ", "").trim());

        System.out.print("\n\n\n");
        System.out.println("Students in descending order by last name then first:");
        studentList = studentList
                .stream()
                .sorted(Comparator.comparing(Student::lastNGetter).thenComparing(Student::firstNGetter).reversed())
                .collect(Collectors.toList());
        System.out.println(studentList.toString().replace("[", "").replace("]", "").replace(", ", "").trim());

        System.out.println("\n\n**********Task 5***************");
        System.out.println("Unique Student last names:");
//        Map<String,Long> uniqueLastN= studentList
//                .stream()
//                .collect(Collectors.groupingBy(s->s.lastNGetter(),Collectors.counting()));
        //    System.out.println(uniqueLastN.getOrDefault(ar));
        List<String> collect = studentList.stream()
                .map(Student::lastNGetter)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(collect.toString().replace("[", "").replace("]", "").replace(", ", "\n").trim());

        System.out.println("\n\n**********Task 6***************");
        System.out.println("Student names in order by last name then first name:");
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::lastNGetter).thenComparing(Student::firstNGetter))
                .map(s -> s.getName())
                .forEach(System.out::println);

        System.out.println("\n\n**********Task 7***************");
        System.out.println("Students by department:");
        studentList
                .stream()
                .collect(Collectors.groupingBy(s -> s.deptGetter()))//its now Map<String, List<Student>
                .entrySet()
                .stream()
                .forEach(m -> System.out.println(m.toString().replace("=[", "\n  ").replace(", ", "  ").replace("\n]", "")));

        System.out.println("\n\n**********Task 8***************");
        studentList
                .stream()
                .sorted(Comparator.comparing(Student::deptGetter))
                .collect(Collectors.groupingBy(s -> s.deptGetter(), TreeMap::new, Collectors.counting()))
                .entrySet()
                .forEach(m -> System.out.println(m.getKey() + " has " + m.getValue() + " Student(s)"));

        System.out.println("\n\n**********Task 9***************");
        System.out.print("Sum of Students' grades: ");
        System.out.println(
                String.format("%.2f",
                        studentList
                        .stream()
                        .mapToDouble(s -> s.gradeGetter())
                        .sum()
                )
        );

        System.out.println("\n\n**********Task 10***************");
        System.out.print("Average of Students' grades: ");
        System.out.println(
                String.format("%.2f",
                        studentList
                        .stream()
                        .mapToDouble(s -> s.gradeGetter())
                        .average()
                        .getAsDouble()
                )
        );

    }

}
