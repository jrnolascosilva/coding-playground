package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Important10CodingQuestionsAnswers {

    public static void main(String[] args) {
        // 1. Find the sum of the all elements in a List using streams
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Sum = " + nums.stream().mapToInt(Integer::intValue).sum());


    }
}
