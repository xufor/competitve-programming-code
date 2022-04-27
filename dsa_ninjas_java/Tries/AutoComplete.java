import java.util.Arrays;
import java.util.LinkedList;

public class AutoComplete {
    public static void getListOfAllWords(TrieNode root, String result, LinkedList<String> listOfAllWords) {
        if (root.isTerminating) {
            listOfAllWords.add(result);
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getListOfAllWords(root.children[i], result + (char) ('A' + i), listOfAllWords);
            }
        }
    }

    public static LinkedList<String> getListOfAllWords(Trie trie) {
        LinkedList<String> resultList = new LinkedList<>();
        getListOfAllWords(trie.root, "", resultList);
        return resultList;
    }

    public static void search(TrieNode root, String queryString, String result) {
        if (queryString.isEmpty()) {
            LinkedList<String> resultList = new LinkedList<>();
            getListOfAllWords(root, "", resultList);
            for(String word: resultList) {
                System.out.println(result + word);
            }
            return;
        }
        int childIndex = queryString.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return;
        }
        search(child, queryString.substring(1), result + queryString.charAt(0));
    }

    public static void autocomplete(Trie trie, String queryString) {
        search(trie.root, queryString, "");
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        Arrays.stream(new String[] { "BANANA", "APPLE", "CAT", "CAMEL", "CATAPULT", "CAPITAL", "CAPTAIN", "BANNED",
                "APPLICATION", "APRICOT" }).forEach(word -> trie.add(word));
        autocomplete(trie, "T");
    }
}