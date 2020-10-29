//Jamar Golden jamgolde
import java.util.ArrayList;

public class DistinctStrings {
	private ArrayList <String> indWord = new ArrayList <String> ();//holds the distinct words
	private int wordCount;//Keeps track of the amount of times a word shows up
	private String name;//holds the word so that it can be used for the print statement
	private int wordLength;//holds the word length of each distinct word
	public DistinctStrings() {
	}
	public DistinctStrings(String s) {
		name = s;
		wordLength = name.length();
	}
	public String distinctWord(ArrayList aL) {//finds the number of distinct words
		int counter = 0;
		for (int i = 0; i < aL.size(); i++) {
			for (int j = 0; j < this.indWord.size(); j++) {
				if (aL.get(i).equals(this.indWord.get(j))) {
					break;
				}else {
					counter++;
				}
			}if (counter == (this.indWord.size())) {
				this.indWord.add((String) aL.get(i));
				counter = 0;
			}else {
				counter = 0;
			}
		}
		return "tinyTale.txt has " + indWord.size() + " distinct words";
	}
	public void increment() {//is used to add to a words work count when it is found
		this.wordCount++;
	}
	public String toString() {//formats the variables into a string
		return name + ": " + "{Word length: " + wordLength + "}: " + wordCount;
	}
	public ArrayList getIndWord() {// returns the array with the distinct types
		return indWord;
	}
}
