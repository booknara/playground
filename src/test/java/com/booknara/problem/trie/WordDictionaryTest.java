package com.booknara.problem.trie;

import org.junit.Assert;
import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void search() {
        WordDictionary WordDictionary = new WordDictionary();
        WordDictionary.addWord("bad");
        WordDictionary.addWord("dad");
        WordDictionary.addWord("mad");

        Assert.assertFalse(WordDictionary.search("pad"));
        Assert.assertTrue(WordDictionary.search("bad"));
        Assert.assertTrue(WordDictionary.search(".ad"));
        Assert.assertTrue(WordDictionary.search("b.."));
    }
}
