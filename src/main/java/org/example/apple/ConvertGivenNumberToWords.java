package org.example.apple;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ConvertGivenNumberToWords {

    // Array to store numbers till 20
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
        StringBuffer sb = new StringBuffer();

        // find hundred digit, the 3rd one
        int _3rdDigit = (number / 100) % 10;
        if (_3rdDigit > 0) {// i.e. (519 / 100) % 10 = 5 <-- 3rd digit
            sb.append(firstTwenty[_3rdDigit] + "Hundred ");
            number -= _3rdDigit * 100;
        }

        // if remaining 2 digits less than 20
        if (number < 20) {
            sb.append(firstTwenty[number]);
        } else {
            int _2ndDigit = (number / 10);
            sb.append(tens[_2ndDigit]);

            int _1thDigit = number % 10;
            if (_1thDigit != 0)
                sb.append("-");

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
