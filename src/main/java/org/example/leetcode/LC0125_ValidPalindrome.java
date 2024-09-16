package org.example.leetcode;

// https://leetcode.com/problems/valid-palindrome/
// Expĺanation: https://youtu.be/ANmSVWeOsUA?si=FoQviYqgpPy0y7tv
// Time complexity O(n)
// Space complexity O(1)


public class LC0125_ValidPalindrome {

    /*
        This Java method checks if a given string s is a palindrome. It does this by:

        Removing non-alphanumeric characters and converting to lowercase.
        Comparing characters from the start and end of the string, moving towards the center.
        Returning false if any pair of characters don't match, and true if all pairs match.
        In other words, it checks if the string reads the same forwards and backwards, ignoring spaces, punctuation, and case.

     */
    public static boolean isPalindrome(String s) {
        // Alphanumeric characters include letters and numbers. space not considered alphanumeric
        String normalized = s.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();    // <-- notice regex

        int start = 0;
        int end = normalized.length() - 1;

        while(start < end)
        {
            if(normalized.charAt(start) != normalized.charAt(end))
                return false;
            start++;
            end--;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
