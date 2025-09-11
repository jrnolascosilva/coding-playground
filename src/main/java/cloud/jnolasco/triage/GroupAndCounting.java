package cloud.jnolasco.triage;

import java.util.*;
import java.util.stream.Stream;


public class GroupAndCounting {

    /**
     * t takes a String as input and returns a Map where each key is a character from the string and its corresponding value is the number of times that character appeared.
     */
    public static Map<Character, Integer> groupAndCountLetters(String text) {
        if (text == null || text.isEmpty())
            return Collections.emptyMap();

        var map = new HashMap<Character, Integer>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            map.merge(c, 1, Integer::sum);   //Cleaner than map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
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

    public static void main(String[] args) {
        var map = groupAndCountLetters("aaaabbbcdeff");
        map.entrySet().stream()
                .forEach(System.out::println);

        var contacts = List.of(
                new Contact("Juan", "Progreso"),
                new Contact("Alfred", "Merida"),
                new Contact("Christian", "Merida"),
                new Contact("Raul", "Guadalajara"));

        var map2 = groupAndCountPojos(contacts);
        map2.entrySet().stream()
                .forEach(System.out::println);
    }

}
