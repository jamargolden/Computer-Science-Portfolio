import java.util.ArrayList;
import java.util.Scanner;

public class Display {
	static ArrayList<Book> books;
	static int counter;
    public static void saveStudent(Student user){
        for(Student Account : FileReader.viewStudents()) {
            if(Account.getUsername().equals(user.getUsername())) {
                if(Account.getPassword().equals(user.getPassword())) {
                    FileReader.students.remove(Account);
                    FileReader.students.add(user);
                    FileReader.update();
                }
            }}}
	public static void studentDisplay(Student user) {
		System.out.println("1 -Search for book by author");
		System.out.println("2 -Search for book by title");
		System.out.println("3 -Search for book by ISBN");
		System.out.println("4 -View books borrowed");
		System.out.println("5 -View penalties");
		System.out.println("6 -Return book borrowed");
		System.out.println("Enter the number of a menu item to select it");
		Scanner src = new Scanner(System.in);
		int input =src.nextInt();
		switch(input) {
		case 1:
			books = FileReader.searchByAuthor();	
			counter=0;
			for(Book booksFound : books)
			{
				System.out.println(counter + " -" +booksFound.toString());
				 counter++;
				   }
            if (books.isEmpty()) {
			    System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
			src = new Scanner(System.in);
			input =src.nextInt();
			if(input <= counter) {
				System.out.println("you have selected " + books.get(input).toString());
				System.out.println("Would you like to borrow this book if so enter 1 else enter any other number");
				src = new Scanner(System.in);
				int input6 =src.nextInt();
				if(input6 == 1) {
                    FileReader.borrowBook(books.get(input), user);
                    saveStudent(user);
                    FileReader.update();
                    studentDisplay(user);
				}else {
					studentDisplay(user); 
				}
			}
			if(input >= counter) {
				studentDisplay(user);
			}
			break;
		case 2:
		books = FileReader.searchByTitle();	
		counter=0;
            for(Book booksFound : books)
            {
                System.out.println(counter + " -" +booksFound.toString());
                counter++;
            }
            if (books.isEmpty()) {
                System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
            src = new Scanner(System.in);
            input =src.nextInt();
            if(input <= counter) {
                System.out.println("you have selected " + books.get(input).toString());
                System.out.println("Would you like to borrow this book if so enter 1 else enter any other number");
                src = new Scanner(System.in);
                int input6 =src.nextInt();
                if(input6 == 1) {
                    FileReader.borrowBook(books.get(input), user);
                    saveStudent(user);
                    FileReader.update();
                    studentDisplay(user);
                }else {
                    studentDisplay(user);
                }
            }

			break;
		case 3:
			books = FileReader.searchByISBN();	
			counter=0;
            for(Book booksFound : books)
            {
                System.out.println(counter + " -" +booksFound.toString());
                counter++;
            }
            if (books.isEmpty()) {
                System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
            src = new Scanner(System.in);
            input =src.nextInt();
            if(input <= counter) {
                System.out.println("you have selected " + books.get(input).toString());
                System.out.println("Would you like to borrow this book if so enter 1 else enter any other number");
                src = new Scanner(System.in);
                int input6 =src.nextInt();
                if(input6 == 1) {
                    FileReader.borrowBook(books.get(input), user);
                    saveStudent(user);
                    FileReader.update();
                    studentDisplay(user);
                }else {
                    studentDisplay(user);
                }
            }
			break;
		case 4:

			for(Book book: user.getBooks()){
				System.out.println(book.toString());

			}
            studentDisplay(user);
			break;
		case 5:
			if (user.getPenalties() > 0) {
				System.out.println("Your penalties are " + user.getPenalties());
				System.out.println("Press 'P' if you wish to pay your penalties");
				src = new Scanner(System.in);
				String input2 = src.next();
				if (input2.equals("p") || input2.equals("P")){
					System.out.println("Enter the amount you would like to pay");
					src = new Scanner(System.in);
					input = src.nextInt();
					user.penalties = user.getPenalties() - input;
				}
			}
			else{
				System.out.println("You have no penalties at the moment");
			}
			break;
		case 6:
		    System.out.println("Enter the uniqueID of the book you would like to return");
            System.out.println("You can find the uniqueID by going back to menu and clicking 4");
            System.out.println("To go back to the menu enter 'M'");
            src = new Scanner(System.in);
            String input3 = src.next();
            if(input3.equals("m") || input3.equals("M")){
                studentDisplay(user);
            }
            else {
                user.returnBook(input3);
                studentDisplay(user);
            }
            break;
        default:
            System.out.println("You entered the wrong number");
            studentDisplay(user);
		}
	}
	public static void librarianDisplay(Librarian user) {
		System.out.println("1 -Search for book by author");
		System.out.println("2 -Search for book by title");
		System.out.println("3 -Search for book by ISBN");
		System.out.println("4 -View Students");
		System.out.println("5 -Add book");
		System.out.println("Enter the number of a menu item to select it");
		Scanner src = new Scanner(System.in);
		int input =src.nextInt();
		switch(input) {
		case 1:
            books = FileReader.searchByAuthor();
            counter=0;
            for(Book booksFound : books)
            {
                System.out.println(counter + " -" +booksFound.toString());
                counter++;
            }
            if (books.isEmpty()) {
                System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
            src = new Scanner(System.in);
            input =src.nextInt();
            if(input <= counter) {
                System.out.println("you have selected " + books.get(input).toString());
                System.out.println("Would you like to delete this book if so enter 1, to Change title, author, or ISBN enter 2" +
                        ", else enter any other number");
                src = new Scanner(System.in);
                int input6 =src.nextInt();
                if(input6 == 1) {
                    user.delete(input6);
                    FileReader.update();
                    librarianDisplay(user);
                }
                else if(input6==2){
                    System.out.println("To edit the title enter 1, to edit the author enter 2, to edit the ISBN enter 3, " +
                            "press any other number to go back to menu");
                    int input7 =src.nextInt();
                    if(input7==1){
                        System.out.println("Enter new title:");
                        String title = src.next();
                        books.get(input).setTitle(title);
                    }
                    else if(input7==2){
                        System.out.println("Enter new author:");
                        String author = src.next();
                        books.get(input).setTitle(author);
                    }
                    else if(input7==3){
                        System.out.println("Enter new ISBN:");
                        String ISBN = src.next();
                        books.get(input).setTitle(ISBN);
                    }
                }
                else {
                    librarianDisplay(user);
                }
            }
            if(input >= counter) {
                librarianDisplay(user);
            }
            librarianDisplay(user);
			break;
		case 2:
            books = FileReader.searchByTitle();
            counter=0;
            for(Book booksFound : books)
            {
                System.out.println(counter + " -" +booksFound.toString());
                counter++;
            }
            if (books.isEmpty()) {
                System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
            src = new Scanner(System.in);
            input =src.nextInt();
            if(input <= counter) {
                System.out.println("you have selected " + books.get(input).toString());
                System.out.println("Would you like to delete this book if so enter 1, to Change title, author, or ISBN enter 2, else enter any other number");
                src = new Scanner(System.in);
                int input6 =src.nextInt();
                if(input6 == 1) {
                    user.delete(input6);
                    FileReader.update();
                    librarianDisplay(user);
                }
                else if(input6==2){
                    System.out.println("To edit the title enter 1, to edit the author enter 2, to edit the ISBN enter 3, " +
                            "press any other number to go back to menu");
                    int input7 =src.nextInt();
                    if(input7==1){
                        System.out.println("Enter new title:");
                        String title = src.next();
                        books.get(input).setTitle(title);
                    }
                    else if(input7==2){
                        System.out.println("Enter new author:");
                        String author = src.next();
                        books.get(input).setTitle(author);
                    }
                    else if(input7==3){
                        System.out.println("Enter new ISBN:");
                        String ISBN = src.next();
                        books.get(input).setTitle(ISBN);
                    }
                }
                else {
                    librarianDisplay(user);
                }
            }
            if(input >= counter) {
                librarianDisplay(user);
            }
            librarianDisplay(user);
			break;
		case 3:
            books = FileReader.searchByISBN();
            counter=0;
            for(Book booksFound : books)
            {
                System.out.println(counter + " -" +booksFound.toString());
                counter++;
            }
            if (books.isEmpty()) {
                System.out.println("No books match search criteria, Enter '1' to go to menu");
            }
            else {
                System.out.println("Enter the number of the book or any other number to get back to menu");
            }
            src = new Scanner(System.in);
            input =src.nextInt();
            if(input <= counter) {
                System.out.println("you have selected " + books.get(input).toString());
                System.out.println("Would you like to delete this book if so enter 1, to Change title, author, or ISBN enter 2, else enter any other number");
                src = new Scanner(System.in);
                int input6 =src.nextInt();
                if(input6 == 1) {
                    user.delete(input6);
                    FileReader.update();
                    librarianDisplay(user);
                }
                else if(input6==2){
                    System.out.println("To edit the title enter 1, to edit the author enter 2, to edit the ISBN enter 3, " +
                            "press any other number to go back to menu");
                    int input7 =src.nextInt();
                    if(input7==1){
                        System.out.println("Enter new title:");
                        String title = src.next();
                        books.get(input).setTitle(title);
                    }
                    else if(input7==2){
                        System.out.println("Enter new author:");
                        String author = src.next();
                        books.get(input).setTitle(author);
                    }
                    else if(input7==3){
                        System.out.println("Enter new ISBN:");
                        String ISBN = src.next();
                        books.get(input).setTitle(ISBN);
                    }
                }
                else {
                    librarianDisplay(user);
                }
            }
            if(input >= counter) {
                librarianDisplay(user);
            }
            librarianDisplay(user);
			break;
		case 4:
		    String names = "";
		    for (Student s: FileReader.getStudents()){
		        names += s.getName() + ", ";
            }
            System.out.println(names);
            librarianDisplay(user);
			break;
		case 5:
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Title of book: ");
            String title =in.next();
            System.out.println("Enter Author of book: ");
            String author = in.next();
            System.out.println("Enter ISBN of book:");
            String ISBN = in.next();
		    user.add(title, author,ISBN);
		    FileReader.update();
		    librarianDisplay(user);
			break;
        default:
            System.out.println("You entered the wrong number");
            librarianDisplay(user);
		}
	}
	public static void main(String[] args){

    }
}
