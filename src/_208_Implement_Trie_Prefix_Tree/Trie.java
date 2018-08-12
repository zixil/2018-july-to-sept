package _208_Implement_Trie_Prefix_Tree;

import java.util.LinkedList;

public class Trie {
    Trie[] children = new Trie[27];

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0) {
            children[26] = new Trie();
            return;
        }
        char c = word.charAt(0);
        if (children[c - 'a'] == null) children[c - 'a'] = new Trie();
        children[c - 'a'].insert(word.substring(1));
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0) return children[26] != null;
        char c = word.charAt(0);
        if (children[c - 'a'] == null) return false;
        return children[c - 'a'].search(word.substring(1));
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) return true;
        char c = prefix.charAt(0);
        if (children[c - 'a'] == null) return false;
        return children[c - 'a'].startsWith(prefix.substring(1));
    }
}
