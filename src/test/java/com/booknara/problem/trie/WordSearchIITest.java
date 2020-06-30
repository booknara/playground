package com.booknara.problem.trie;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class WordSearchIITest {
    @Test
    public void findWords() {
        WordSearchII wordSearchII = new WordSearchII();
        char[][] board = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[] {
                "oath","pea","eat","rain"
        };
        Assert.assertEquals(Arrays.asList("eat","oath"), wordSearchII.findWords(board, words));
    }
}
