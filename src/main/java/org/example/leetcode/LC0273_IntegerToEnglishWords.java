package org.example.leetcode;

// https://leetcode.com/problems/integer-to-english-words/description/
// Explanation: https://youtu.be/G0_I-ZF0S38?si=ediF9A8E1dqlQq2q
// https://www.geeksforgeeks.org/convert-number-to-words/

import java.util.ArrayList;
import java.util.List;

public class LC0273_IntegerToEnglishWords {

    // Array to store numbers till 20 ordinal numbers
    String[] FIRST_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",  "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // Array to store multiples of ten
    String[] TENS ={"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    // Array to store the powers of 10
    final String[] POSTFIX = {"", " Thousand ", " Million ", " Billion "};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        if(num < 20)
            return FIRST_20[num];

        List<String> answer = new ArrayList<>();

        int i = 0;
        while ( num > 0 ) {
            int threeDigits = num % 1000;
            answer.add(toWords(threeDigits) + POSTFIX[i]);
            num /= 1000;
            i++;
        }

        return String.join("", answer.reversed());
    }

    private String toWords(int num) {
        int _3rdDigit = (num / 100) % 10;   // i.e. (519 / 100) % 10 = 5 <-- 3rd digit

        StringBuilder sb = new StringBuilder();

        // find the hundred digit, the 3rd digit
        if(_3rdDigit > 0) {
            sb.append(FIRST_20[_3rdDigit] + " Hundred ");
            num = num - (_3rdDigit * 100);  // Example: 519 - 500 = 19
        }

        if(num < 20)
        {
            // if remaining 2 digits less than 20 return from FIRST_20
            sb.append(FIRST_20[num]);
        }
        else {
            // map 2nd digit to ten name i.e. Twenty
            int _2ndDigit = (num / 10);
            sb.append( TENS[_2ndDigit]);

            // map 1st digit to the <20 ordinal numbers
            int _1thDigit = num % 10;
            if (_1thDigit != 0)
                sb.append(" ");  // i.e. Sixty-Seven

            sb.append(FIRST_20[_1thDigit]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC0273_IntegerToEnglishWords app = new LC0273_IntegerToEnglishWords();
        System.out.println(app.numberToWords(9));
        System.out.println(app.numberToWords(99));
        System.out.println(app.numberToWords(520));
        System.out.println(app.numberToWords(999));
        System.out.println(app.numberToWords(1999));
    }
}
