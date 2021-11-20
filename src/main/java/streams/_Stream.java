package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        // Create people
        List<Person> people = List.of(
                new Person("Fiona", FEMALE),
                new Person("Julie", FEMALE),
                new Person("Toto", MALE),
                new Person("Clara", FEMALE),
                new Person("Lebg", MALE),
                new Person("Zer", IEL),
                new Person("Zer", JPP),
                new Person("Zer", JPP)
        );

        // With gender to Set to avoid duplication
        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        // Name length with variable extraction
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        // Contains females ?
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsFemale = people.stream()
                .anyMatch(personPredicate);
        System.out.println("Contains females ? " + containsFemale);

        // Only males ?
        Predicate<Person> personPredicate2 = person -> MALE.equals(person.gender);
        boolean onlyMales = people.stream()
                .noneMatch(personPredicate2);
        System.out.println("Only males ? " + onlyMales);

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

    enum Gender {
        MALE, FEMALE, IEL, JPP
    }
}

