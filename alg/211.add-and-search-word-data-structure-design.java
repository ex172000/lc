class WordDictionary {
    class Trie {
        Trie[] children;
        boolean finish;
        Trie() {
            finish = false;
            children = new Trie[26];
        }
    }
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie ptr = root;
        for (char c : word.toCharArray()) {
            if (ptr.children[c - 'a'] == null)
                ptr.children[c - 'a'] = new Trie();
            ptr = ptr.children[c - 'a'];
        }
        ptr.finish = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int p, Trie root) {
        char c = word.charAt(p);
        boolean res = false;
        if (c == '.') {
            for (Trie t : root.children) {
                if (t != null) {
                    if (p == word.length() - 1) {
                        if (t.finish) return true;
                        continue;
                    }
                    if (search(word, p + 1, t))
                        return true;
                }
            }
            return false;
        } else {
            if (root.children[c - 'a'] == null) return false;
            if (p == word.length() - 1)
                return root.children[c - 'a'].finish;
            return search(word, p + 1, root.children[c - 'a']);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
