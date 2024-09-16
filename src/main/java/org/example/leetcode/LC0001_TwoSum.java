package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


// Explanation: https://youtu.be/KLlXCFG5TnA?si=fFXBZ_FwIZCRK1s1
// Time Complexity: O(N)
// Space Complexity: O(N)

public class LC0001_TwoSum {

    private static final int[] _NUMS = {2, 7, 11, 15};

    public static int[] twoSum(int[] nums, int target) {
        /* Key = complement of current number, Value = index of current number
             i.e. with complements = { 2: 0, 7: 1, 11: 2, 15: 3 } and target = 9, then output = [0, 1]
         */
        Map<Integer, Integer> complements = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;   // calc complement
            Integer found = complements.get(diff);
            if (found == null)
                complements.put(curr, i);
            else
                return new int[]{found, i};
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] twoSum = twoSum(_NUMS, 9);
        System.out.println(String.join("", Arrays.toString(twoSum)));
    }
}
