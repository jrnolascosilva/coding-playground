package org.example.apple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertGivenNumberToWordsTest {

    @Test
    @Disabled
    void shouldConvertLessThan20() {
        long value = 19;
        String expected = "Nineteen";

        assertEquals(expected, ConvertGivenNumberToWords.convert(value));
    }

    @Test
    void shouldConvert1234567() {
        long value = 1234567;
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";

        Assertions.assertEquals(expected, ConvertGivenNumberToWords.convert(value));
    }
}