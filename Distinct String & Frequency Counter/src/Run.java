//Jamar Golden jamgolde
import java.util.ArrayList;

public class Run {
	private ArrayList <DistinctStrings> distinctWordList = new ArrayList <DistinctStrings> ();
	// an array that holds the DistinctStrings values
	private String ans = "";//Holds the final answer as a String
	public String newList(ArrayList aL) {//adds new DistinctStrings to the array
		for (int i = 0; i < aL.size(); i++) {
			this.distinctWordList.add(new DistinctStrings((String)aL.get(i)));
			
		}
		return "";
	}
	public String wordsCount(ArrayList aL, ArrayList aL2) {//finds the word count for each DistinctStrings
		for (int i = 0; i < aL2.size(); i++) {
			for (int j = 0; j < this.distinctWordList.size(); j++) {
				if (aL.get(j).equals(aL2.get(i))) {
					this.distinctWordList.get(j).increment();
				}
			}
		}
		for (int j = 0; j < distinctWordList.size(); j++) {
			this.ans += this.distinctWordList.get(j).toString() + "\n";
		}
		return this.ans;
	}
	public static void main(String[] args) {
		FrequencyCounter test = new FrequencyCounter("tinyTale.txt");
		DistinctStrings dS = new DistinctStrings();
		Run testing = new Run();
		System.out.println(test.word());
		System.out.println(test.lines());
		System.out.println(dS.distinctWord(test.getWordList()));
		System.out.print(testing.newList(dS.getIndWord()));
		System.out.println(testing.wordsCount(dS.getIndWord(), test.getWordList()));
	}

}
