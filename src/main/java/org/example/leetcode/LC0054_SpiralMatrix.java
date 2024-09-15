package org.example.leetcode;

// https://leetcode.com/problems/spiral-matrix/description/
// Explanation 1: https://youtu.be/aqVW8IuXUF0?si=kGGFD553PKbmq86q
// Explanation 2: https://youtu.be/1ZGJzvkcLsA?si=C6l3Sq-fvN5ixURj
// Time complexity O(m * n) -> matrix size
// Space complexity O(1). -> no extra space used

import java.util.ArrayList;
import java.util.List;

public class LC0054_SpiralMatrix {

    private static final int[][] MATRIX = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };

    /*
    * Approach: Visualize the matrix as a series of concentric rectangular layers or rectangles.
    *
    * The purpose of the spiralOrder method is to traverse the matrix in a spiral order and collect the elements in a
    * list. The method uses a cyclic counter (dir) to determine the direction of traversal.
    *
    * - The spiralOrder method initializes an empty list called result to store the elements.
    * - It initializes variables top, bottom, left, and right to keep track of the boundaries of the matrix.
    * - It also initializes a variable dir to keep track of the direction of traversal.
    * - The method enters a while loop that continues as long as the top is less than or equal to bottom and the left is
    *   less than or equal to right.
    * - Inside the loop, it checks the value of dir and performs the corresponding traversal.
    * - For each direction, it uses nested loops to iterate over the elements in that direction and adds them to the
    *   result list.
    * - After traversing in a particular direction, it updates the boundaries (top, bottom, left, right) to move towards
    *   the center of the matrix.
    * - The dir variable is incremented and wrapped around using the modulo operator to ensure it stays within the range
    *   of 0 to 3.
    * - Finally, the method returns the result list.
    */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;     // -1 to avoid out of bounds
        int left = 0;
        int right = matrix[0].length - 1;   // -1 to avoid out of bounds
        int dir = 0;  // 0 = right, 1 = down, 2 = left, 3 = up

        while (top <= bottom && left <= right) {
            if (dir == 0)
            {
                // traverse right
                for(int curr = left; curr <= right; curr++)
                    result.add(matrix[top][curr]);
                top ++;  // reduce upper bound
            }

            if (dir == 1)
            {
                // traverse down
                for(int curr = top; curr <= bottom; curr++)
                    result.add(matrix[curr][right]);
                right--;  // reduce upper bound
            }

            if (dir == 2)
            {
                // traverse left
                for(int curr = right; curr >= left; curr--)
                    result.add(matrix[bottom][curr]);
                bottom--;  // reduce upper bound
            }

            if (dir == 3)
            {
                // traverse up
                for(int curr = bottom; curr >= top; curr--)
                    result.add(matrix[curr][left]);
                left++;  // reduce upper bound
            }

            dir = (dir + 1) % 4;  // his is a common way to implement a cyclic counter, ensuring that the value of dir always stays within the range of 0 to 3.
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = spiralOrder(MATRIX);

        System.out.println(result);
    }
}
