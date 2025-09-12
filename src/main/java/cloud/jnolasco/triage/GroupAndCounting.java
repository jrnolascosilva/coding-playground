package cloud.jnolasco.triage;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class GroupAndCounting {

    /**
     * t takes a String as input and returns a Map where each key is a character from the string and its corresponding value is the number of times that character appeared.
     */
    public static Map<Character, Integer> groupAndCountCharacters(String text) {
        if (text == null || text.isEmpty())
            return Collections.emptyMap();

        var map = new HashMap<Character, Integer>();

        Stream<Character> charStream = text.chars().mapToObj(c -> (char) c);

        charStream.forEach(c -> map.merge(c, 1, Integer::sum));

        return map;
    }

    /**
     * t takes a String as input and returns a Map where each key is a character from the string and is corresponding value is the number of times that character appeared
     * with Java Streams API
     */
    public static Map<Character, Long> groupAndCountCharactersWithStreamAPI(String text) {
        if (text == null || text.isEmpty())
            return Collections.emptyMap();

        return text.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    private record Contact(String name, String city) {
    }
    /**
     * It counts how many contacts belong to each city and returns a Map where the keys are city names and the values are their respective counts
     */
    public static Map<String, Integer> groupAndCountPojos(Collection<Contact> contacts) {
        var map = new HashMap<String, Integer>();
        contacts.forEach(c -> map.merge(c.city, 1, Integer::sum));

        return map;
    }

    /**
     * It counts how many contacts belong to each city and returns a Map where the keys are city names and the values are their respective counts
     * with Stream API
     */
    public static Map<String, Long> groupAndCountPojosWithStreamAPI(Collection<Contact> contacts) {
        return contacts.stream()
                .collect(Collectors.groupingBy(c -> c.city, Collectors.counting()));
    }

    public static void main(String[] args) {
        String input = "aaaabbbcdeff";

        System.out.println("-> Counting characters with map.merge()");
        var map = groupAndCountCharacters(input);

        map.entrySet().stream()
                .forEach(System.out::println);

        var contacts = List.of(
                new Contact("Juan", "Progreso"),
                new Contact("Alfred", "Merida"),
                new Contact("Christian", "Merida"),
                new Contact("Raul", "Guadalajara"));

        System.out.println("-> Counting contacts by city with map.merge()");
        var map2 = groupAndCountPojos(contacts);
        map2.entrySet().stream()
                .forEach(System.out::println);

        System.out.println("-> Counting characters with Collectors.groupingBy");
        var map3 = groupAndCountCharactersWithStreamAPI(input);
        map3.entrySet().stream()
                .forEach(System.out::println);

        System.out.println("-> Counting contacts by city with Collectors.groupingBy");
        var map4 = groupAndCountPojosWithStreamAPI(contacts);
        map4.entrySet().stream()
                .forEach(System.out::println);
    }

}
