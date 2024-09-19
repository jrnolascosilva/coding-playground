package org.example.leetcode;

// https://leetcode.com/problems/merge-intervals/description/

import java.util.Arrays;
import java.util.List;

public class LC0056_MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) ->  o1[0] - o2[0]);

        //List<List<Integer>>

        for(int i = 0; i < intervals.length; i++)
        {

        }
        return null;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(merge(intervals));
    }
}
