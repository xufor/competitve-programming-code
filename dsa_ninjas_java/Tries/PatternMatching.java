public class PatternMatching extends Trie {
    private boolean search(TrieNode root, String word) {
        if(word.isEmpty()) {
            return true; // no need to check for termination if we have to do pattern matching
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return false;
        }
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(this.root, word);
    }

    public static boolean find(String pattern, String query) {
        Trie trie = new PatternMatching();
        for(int i = 0; i < pattern.length(); i++) {
            trie.add(pattern.substring(i));
        }
        return trie.search(query);
    }

    public static void main(String[] args) {
        System.out.println(find("HUMANBEING", "BEI"));
    }
}
