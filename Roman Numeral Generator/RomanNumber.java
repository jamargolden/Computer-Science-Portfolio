//Jamar Golden jamgolde
import java.util.Scanner;

public class RomanNumber {
	public static String Roman() {
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		int i = number.length();
		String num = "";
		String romanNumeral = "";
		while (i > 0) {
			if (i == 4) {
				num = number.charAt((number.length() - 4)) + "";
				int thisNum = Integer.parseInt(num);
				int j = 0;
				if (thisNum < 4) {
					while (j < thisNum) {
						romanNumeral += "M";
						j++;
					}
					i--;
				}
			}else if (i == 3) {
				num = number.charAt((number.length() - 3)) + "";
				int thisNum = Integer.parseInt(num);
				int j = 0;
				if (thisNum < 4) {
					while (j < thisNum) {
						romanNumeral += "C";
						j++;
					}
					i--;
				}else if (thisNum == 4) {
					romanNumeral += "CD";
					i--;
				}else if (thisNum > 4 && thisNum < 9) {
					romanNumeral += "D";
					while (j < (thisNum - 5)) {
						romanNumeral += "C";
						j++;
					}
					i--;
				}else if (thisNum == 9) {
					romanNumeral += "CM";
					i--;
				}
			}else if (i == 2) {
				num = number.charAt((number.length() - 2)) + "";
				int thisNum = Integer.parseInt(num);
				int j = 0;
				if (thisNum < 4) {
					while (j < thisNum) {
						romanNumeral += "X";
						j++;
					}
					i--;
				}else if (thisNum == 4) {
					romanNumeral += "XL";
					i--;
				}else if (thisNum > 4 && thisNum < 9) {
					romanNumeral += "L";
					while (j < (thisNum - 5)) {
						romanNumeral += "X";
						j++;
					}
					i--;
				}else if (thisNum == 9) {
					romanNumeral += "XC";
					i--;
				}
				
			}else if (i == 1) {
				num = number.charAt((number.length() - 1)) + "";
				int thisNum = Integer.parseInt(num);
				if (thisNum < 5) {
					if (thisNum == 4) {
						romanNumeral += "IV";
						i--;
					}else {
						int j = 0;
						while (j < thisNum) {
							romanNumeral += "I";
							j++;
						}
						i--;
					}
				}else if (thisNum >= 5) {
					if (thisNum == 5) {
						romanNumeral += "V";
						i--;
					}else if (thisNum == 9) {
						romanNumeral += "IX";
						i--;
					}else {
						romanNumeral += "V";
						int j = 0;
						while (j < (thisNum-5)) {
							romanNumeral += "I";
							j++;
						}
						i--;
					}
				}
			}
		}
		return romanNumeral;
	}
	public static void main(String[] args) {
		System.out.println(Roman());
	}
}
