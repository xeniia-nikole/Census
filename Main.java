package Census;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Harry", "Connor", "Nikolas",
                "Justin", "Angel", "Eve", "Elen", "Sofia", "Gabriell");
        List<String> surnames = Arrays.asList("Black", "Adamson", "Smith", "Johnson",
                "Williams", "Brown", "Garcia", "Miller", "Davis");
        Collection<Person> people = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            people.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    surnames.get(new Random().nextInt(surnames.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));

            long underage = people.parallelStream()
                    .filter(person -> person.getAge() < 18)
                    .count();
            System.out.println( ">> Underage people number: "+ underage);
            System.out.println();

            List<String> recruit = people.parallelStream()
                    .filter(person -> person.getAge() > 18 && person.getAge() < 27)
                    .map(person -> person.getSurname())
                    .collect(Collectors.toList());
            System.out.println(">> Recruit people number: " + recruit);
            System.out.println();


            List<Person> efficient = people.parallelStream()
                    .filter(person -> person.getEducation() == Education.HIGHER)
                    .filter(person -> person.getAge() > 18)
                    .filter(person -> person.getSex() == Sex.MAN && person.getAge() < 65
                    || person.getSex() == Sex.WOMAN && person.getAge() < 60)
                    .sorted(Comparator.comparing(person -> person.getSurname()))
                    .collect(Collectors.toList());
            System.out.println(">> Efficient people number: " + efficient);

        }

    }

}
