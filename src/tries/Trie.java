package tries;

class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode children[];
    // traverse through entire array and check if each index in null
    // or maintain a counter that keeps track of child nodes of a node
    int childCount;

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        // root node is a NULL character
        root = new TrieNode('\0');
    }

    /**
     * Add a word to the trie
     * */
    public void add(String word) {
        addHelper(root, word);
    }

    /*Helper function for add(word)*/
    private void addHelper(TrieNode root, String word) {
        // base case
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        // NOTE: we are only considering upper case letters
        int childIndex = word.charAt(0) - 'A';
        // check if node at that index is present or not
        TrieNode child = root.children[childIndex];
        if (child == null) {
            // child does not exist, then create one
            child = new TrieNode(word.charAt(0));
            root.children[childIndex] = child;
            // increment count after every insert operation
            root.childCount++;
        }

        // pass word after the 1st index
        // for eg: if you checked N in NOTE then start from OTE in the next call
        addHelper(child, word.substring(1));
    }

    /**
     * Search for a word in trie
     * */
    public boolean search(String word) {
        return searchHelper(root, word);
    }

    /*Helper function for search(word)*/
    private boolean searchHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            return false;
        }

        return searchHelper(child, word.substring(1));
    }

    /**
     * Remove a word from trie
     * */
    public void remove(String word) {
        removeHelper(root, word);
    }

    /*Helper function for remove(word)*/
    public void removeHelper(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = false;
            return;
        }

        int childIndex = word.charAt(0) - 'A';
        TrieNode child = root.children[childIndex];
        if (child == null) {
            // word is not present
            return;
        }

        removeHelper(child, word.substring(1));
        if (!child.isTerminal && child.childCount == 0) {
            root.children[childIndex] = null;
            root.childCount--;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("NOTE");
        trie.add("AND");
        System.out.println("Is the word present: " + trie.search("AND"));
        trie.remove("AND");
        System.out.println("Is the word present: " + trie.search("AND"));

        trie.add("NEW");
        trie.add("NEWS");
        trie.remove("NEWS");
        System.out.println("Is the word present: " + trie.search("NEW"));
        System.out.println("Is the word present: " + trie.search("NEWS"));
    }
}
