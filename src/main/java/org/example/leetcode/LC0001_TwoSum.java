package org.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
// Explanation: https://youtu.be/KLlXCFG5TnA?si=fFXBZ_FwIZCRK1s1
// Time Complexity: O(N)
// Space Complexity: O(N)

public class LC0001_TwoSum {

    private static final int[] _NUMS = {2, 7, 11, 15};

    /*
        Find two numbers in the nums array that add up to the target value.

        The code first calculates the complement of the current number (curr) by subtracting it from the target. It
        then checks if the complement exists in the complements map.

        If it does not exist, the current number and its index are added to the complements map.

        If the complement exists, it means that a pair of numbers that add up to the target has been found, and the
        method returns an array containing the indices of those numbers.
     */

    public static int[] twoSum(int[] nums, int target) {
        /*
        /* Key = complement of current number, Value = index of current number
             i.e. with complements = { 2: 0, 7: 1, 11: 2, 15: 3 } and target = 9, then output = [0, 1]
         */

        Map<Integer, Integer> complementsMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(complementsMap.containsKey(diff))
                // return the index of the current number and the index of the number that adds up to the target
                return new int[] { i, complementsMap.get(diff)};
            else
                complementsMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] twoSum = twoSum(_NUMS, 9);
        System.out.println(String.join("", Arrays.toString(twoSum)));
    }
}
