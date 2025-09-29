package cloud.jnolasco.interviews;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * AEO
 */
public class ProductReviewsAnalyzer {

    /**
     * Let's say we have e-commerce website where customers submit reviews for products,
     * and we would like to track customer behavior.
     * So, we record all the reviews submitted by customers by generating a log file at the end of each day,
     * where the file has customerId, ProductId, Timestamp, ReviewDetail.
     * Now, given two files from day1 & day2,
     * find the list of customers who have submitted reviews on both days & at least on 2 different products.
     **/

    public static class ProductReview {
        private Integer customerId;
        private String productId;
        private Duration timeStamp;
        private String reviewDetail; // abstract away


        // added for compilation sake
        public ProductReview(Integer customerId, String productId, Duration timeStamp, String reviewDetail) {
            this.customerId = customerId;
            this.productId = productId;
            this.timeStamp = timeStamp;
            this.reviewDetail = reviewDetail;
        }

        // added for compilation sake
        public Integer getCustomerId() { return customerId; }
        public String getProductId() { return productId; }
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
                new ProductReview(5, "productT", Duration.ofHours(29), "Worth it.") // Customer E only reviews on day 2
        );

        // --- Print Input Data ---
        System.out.println("--- Day 1 Reviews ---");
        day1Reviews.forEach(System.out::println);
        System.out.println("\n--- Day 2 Reviews ---");
        day2Reviews.forEach(System.out::println);

        // --- Execute the Method ---
        List<Integer> qualifyingReviews = analyzeImproved(day1Reviews, day2Reviews);

        // --- Print Results ---
        System.out.println("\n--- Qualifying Customers' Reviews ---");
        if (qualifyingReviews.isEmpty()) {
            System.out.println("No customers met the criteria.");
        } else {
            qualifyingReviews.forEach(System.out::println);
        }

       // --- Qualifying Customers' Reviews ---
       // 1
       // 2
    }



    public static List<Integer> analyzeImproved(Iterable<ProductReview> day1, Iterable<ProductReview> day2) {
        Stream<ProductReview> day1Stream = StreamSupport.stream(day1.spliterator(), false);
        Stream<ProductReview> day2Stream = StreamSupport.stream(day2.spliterator(), false);

        Map<Integer, Set<String>> reviewsByCustomerDay1 = groupByCustomer(day1Stream);
        Map<Integer, Set<String>> reviewsByCustomerDay2 = groupByCustomer(day2Stream);

        return reviewsByCustomerDay1.keySet().stream().
                filter(reviewsByCustomerDay2::containsKey).
                filter(r -> haveAtLeastNDifferentProducts(reviewsByCustomerDay1.get(r), reviewsByCustomerDay2.get(r), 2)).
                distinct().
                collect(Collectors.toList());
    }

    public static boolean haveAtLeastNDifferentProducts(Set<String> reviewsByCustomerDay1, Set<String> reviewsByCustomerDay2, int n) {
        HashSet<String> tmp = new HashSet<>(reviewsByCustomerDay1);
        tmp.addAll(reviewsByCustomerDay2);

        return tmp.size() >= n;
    }

    public static Map<Integer, Set<String>> groupByCustomer(Stream<ProductReview> dayStream) {
        return dayStream.collect(
                Collectors.groupingBy(
                        ProductReview::getCustomerId,
                        Collectors.mapping(ProductReview::getProductId, Collectors.toSet())
                ));
    }
}
