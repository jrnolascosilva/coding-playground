package org.example.other;

// https://leetcode.com/problems/reverse-integer/description/

public class ReverseIntegerNumber {

    public static int reverse(int x)
    {
        int reversed = 0;

        while( x > 0)
        {
            int lastDigit = x % 10;  // get last digit 34 mod 10 = 4
            x /= 10;                 // remove last digit 34 / 10 = 3 (integer division)
            reversed = (reversed * 10) + lastDigit;
        }

        return reversed;
    }

    public static void main(String[] args)
    {
        System.out.println(reverse(987654321));
    }
}
