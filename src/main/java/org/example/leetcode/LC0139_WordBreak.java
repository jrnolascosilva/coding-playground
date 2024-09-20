package org.example.leetcode;

// https://leetcode.com/problems/word-break/description/
// Time complexity: O(n^2)
// Space complexity: O(n)
// Explanation: https://youtu.be/1U4jQusbeJc?si=8Z9Z9Q9vQ7q


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LC0139_WordBreak {

    private final Map<String, Boolean> cache = new HashMap<>();
    private Set<String> wordSet;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }

        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if(wordSet == null)
        {
            wordSet = new HashSet<>(wordDict);
        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (wordSet.contains(left) && wordBreak(right, wordDict)) {
                cache.put(s, true);
                return true;
            }
        }

        cache.put(s, false);

        return false;
    }

    public static void main(String[] args) {
        LC0139_WordBreak wordBreak = new LC0139_WordBreak();
        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code"))); // true
        System.out.println(wordBreak.wordBreak("applepenapple", List.of("apple", "pen"))); // true
        System.out.println(wordBreak.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false
    }
}
