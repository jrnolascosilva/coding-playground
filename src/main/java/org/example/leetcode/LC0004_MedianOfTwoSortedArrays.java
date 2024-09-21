package org.example.leetcode;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
// Explanation 1: https://youtu.be/LPFhl65R7ww?si=n5tPrdn1VOs9VWha
// Explanation 2: https://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/

// Heads Ups: Need more understanding on my side
public class LC0004_MedianOfTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     * <p>
     * Solution
     * Take minimum size of two array. Possible number of partitions are from 0 to m in m size array.
     * Try every cut in binary search way. When you cut first array at i then you cut second array at (m + n + 1)/2 - i
     * Now try to find the i where a[i-1] <= b[j] and b[j-1] <= a[i]. So this i is partition around which lies the median.
     * <p>
     * Time complexity is O(log(min(x,y))
     * Space complexity is O(1)
     * <p>
     * https://leetcode.com/problems/median-of-two-sorted-arrays/
     * https://discuss.leetcode.com/topic/4996/share-my-o-log-min-m-n-solution-with-explanation/4
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        LC0004_MedianOfTwoSortedArrays solution = new LC0004_MedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 19, 21, 18, 25}));
    }
}
