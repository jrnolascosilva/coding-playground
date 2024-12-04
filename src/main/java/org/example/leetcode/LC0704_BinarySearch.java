package org.example.leetcode;

/**
 * LC0704_BinarySearch
 * https://leetcode.com/problems/binary-search/
 */
public class LC0704_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(target < nums[mid])
                right = mid - 1;
            else if(target > nums[mid])
                left = mid +1;
            else
                return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        LC0704_BinarySearch app = new LC0704_BinarySearch();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target1 = 9;
        int target2 = 2;
        System.out.println(app.search(nums, target1));
        System.out.println(app.search(nums, target2));
    }
}
