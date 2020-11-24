package team.jit.workshop;

import org.junit.jupiter.api.Test;

import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {

    private List<Person> persons = List.of(
            new Person(1L, "Piotr", "Kowalski"),
            new Person(2L, "Andrzej", "Kowalski"),
            new Person(3L, "Łukasz", "Kowalski")
    );

    @Test
    public void testCreateStream1() {
        List<String> names = List.of("Piotr", "Andrzej", "Łukasz");

        Stream<String> stream = names.stream();
    }

    @Test
    public void testCreateStream2() {
        String [] names = new String[]{"Piotr", "Andrzej", "Łukasz"};

        Stream<String> stream = Arrays.stream(names);
    }

    @Test
    public void testCreateStream3() {
        Stream<String> stream = Stream.of("Piotr", "Andrzej", "Łukasz");
    }

    @Test
    public void testTerminalOperationStream1() {
        Stream<String> stream = Stream.of("Piotr", "Andrzej", "Łukasz");

        long count = stream.count();

        System.out.println(count);
    }

    @Test
    public void testForEach() {
        Stream<String> stream = Stream.of("Piotr", "Andrzej", "Łukasz");

        stream.forEach(System.out::println);
    }

    @Test
    public void testAnyMatchOld() {
        boolean found = isPersonWithNameExists(persons,"Piotr");
    }

    private boolean isPersonWithNameExists(List<Person> persons, String name) {
        for (Person person : persons) {
            if (person.getName().startsWith(name)) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void testAnyMatch() {
        boolean found = persons.stream().anyMatch(person -> person.getName().startsWith("Piotr"));
    }

    public void testFindOld() {
        Optional<Person> optionalPerson = findPersonByName(persons, "Piotr");
    }

    private Optional<Person> findPersonByName(List<Person> persons, String name) {
        for (Person person : persons) {
            if (person.getName().startsWith(name)) {
                return Optional.of(person);
            }
        }

        return Optional.empty();
    }

    @Test
    public void testFind() {
        Person result = persons.stream().filter(person -> person.getName().startsWith("Piotr")).findFirst().get();
    }

    @Test
    public void testMap() {
        Set<Long> keys = persons.stream().map(person -> person.getKey()).collect(Collectors.toSet());

        for (Long key : keys) {
            System.out.println(key);
        }
    }

    @Test
    public void testIntStream() {
        IntStream.range(1, 40).forEach(System.out::println);
        IntStream.range(1, 40).mapToObj(i -> "String" + i).forEach(System.out::println);
    }

}
