package cloud.jnolasco.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/description/
// Explicacion 1: https://youtu.be/44H3cEC2fFM?si=rVhZPtm8QvWqKj80
// Explicacion 2: https://youtu.be/dzNIPX7HY6A?si=s5wAvrKnqdxrx0SP
// Time: O(n log n)  // Sorting the intervals
// Space: O(n)

public class LC0056_MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Sort the intervals based on the start
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> output = new ArrayList<>();

        // Initialize the output with the first interval in order to compare with the rest
        output.add(intervals[0]);

        for(int[] curr : intervals)
        {
            // If the start of the current interval is less-equal than the end of the last interval (overlap) then
            if(curr[0] <= output.getLast()[1])
            {
                // Merge the intervals taking care of edge case with max function {{1,5},{2,4}} -> {{1,5}}
                output.getLast()[1] = Math.max(curr[1], output.getLast()[1]);
            }
            else
                output.add(curr);  // No overlap, add the current interval to the output
        }

        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,5},{2,4}};

        String output = Arrays.deepToString(merge(intervals1));
        System.out.println(output);

        String output2 = Arrays.deepToString(merge(intervals2));
        System.out.println(output2);
    }
}
