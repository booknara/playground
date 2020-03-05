package com.booknara.problem.string;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToEnglishWordsTest {
    @Test
    public void numberToWords() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        Assert.assertEquals("One Million", integerToEnglishWords.numberToWords(1000000));
        Assert.assertEquals("One Hundred One", integerToEnglishWords.numberToWords(101));
        Assert.assertEquals("One Hundred Twenty Three", integerToEnglishWords.numberToWords(123));
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                integerToEnglishWords.numberToWords(1234567));
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                integerToEnglishWords.numberToWords(1234567891));
    }
}
