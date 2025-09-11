package cloud.jnolasco.streams;

// https://www.geeksforgeeks.org/java-8-interview-questions-and-answers/


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GeekForGeeksJava8QandA {

    // Function to find the
    // duplicates in a Stream
    public static <T> Set<T>
    findDuplicateInStream(Stream<T> stream) {

        // Set for storing the duplicate elements
        Set<T> items = new HashSet<>();

        // Returning the set of duplicate elements
        return stream

                // Set.add() returns false
                // if the element was
                // already present in the set.
                // Hence filter such elements
                .filter(n -> !items.add(n))

                // Collect duplicate elements
                // in the set
                .collect(Collectors.toSet());
    }

    public static long count(String s, char ch)
    {
        // converting the string to an IntStream of the character codes,
        // filter by the character code of the specified character,
        // and count the occurrences
        return s.chars()
                .filter(c -> c == ch)
                .count();
    }

    // Method to get a slice of a stream from startIndex to endIndex
    public static <T> Stream<T>
    getSliceOfStream(Stream<T> stream, int startIndex,
                     int endIndex)
    {
        return stream
                // Skip elements until the startIndex
                .skip(startIndex)
                // Limit the stream to elements between startIndex and endIndex
                .limit(endIndex - startIndex + 1);
    }

    // Generic function to reverse
    // the elements of the parallel stream
    public static <T> Collector<T, ?, Stream<T> > reverseStream()
    {
        return Collectors
                .collectingAndThen(Collectors.toList(),
                        list -> {
                            Collections.reverse(list);
                            return list.stream();
                        });
    }
    public static void main(String[] args) {

        // ** Test findDuplicateInStream method
        // Initial stream
        Stream<Integer> stream
                = Stream.of(2, 17, 5,
                20, 17, 30,
                4, 23, 59, 23);

        // Print the found duplicate elements
        System.out.println(
                findDuplicateInStream(stream));

        // ** Test count method
        String str = "geeksforgeeks";
        char c = 'g';
        System.out.println(count(str, c));

        // ** Test getSliceOfStream method

        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i <= 19; i++)
            list.add(i);

        // Get a stream from the list
        Stream<Integer> intStream = list.stream();

        // Print the original list
        System.out.println("List: " + list);

        // Get a slice of the stream from index 3 to 7
        Stream<Integer>
                sliceOfIntStream = getSliceOfStream(intStream, 3, 7);

        // Print the slice of the stream
        System.out.println("\nSlice of Stream:");
        sliceOfIntStream.forEach(System.out::println);

        // ** Test reverseStream method
        // Get the parallel stream
        List<Integer> lists = Arrays.asList(217, 317, 417, 517);
        Stream<Integer> stream1 = lists.parallelStream();

        // Reverse and print the elements
        stream1.collect(reverseStream())
                .forEach(System.out::println);


        // ** Demonstration to iterate over Stream with Indices
        // Array of Strings
        String[] array = { "G", "E", "E", "k" };

        // Iterating over the indices of an array
        IntStream
                // Generate indices from 0 to array length
                .range(0, array.length)
                // Map each index to its corresponding string representation
                .mapToObj(index -> String.format("%d -> %s", index, array[index]))
                // print each and every element of the stream
                .forEach(System.out::println);
    }

}
