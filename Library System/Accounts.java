import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
	
		static Student studentAccount;
		static Librarian librarianAccount;
	   /** method to create a new account*/
	   public static void createAccount()
	   {
		   String name;
		   String username;
		   String password;
		   ArrayList<Book> booksLent = null;
		   System.out.println("Enter your name");
		   Scanner src = new Scanner(System.in);
		   name = src.next();
		   System.out.println("Enter your username");
		   src = new Scanner(System.in);
		   username = src.next();
		   System.out.println("Enter your password");
		   src = new Scanner(System.in);
		   password = src.next();
		   
		   Student stu = new Student(name, username, password, booksLent, 0);
		   studentAccount = stu;
		   FileReader.getStudents().add(stu);
		   FileReader.update();
		   Display.studentDisplay(studentAccount);
	   }
	   /** method to login to the system if you already have a student account */
	   public static void studentlogin()
	   {
		   String username;
		   String password;
		   boolean login = false;
		   do {
		   System.out.println("Enter your username");
		   Scanner src = new Scanner(System.in);
		   username = src.next();
		   System.out.println("Enter your password");
		   src = new Scanner(System.in);
		   password = src.next();
		   for(Student Account : FileReader.viewStudents()) {
			   if(Account.getUsername().equals(username)) {
				   if(Account.getPassword().equals(password)) {
					   login = true;
					   studentAccount = Account;
					   Display.studentDisplay(studentAccount);
				   }
			   }}
		   if(login == false) {
			   System.out.println("You have entered either the wrong username or password");
		   }
		   }while(login == false);
	   }
	   /** method to login to the system if you already have a librarian account */
	   public static void librarianLogin()
	   {
		   String username;
		   String password;
		   boolean login = false;
		   do {
		   System.out.println("Enter your username");
		   Scanner src = new Scanner(System.in);
		   username = src.next();
		   System.out.println("Enter your password");
		   src = new Scanner(System.in);
		   password = src.next();
		   for(Librarian Account : FileReader.viewlibrarian()) {
			   if(Account.getUsername().equals(username)) {
				   if(Account.getPassword().equals(password)) {
					   login = true;
					   librarianAccount = Account;
					   Display.librarianDisplay(librarianAccount);
				   }
			   }}
		   if(login == false) {
			   System.out.println("You have entered either the wrong username or password");
		   }
		   }while(login == false);
	   }
	   public static void main(String [] args) {
           FileReader.readFile();
		   System.out.println("Enter 1 to login as a student, 2 to login as a librarian, or 3 to register as a student");
		   Scanner src = new Scanner(System.in);
		   int command = src.nextInt();
		   if(command == 1) {
			   studentlogin();
		   }
		   else if(command == 2) {
			   librarianLogin();
		   }
		   else if(command == 3) {
			   createAccount();
		   }
		   //System.out.println(FileReader.getStudents().get(0).getBooks().get(0).toString());
	   }


}
