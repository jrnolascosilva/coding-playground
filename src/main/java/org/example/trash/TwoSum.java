package org.example.trash;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();

        for(int i = 0; i < nums.length; i++)
        {
            int diff = target - nums[i];
            if(complements.containsKey(diff))
                return new int[] {complements.get(diff), i};
            else
                complements.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        TwoSum app = new TwoSum();
        int[] output = app.twoSum(nums, 9);

        System.out.println(Arrays.toString(output));
    }
}
