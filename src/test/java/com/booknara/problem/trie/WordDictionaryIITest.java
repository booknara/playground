package com.booknara.problem.trie;

import org.junit.Assert;
import org.junit.Test;

public class WordDictionaryIITest {
    @Test
    public void search() {
        WordDictionary wordDictionaryII = new WordDictionary();
        wordDictionaryII.addWord("bad");
        wordDictionaryII.addWord("dad");
        wordDictionaryII.addWord("mad");

        Assert.assertFalse(wordDictionaryII.search("pad"));
        Assert.assertTrue(wordDictionaryII.search("bad"));
        Assert.assertTrue(wordDictionaryII.search(".ad"));
        Assert.assertTrue(wordDictionaryII.search("b.."));
    }
}
