package org.example.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters
// Explanation: https://youtu.be/fTIzYJvhsqg?si=2QUtcck_8Cu54czD
// Explanation: https://youtu.be/FCbOzdHKW18?si=MWSd24qFwvgcVoLP

public class LC0003_LongestSubstringWithoutRepeatingCharacters {

    /*
        Here is the algorithm

        1. Initialize `maxLength` to 0.
        2. Create a `HashSet` named `memory` to store characters.
        3. Initialize two pointers, `left` and `right`, both set to 0.
        4. Use a `while` loop to iterate through the string `s` until `right` is less than the length of `s`:
            - If the character at the `right` pointer is not in `memory`:
                - Add the character to `memory`.
                - Increment the `right` pointer.
                - Update `maxLength` to be the maximum of `maxLength` and the difference between `right` and `left`.
            - Else:
                - Remove the character at the `left` pointer from `memory`.
                - Increment the `left` pointer.
        5. Return `maxLength`.

     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        Set<Character> memory = new HashSet<>();
        int left = 0;
        int right = 0;

        // left and right are two pointers which are used to traverse the string
        // when the character at the right pointer is not in the memory increment the right pointer
        // when the character at the right pointer is in the memory then increment the left pointer
        while (right < s.length()) {

            // if the character at the right pointer is not in the memory, add it to the memory
            // and move the right pointer to the right and increment the max length
            if (!memory.contains(s.charAt(right))) {
                memory.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left); //
            }
            else
            {
                // if the character at the right pointer is in the memory, then the current windows is not valid
                // so remove from memory the character at the LEFT pointer and move the left pointer to the right
                // in order to find a new valid window
                memory.remove(s.charAt(left)); // remove the character at the left pointer
                left++;
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {
        LC0003_LongestSubstringWithoutRepeatingCharacters solution = new LC0003_LongestSubstringWithoutRepeatingCharacters();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }
}
