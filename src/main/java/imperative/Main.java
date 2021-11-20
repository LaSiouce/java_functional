package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static imperative.Gender.*;

public class Main {
    public static void main(String[] args) {

        // Create people
        List<Person> people = List.of(
                new Person("Fiona", FEMALE),
                new Person("Julie", FEMALE),
                new Person("Toto", MALE),
                new Person("Clara", FEMALE),
                new Person("Lebg", MALE),
                new Person("Zer", MALE)
        );

        System.out.println("// Imperative approach");
        // Imperative approach with loop
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        // Print list
        for (Person person : females) {
            System.out.println(person);
        }


        System.out.println("// Declarative approach");
        // Declarative approach with Predicate ...
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        // ... and Collector
        Collector<Person, ?, List<Person>> personListCollector = Collectors.toList();
        // Clear list
        females.clear();
        // Feel it with the other method
        females = people.stream()
                .filter(personPredicate)
                .collect(personListCollector);
        // Print list
        females.forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

}

enum Gender {
    MALE, FEMALE
}
