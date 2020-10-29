
public class Counter {
	private String name = "";
	private int count;
	
	public Counter(String id) {
		this.name = id;
	}
	public void increment() {
		this.count++;
	}
	public int tally() {
		return count;
	}
	public String toString() {
		return name + ": " + count + " ";
	}
}
