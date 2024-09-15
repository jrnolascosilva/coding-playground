package org.example.apple;

import java.util.ArrayList;
import java.util.List;

public class ConvertGivenNumberToWords {

    // Array to store numbers till 20 ordinal numbers
    static String[] firstTwenty = {
            "", "One ", "Two ", "Three ",
            "Four ", "Five ", "Six ", "Seven ",
            "Eight ", "Nine ", "Ten ", "Eleven ",
            "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
            "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
    };

    // Array to store multiples of ten
    static String[] tens = {"", "", "Twenty", "Thirty",
            "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety"};
    // Array to store the powers of 10
    static String[] multiplier = {"", "Thousand ", "Million ", "Billion ", "Trillion "};

    public static String convert(long number) {
        if (number == 0)
            return "Zero";

        if (number < 20)
            return firstTwenty[(int) number];

        List<String> answer = new ArrayList<>();

        int iteration = 0;
        while (number > 0) {
            int digitGroup = (int) number % 1000;
            number /= 1000;
            answer.add(convertGroup(digitGroup) + multiplier[iteration]);
            iteration++;
        }
        return String.join("", answer.reversed());
    }

    public static String convertGroup(int number) {
        StringBuilder sb = new StringBuilder();

        // find hundred digit, the 3rd one
        int _3rdDigit = (number / 100) % 10;
        if (_3rdDigit > 0) {// i.e. (519 / 100) % 10 = 5 <-- 3rd digit
            sb.append(firstTwenty[_3rdDigit] + "Hundred ");
            number -= _3rdDigit * 100;
        }

       // tens
        if (number < 20) {
            // if remaining 2 digits less than 20 return from firstTwenty
            sb.append(firstTwenty[number]);
        }
        else {
            // map 2nd digit to ten name i.e. Twenty
            int _2ndDigit = (number / 10);
            sb.append(tens[_2ndDigit]);

            // map 1nd digit to the <20 ordinal numbers
            int _1thDigit = number % 10;
            if (_1thDigit != 0)
                sb.append("-");  // i.e. Sixty-Seven
            sb.append(firstTwenty[_1thDigit]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        //System.out.println(convertGroup(99, 0));
        //System.out.println(convertGroup(520, 0));
        //System.out.println(convertGroup(999, 0));
        System.out.println(convert(1999));
    }
}
