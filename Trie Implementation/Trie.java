import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Trie implements Iterable<String> {
  class Node {
    String word;   // if word is null, then no data present in this node
    Map<Character, Node> children;  // only non-null children are stored

    /**
     * Creates an empty leaf node.
     */
    Node() {
      this(null);
    }

    /**
     * Creates a leaf node with the given word present.
     */
    Node(String word) {
      this.word = word;
      children = new HashMap<>();
    }

    /**
     * TODO
     *
     * Inserts s into the trie assuming that the first i characters
     * in s have led us to this node.
     */
    void insert(String s, int i) {
      if (s.length() == i){
        word = s;
        n++;
        return;
      }
      else{
        if (children.containsKey(s.charAt(i))) {
          children.get(s.charAt(i)).insert(s, i+1);
        }
        else {
          Node t = new Node();
          children.put(s.charAt(i), t);
          t.insert(s, i+1);
        }
      }
    }

    /**
     * TODO
     *
     * Removes s from the trie assuming that the first i character 
     * in s have led us to this node.
     */
    void remove(String s, int i) {
      if (i == s.length()){
        if (word != null){
          n--;
          return;
        }
        else return;
      }
      else {
        if (children.containsKey(s.charAt(i))) {
          children.get(s.charAt(i)).remove(s, i+1);
        }
        else return;;
      }
    }

    /**
     * TODO
     *
     * Returns true iff s is in the trie assuming that the first i
     * characters in s have led us to this node.
     */
    boolean contains(String s, int i) {
      if (s.length() == i){
        return s.equals(word);
      }
      else {
        if (children.get(s.charAt(i)) == null) {
          return false;
        }
        return children.get(s.charAt(i)).contains(s, i+1);
      }
    }
  }

  protected Node root = new Node();   // root is never null
  protected int n = 0;                // number of keys in this trie

  /**
   * Inserts s into this trie. If s was already present in this trie,
   * then nothing happens.
   */
  public void insert(String s) {
    root.insert(s, 0);
  }

  /**
   * Removes s from this trie. If s was not in this trie to begin with, 
   * then nothing happens.
   */
  public void remove(String s) {
    root.remove(s, 0);
  }

  /**
   * Return true iff s is a key in this trie.
   */
  public boolean contains(String s) {
    return root.contains(s, 0);
  }

  /**
   * Returns the number of keys in this trie. Must run in O(1) time.
   */
  public int size() {
    return n;
  }

  /**
   * Returns true iff this trie is empty. Must run in O(1) time.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Resets this trie to be empty.
   */
  public void clear() {
    n = 0;
    root = new Node();
  }

  /**
   * TODO
   *
   * Returns a sorted list of all the keys in this trie. If you 
   * need a helper, put it in the Node class. Make use of
   * Collections.sort() to arrange the keys in sorted order.
   * This method should run in O(n log n) time, where n is the
   * number of keys.
   */
  public List<String> getKeys() {
    return null;
  }

  /**
   * Returns an iterator over the keys in this trie. Note that
   * removing via the returned iterator will not remove the key in the
   * trie.
   */
  public Iterator<String> iterator() {
    return getKeys().iterator();
  }

  /**
   * Returns a textual representation of the keys in this trie.
   */
  public String toString() {
    return getKeys().toString();
  }

  public static void main(String... args) {
    Trie trie = new Trie();
    String[] words;
    words = new String[] { "he", "she", "his", "hers", "her" };
    for (String word : words)
      trie.insert(word);
    for (String word : words)
      assert trie.contains(word);
    assert 5 == trie.size();
    trie.remove("he");
    trie.remove("he");
    trie.remove("ours");
    assert 4 == trie.size();
    assert trie.contains("he") == false;
    assert trie.contains("her");
    trie.insert("they");
    trie.insert("their");

    Dictionary dict = new Dictionary(word -> word.length() >= 14);
    int n = dict.size();
    assert 113 == n;
    assert dict.contains("psychoanalysis");
    for (String word : dict) {
      dict.remove(word);
      n--;
      assert dict.size() == n;
    }
    assert dict.isEmpty();
    dict = new Dictionary(word -> word.length() >= 5);
    assert !dict.contains("cat");
    n = dict.size();
    assert 17526 == n;

    System.out.println("All tests passed...");
  }
}

class Dictionary extends Trie {
  public static final String FILENAME = "big-dictionary.txt";

  /**
   * Reads the words from the file and creates an unfiltered dictionary.
   */
  public Dictionary() {
    this(word -> true);
  }

  /**
   * Reads the words from the file and creates a dictionary populated
   * with only those words that satisfy the given predicate.
   */
  public Dictionary(Predicate<String> pred) {
    try {
      BufferedReader in = new BufferedReader(new FileReader(FILENAME));
      String word;
      while ((word = in.readLine()) != null) 
        if (pred.test(word))
          insert(word);
      in.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("The dictionary file, " + FILENAME + 
                         ", is not found.");
    }
    catch (IOException e) {
      e.printStackTrace(System.out);
    }   
  }
}
