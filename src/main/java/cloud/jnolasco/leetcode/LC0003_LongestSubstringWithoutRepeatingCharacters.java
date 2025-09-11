package cloud.jnolasco.leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters
// Explanation: https://youtu.be/fTIzYJvhsqg?si=2QUtcck_8Cu54czD
// Explanation: https://youtu.be/FCbOzdHKW18?si=MWSd24qFwvgcVoLP

public class LC0003_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        Set<Character> memory = new HashSet<>();
        int left = 0;
        int right = 0;

        // left and right are two pointers which are used to traverse the string
        // when the character at the right pointer is not in the set increment the right pointer
        // when the character at the right pointer is in the set then increment the left pointer
        while (right < s.length()) {

            // if the character at the right pointer is not in the set, add it to the set
            // and move the right pointer to the right and increment the max length
            if (!memory.contains(s.charAt(right))) {
                memory.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left); //
            }
            else
            {
                // if the character at the right pointer is in the set, then the current windows is not valid
                // so remove from "set" the character at the LEFT pointer and move the left pointer to the right
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
