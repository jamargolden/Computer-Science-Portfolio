/**
 * Solution to the pre-lecture exercise for lec3b.
 */

public class SinglyLinkedList<T> implements List<T> {

  /**
   * Node is a pair containing a data field and a pointer to
   * the next node in the list.
   */
  class Node {
    T data;
    Node next;
    
    Node(T data) {
      this(data, null);
    }
    
    Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
  
  Node head;  // points to the first node on this list, initially null
  int n;      // the number of nodes in this list, initially 0
  
  /**
   * Inserts the value x at the end of this list.
   */
  public void add(T... x) {
    n += x.length;
    int count = 0;
    if (head == null) {
      head = new Node(x[0]);
      count++;
    }
    else {
      Node p = head;
      while (p.next != null)
        p = p.next;
      for (int i = count; i < x.length; i++) {
        p.next = new Node(x[i]);
        p = p.next;
      }
    }
  }
  public void swap(int a, int b){
    if(a == b){
      return;
    }
    if (a >= n || b >= n){
      throw new IndexOutOfBoundsException();
    }
    Node p = head;
    int counter = 0;
    T save = null;
    T save2 = null;
    while (p != null){
      if (a < b) {
        if (counter == a) {
          save = p.data;
        }
        if (counter == b){
          save2 = p.data;
          p.data = save;
        }
      }
      else if (b < a) {
        if (counter == b) {
          save = p.data;
        }
        if (counter == a){
          save2 = p.data;
          p.data = save;
        }
      }
      counter++;
      p = p.next;
    }
    counter = 0;
    p = head;
    while (p != null){
      if (a < b){
        if (counter == a){
          p.data = save2;
        }
      }
      else if(b < a){
        if (counter == b){
          p.data = save2;
        }
      }
      counter++;
      p = p.next;
    }
  }
  /**
   * Removes the element at index i from this list.
   * @return the data in the removed node.
   * @throw IndexOutOfBoundsException iff i is out of range for this list.
   */
  public T remove(int i) {
    if (i < 0 || i >= size())
       throw new IndexOutOfBoundsException();
    n--;
    Node p = head;
    T ans;
    if (i == 0) {
      ans = head.data;
      head = head.next;
    }
    else {
      while (--i > 0) 
	p = p.next;
      ans = p.next.data;
      p.next = p.next.next;
    }
    return ans;
  }
    
  /**
   * Returns the i-th element from this list, where i is a zero-based index.
   * @throw IndexOutOfBoundsException iff i is out of range for this list.
   */
  public T get(int i) {
    if (i < 0 || i >= size())
      throw new IndexOutOfBoundsException();
    Node p = head;
    while (i > 0) {
      p = p.next;
      i--;
    }
    return p.data;
  }

  /**
   * Returns true iff the value x appears somewhere in this list.
   */
  public boolean contains(T x) {
    Node p = head;
    while (p != null)
      if (p.data.equals(x))  // replace == test with one that works on objects
        return true;
      else
        p = p.next;
    return false;
  }

  /**
   * Returns the number of elements in this list.
   */
  public int size() {
    return n;
  }
  
  /**
   * Returns true iff this is the empty list.
   */
  public boolean isEmpty() {
    return size() == 0;
  }
  
  /**
   * Returns a string representing this list (resembling a Racket list).
   */
  public String toString() {
    if (isEmpty())
      return "()";    
    StringBuilder ans = new StringBuilder("(").append(get(0));
    for (int i = 1; i < size(); i++)
      ans.append(" ").append(get(i));
    return ans.append(")").toString();
  }
  
  /**
   * Simple testing.
   */
  public static void main(String... args) {
    // The given tests, but with Integers.
    List<Integer> xs = new SinglyLinkedList<>();
    assert "()".equals(xs.toString());
    int[] a = new int[] { 7, 4, 6, 9, 2 };
    for (int x : a)
      xs.add(x);
    assert "(7 4 6 9 2)".equals(xs.toString());
    for (int x : a)
      assert xs.contains(x);
    for (int i = 0; i < xs.size(); i++)
      assert a[i] == xs.get(i);
    assert "(7 4 6 9 2)".equals(xs.toString());
    xs.remove(3);
    assert "(7 4 6 2)".equals(xs.toString());
    while (!xs.isEmpty())
      xs.remove(0);
    assert "()".equals(xs.toString());
    
    // Test with strings.
    List<String> animals = new SinglyLinkedList<>();
    animals.add("a" + "p" + "e");
    animals.add("bat");
    animals.add("cat");
    animals.add("dog");
    assert animals.contains("ape");
    
    // Test remove first and last.
    animals.remove(0);
    animals.remove(animals.size() - 1);
    assert 2 == animals.size();
    assert "(bat cat)".equals(animals.toString());
    
    animals.add("emu");
    animals.add("fox");
    animals.add("gnu");
    
    // Test inside remove.
    animals.remove(3);
    assert !animals.contains("fox");
    
    // Test remove all.
    while (!animals.isEmpty())
      animals.remove(0);
    assert 0 == animals.size();
    assert animals.isEmpty();
    
    // Test with structured elements.
    List<Fruit> fruit = new SinglyLinkedList<>();
    fruit.add(new Fruit("apple", 3));
    fruit.add(new Fruit("orange", 4));
    fruit.add(new Fruit("pear", 2));
    assert fruit.contains(new Fruit("apple", 3));
    assert !fruit.contains(new Fruit("apple", 4));

    animals.add("ab");
    animals.add("lo");
    animals.add("tel");
    animals.add("tl", "k");

    animals.swap(0, 2);
    System.out.println(animals.toString());
  }
}

/**
 * If you want to call yourself a List, then implement this interface:
 */
interface List<T> {
  void add(T... x);
  void swap(int a, int b);
  T remove(int i);
  T get(int i);
  boolean contains(T x);
  int size();
  boolean isEmpty();
}

/**
 * Used by SinglyLinkedList.main() for testing purposes.
 */
class Fruit {
  String name;
  int count;
  
  Fruit(String name, int count) {
    this.name = name;
    this.count = count;
  }
  
  public boolean equals(Object obj) {
    if (!(obj instanceof Fruit))
      return false;
    Fruit that = (Fruit) obj;
    return name.equals(that.name) && count == that.count;
  }
}