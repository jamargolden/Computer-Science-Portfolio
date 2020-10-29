import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

//Jamar Golden jamgolde
public class FrequencyCounter {
	private ArrayList <String> wordList = new ArrayList <String> ();//Contains all the words
	private long line = 0;//Number of Lines
	
	
	public FrequencyCounter(String fileName) {
		Scanner sc = null;
		try {//Takes in the file and inserts the words into an Array
			sc = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Error");
		}
		while(sc.hasNext()) {
			this.wordList.add(sc.next());
		}
		try {
			line = Files.lines(Paths.get(new File(fileName).getPath())).count();
		} catch (IOException e) {
			System.out.println("Error");
		}
		
	}
	public String word() {//Prints out number of words
		return "tinyTale.txt has " + wordList.size() + " number of words";
	}
	public String lines() {//Prints out number of lines
		return "tinyTale.txt has " + line + " number of lines";
	}
	public ArrayList getWordList() {//returns the array holding the words
		return this.wordList;
	}

}
