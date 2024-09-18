package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/group-anagrams/
// Explanation: Check for an Anagrams methods: https://youtu.be/QZmh8-Auqo8?si=6vzGso7HLnOwZCoT
// Explanation: CategorizeByOrder, CategorizeByFrecuency
// Time Complexity = O(n log k) where k = max string length because of sorting, and n = number of strings
//
public class LC0049_GroupAnagrams {

    public static List<List<String>> groupAnagramsByOrder(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        Arrays.stream(strs).forEach(s1 -> {
            String s1Sorted = sort(s1);

            List<String> list = map.getOrDefault(s1Sorted, new ArrayList<>());
            list.add(s1);
            map.put(s1Sorted, list);

        });
        return map.values().stream().toList();
    }

    public static String sort(String word) {
        char[] s11 = word.toCharArray();
        Arrays.sort(s11);
        return new String(s11);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramsByOrder(strs));
    }
}
