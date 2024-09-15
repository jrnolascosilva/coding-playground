package org.example.leetcode;

// https://leetcode.com/problems/integer-to-english-words/description/
// https://www.geeksforgeeks.org/convert-number-to-words/

import java.util.ArrayList;
import java.util.List;

public class LC0273_IntegerToEnglishWords {

    // Array to store numbers till 20 ordinal numbers
    static final String[] FIRST_TWENTY = {
            "", "One ", "Two ", "Three ",
            "Four ", "Five ", "Six ", "Seven ",
            "Eight ", "Nine ", "Ten ", "Eleven ",
            "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
            "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
    };

    // Array to store multiples of ten
    static final String[] TENS = {"", "", "Twenty", "Thirty",
            "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};

    // Array to store the powers of 10
    static final String[] MULTIPLIER = {"", "Thousand ", "Million ", "Billion ", "Trillion "};

    public static String numberToWords(long num) {
        if (num == 0)
            return "Zero";

        if (num < 20)
            return FIRST_TWENTY[(int) num];

        List<String> answer = new ArrayList<>();

        int iteration = 0;
        while (num > 0) {
            int digitGroup = (int) num % 1000;
            num /= 1000;
            answer.add(convertGroup(digitGroup) + MULTIPLIER[iteration]);
            iteration++;
        }
        return String.join("", answer.reversed());
    }

    public static String convertGroup(int number) {
        StringBuilder sb = new StringBuilder();

        // find the hundred digit, the 3rd one
        int _3rdDigit = (number / 100) % 10;
        if (_3rdDigit > 0) {// i.e. (519 / 100) % 10 = 5 <-- 3rd digit
            sb.append(FIRST_TWENTY[_3rdDigit]).append("Hundred ");
            number -= _3rdDigit * 100;
        }

        // tens
        if (number < 20) {
            // if remaining 2 digits less than 20 return from firstTwenty
            sb.append(FIRST_TWENTY[number]);
        } else {
            // map 2nd digit to ten name i.e. Twenty
            int _2ndDigit = (number / 10);
            sb.append(TENS[_2ndDigit]);

            // map 1st digit to the <20 ordinal numbers
            int _1thDigit = number % 10;
            if (_1thDigit != 0)
                sb.append("-");  // i.e. Sixty-Seven
            sb.append(FIRST_TWENTY[_1thDigit]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(9));
        System.out.println(numberToWords(99));
        System.out.println(numberToWords(520));
        System.out.println(numberToWords(999));
        System.out.println(numberToWords(1999));
    }
}
