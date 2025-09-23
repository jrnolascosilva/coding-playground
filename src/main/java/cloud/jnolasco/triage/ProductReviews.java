package cloud.jnolasco.triage;

import java.time.Duration;
import java.util.*;


import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ProductReviews {

    public record ProductReview(Integer customerId, String productId, Duration timestamp, String ReviewDetail) {
    }

    ;

    /**
     * Let's say we have e-commerce website where customers submit reviews for products,
     * and we would like to track customer behavior.
     * So, we record all the reviews submitted by customers by generating a log file at the end of each day,
     * where the file has customerId, ProductId, Timestamp, ReviewDetail.
     * Now, given two files from day1 & day2,
     * find the list of customers who have submitted reviews on both days & at least on 2 different products.
     **/
    public static List<Integer> analyze(Iterable<ProductReview> day1, Iterable<ProductReview> day2) {

        Stream<ProductReview> listDay1 = StreamSupport.stream(day1.spliterator(), false);

        Stream<ProductReview> listDay2 = StreamSupport.stream(day2.spliterator(), false);

        Map<Integer, Set<String>> day1Map = listDay1.collect(
                Collectors.groupingBy(ProductReview::customerId, Collectors.mapping(ProductReview::productId, Collectors.toSet()))
        );

        Map<Integer, Set<String>> day2Map = listDay2.collect(
                Collectors.groupingBy(ProductReview::customerId, Collectors.mapping(ProductReview::productId, Collectors.toSet()))
        );

        Set<Integer> compliantCustomers = day1Map.keySet().stream().
                filter(day2Map::containsKey).
                filter(customer -> {
                    HashSet<String> tmp = new HashSet<>(day1Map.get(customer));
                    tmp.addAll(day2Map.get(customer));
                    return tmp.size() >= 2;
                })
                .collect(Collectors.toSet());

        return compliantCustomers.stream().toList();

    }

    public static void main(String[] args) {
// --- Test Data Setup ---
        // Sample Reviews for Day 1
        List<ProductReview> day1Reviews = List.of(
                new ProductReview(1, "productX", Duration.ofHours(1), "Great product!"),
                new ProductReview(2, "productP", Duration.ofHours(3), "Good value."),
                new ProductReview(3, "productR", Duration.ofHours(4), "Okay."),
                new ProductReview(4, "productS", Duration.ofHours(5), "Nice.") // Customer D only reviews on day 1
        );

        // Sample Reviews for Day 2
        List<ProductReview> day2Reviews = List.of(
                new ProductReview(1, "productY", Duration.ofHours(25), "New favorite."),
                new ProductReview(2, "productQ", Duration.ofHours(27), "Better than expected."),
                new ProductReview(3, "productR", Duration.ofHours(28), "Still okay."), // Customer C reviews same product
                new ProductReview(4, "productT", Duration.ofHours(29), "Worth it.") // Customer E only reviews on day 2
        );

        // --- Print Input Data ---
        System.out.println("--- Day 1 Reviews ---");
        day1Reviews.forEach(System.out::println);
        System.out.println("\n--- Day 2 Reviews ---");
        day2Reviews.forEach(System.out::println);

        // --- Execute the Method ---
        List<Integer> qualifyingReviews = analyze(day1Reviews, day2Reviews);

        // --- Print Results ---
        System.out.println("\n--- Qualifying Customers' Reviews ---");
        if (qualifyingReviews.isEmpty()) {
            System.out.println("No customers met the criteria.");
        } else {
            qualifyingReviews.forEach(System.out::println);
        }

        // Expected Output Analysis:
        // - Customer A: Reviewed productX (day1) and productY (day2).
        //   - On both days: Yes.
        //   - Distinct products: {X, Y} -> 2 products. Qualifies.
        // - Customer B: Reviewed productP (day1) and productQ (day2).
        //   - On both days: Yes.
        //   - Distinct products: {P, Q} -> 2 products. Qualifies.
        // - Customer C: Reviewed productR (day1) and productR (day2).
        //   - On both days: Yes.
        //   - Distinct products: {R} -> 1 product. Does NOT qualify.
        // - Customer D: Only reviewed on day 1. Does NOT qualify.
        // - Customer E: Only reviewed on day 2. Does NOT qualify.
        //
        // The output should contain all reviews from customerA and customerB.
    }
}
