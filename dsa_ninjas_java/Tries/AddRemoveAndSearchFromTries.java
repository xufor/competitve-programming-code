class TrieNode {
    char data;
    boolean isTerminating;
    TrieNode[] children;
    int childCount;

    TrieNode(char data) {
        this.data = data;
        this.isTerminating = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }
}

class Trie {
    TrieNode root = new TrieNode('\0');

    private void add(TrieNode root, String word) {
        if(word.isEmpty()) {
            root.isTerminating = true;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            root.childCount++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(this.root, word);
    }

    private boolean search(TrieNode root, String word) {
        if(word.isEmpty()) {
            return root.isTerminating;
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

    private void remove(TrieNode root, String word) {
        if(word.isEmpty()) {
            root.isTerminating = false;
            return;
        }
        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if(child == null) {
            return;
        }
        remove(child, word.substring(1));

        if(!child.isTerminating && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }

        // we can only remove child only if it is non terminating and its number of children are 0
        // if(!child.isTerminating) {
        //     int numberOfchildren = 0;
        //     for(TrieNode childOfChild: child.children) {
        //         if(childOfChild != null)
        //             numberOfchildren++;
        //     }
        //     if(numberOfchildren == 0) {
        //         root.children[childIndex] = null;
        //     }
        // }
    }

    public void remove(String word) {
        remove(this.root, word);
    }
}

public class AddRemoveAndSearchFromTries {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("NOTE");
        trie.add("NOBLE");
        System.out.println(trie.search("NO"));
        System.out.println(trie.search("NOTE"));
        trie.remove("NOTE");
        System.out.println(trie.search("NOBLE"));
        System.out.println(trie.search("NOTE"));
    }
}