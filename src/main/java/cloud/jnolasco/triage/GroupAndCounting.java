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

    /**
     * iterates through a given string to classify each character as either a vowel or a consonant.
     */
    public static Map<String, Long> countConsonantAndVowels(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        var map = new HashMap<String, Long>();

        for (Character c : input.toCharArray()) {
            boolean isVowel = "aeiou".contains(c.toString());
            if (isVowel)
                map.merge("Vowel", 1L, Long::sum);
            else
                map.merge("Consonant", 1L, Long::sum);
        }

        return map;
    }

    /**
     * iterates through a given string to classify each character as either a vowel or a consonant with Streams
     */
    public static Map<String, Long> countConsonantAndVowelsWithStreams(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }

        Map<String, Long> collected = input.chars().mapToObj(c -> (char) c)
                .filter(Character::isLetter)
                .collect(Collectors.groupingBy(
                        c -> "aeiou".contains(c.toString()) ? "Vowel" : "Consonant",
                        Collectors.counting()
                ));
        return collected;
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

        String input2 = "abcde";
        System.out.println("-> Counting %s with countConsonantAndVowels".formatted(input2));
        var map5 = countConsonantAndVowels(input2);
        map5.entrySet().stream()
                .forEach(System.out::println);

        System.out.println("-> Counting %s with countConsonantAndVowels with Stream".formatted(input2));
        var map6 = countConsonantAndVowelsWithStreams(input2);
        map6.entrySet().stream()
                .forEach(System.out::println);
    }
}
