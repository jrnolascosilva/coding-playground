package org.example.other;

public class ReverseIntegerNumber {

    public static int reverseAsInteger(int number)
    {
        int reversed = 0;

        while( number > 0)
        {
            int lastDigit = number % 10;  // get last digit 34 mod 10 = 4
            number /= 10;                 // remove last digit 34 / 10 = 3 (integer division)
            reversed = (reversed * 10) + lastDigit;
        }

        return reversed;
    }

    public static void main(String[] args)
    {
        System.out.println(reverseAsInteger(987654321));
    }
}
