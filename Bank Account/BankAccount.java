import java.util.Scanner;

public class BankAccount {
	public static String banks() {
		boolean amounts = true;
		
		double investmentBalance = 0;
		double savingsBalance = 0;
		double checkingBalance = 0;
		
		while (amounts == true) {
			System.out.println("Enter Checking Balance: ");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Savings Balance: ");
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter Investment Balance: ");
			Scanner sc3 = new Scanner(System.in);
			
			checkingBalance = sc.nextDouble();
			savingsBalance = sc.nextDouble();
			investmentBalance = sc.nextDouble();
			
			if (checkingBalance > 0 && savingsBalance > 0 && investmentBalance > 0) {
				amounts = false;
			}
		}
		int account = 1;
		
		boolean menu = true;
		while (menu == true) {
			System.out.println("Enter 1 to Check balance: ");
			System.out.println("Enter 2 to Switch Account Type: ");
			System.out.println("Enter 3 to Make a Deposit: ");
			System.out.println("Enter 4 to Make a Withdrawl: ");
			System.out.println("Enter 5 to Exit: ");
			Scanner sc4 = new Scanner(System.in);
			int menuInput = sc4.nextInt();
			if (menuInput == 1) {
				if (account == 1) {
					System.out.println("Checking balance: $" + checkingBalance);
				}
				else if (account == 2) {
					System.out.println("Savings balance: $" + savingsBalance);
				}
				else if (account == 3) {
					System.out.println("Investment balance: $" + investmentBalance);
				}
			}
			else if (menuInput == 2) {
				System.out.println("Enter 1 for Checking Account: ");
				System.out.println("Enter 2 for Savings Account: ");
				System.out.println("Enter 3 for Investment Account: ");
				
				Scanner sc5 = new Scanner(System.in);
				int accountInput = sc5.nextInt();
				if (accountInput == 1) {
					account = 1;
					System.out.println("You are in your Checking Account: $" + checkingBalance);
				}
				else if (accountInput == 2) {
					account = 2;
					System.out.println("You are in your Saving Account: $" + savingsBalance);
				}
				else if (accountInput == 3) {
					account = 3;
					System.out.println("You are in your Investment Account: $" + investmentBalance);
				}
			}else if (menuInput == 3) {
				boolean depositCase = true;
				double deposit = 0;
				
				while (depositCase == true) {
					System.out.println("Enter Deposit Amount: ");
					Scanner sc6 = new Scanner(System.in);
					deposit = sc6.nextDouble();
					if (deposit > 0) {
						depositCase = false;
					}
				}
				
				if (account == 1) {
					checkingBalance += deposit;
					System.out.println("Checking balance: $" + checkingBalance);
				}
				else if (account == 2) {
					savingsBalance += deposit;
					System.out.println("Savings balance: $" + savingsBalance);
				}
				else if (account == 3) {
					investmentBalance += deposit;
					System.out.println("Investment balance: $" + investmentBalance);
				}
			}
			else if (menuInput == 4) {
				boolean withdrawlCase = true;
				double withdrawl = 0;
				
				while (withdrawlCase == true) {
					System.out.println("Enter Withdrawl Amount: ");
					Scanner sc7 = new Scanner(System.in);
					withdrawl = sc7.nextDouble();
					if (account == 1) {
						if (withdrawl <= checkingBalance) {
							withdrawlCase = false;
						}
					}
					else if (account == 2) {
						if (withdrawl <= savingsBalance) {
							withdrawlCase = false;
						}
					}else if (account == 3) {
						if (withdrawl <= investmentBalance) {
							withdrawlCase = false;
						}
					}
				}
				
				if (account == 1) {
					checkingBalance -= withdrawl;
					System.out.println("Checking balance: $" + checkingBalance);
				}
				else if (account == 2) {
					savingsBalance -= withdrawl;
					System.out.println("Savings balance: $" + savingsBalance);
				}
				else if (account == 3) {
					investmentBalance -= withdrawl;
					System.out.println("Investment balance: $" + investmentBalance);
				}
			}else if (menuInput == 5) {
				menu = false;
			}
		}
		return "Thank You";
	}
	public static void main(String[] args) {
		System.out.println(banks());
	}
}
