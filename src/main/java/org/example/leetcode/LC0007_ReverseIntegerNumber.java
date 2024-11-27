package org.example.leetcode;

// https://leetcode.com/problems/reverse-integer

public class LC0007_ReverseIntegerNumber {

    public static int reverse(int x)
    {
        int reversed = 0;
        int prev = 0;

        while( x != 0)
        {
            int lastDigit = x % 10;  // get last digit 34 mod 10 = 4
            x /= 10;                 // remove last digit 34 / 10 = 3 (integer division)
            reversed = (reversed * 10) + lastDigit;

            //
            if((reversed - lastDigit ) / 10 != prev)
                return 0;

            prev = reversed;

        }

        return reversed;
    }

    public static void main(String[] args)
    {
        //System.out.println(reverse(123));
        //System.out.println(reverse(-123));
        //System.out.println(reverse(120));
        System.out.println(reverse(1534236469));

        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }
}
