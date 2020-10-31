import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class FileReader implements java.io.Serializable{
	static transient ArrayList<Student> students = new ArrayList<>();
	private static transient ArrayList<Librarian> librarian = new ArrayList<>();
	static transient ArrayList<Book> books = new ArrayList<>();
	
	
	   /** initializes file reader*/
	   public FileReader()
	   {

	   }
	   /** method to update file with new data*/
	   public static void update()
	   {
		   try {
			FileOutputStream saveFile=new FileOutputStream("Save.ser");
			
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			
			save.writeObject(books);
			save.writeObject(students);
			//save.writeObject(Student.getBooks());
			save.writeObject(librarian);
			save.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   /** method to read current data in file, will be used when initializing the system*/
	   public static void readFile()
	   {

		try {
			
			FileInputStream saveFile = new FileInputStream("Save.ser");
			ObjectInputStream save = new ObjectInputStream(saveFile);
			books = (ArrayList<Book>) save.readObject();
			students = (ArrayList<Student>) save.readObject();
			librarian = (ArrayList<Librarian>) save.readObject();
			   
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   }
	   /** @return list of students in system*/
	   public static ArrayList<Student> viewStudents()
	   {
	      return students;
	   }
	   
	   /** @return list of librarians in system*/
	   public static ArrayList<Librarian> viewlibrarian()
	   {
	      return librarian;
	   }
	   
	   /** @return all books in system*/
	   public static ArrayList<Book> getBooks() {
	      return books;
	   }
	   public static ArrayList<Student> getStudents() {return students; }
	   public static ArrayList<Librarian> getLibrarian() {
		return librarian;
	}
	   public static ArrayList<Book> searchByAuthor(){
		   System.out.println("Enter author name");
		   Scanner src = new Scanner(System.in);
		   String author = src.next();
		   ArrayList<Book> found = new ArrayList<Book>();
		   for(Book search : FileReader.getBooks()) {
			   if(search.getAuthor().contains(author)) {
				   found.add(search);
	   }}
		   return found;}
	   
	   public static ArrayList<Book> searchByTitle(){
		   System.out.println("Enter book title");
		   Scanner src = new Scanner(System.in);
		   String title = src.next();
		   ArrayList<Book> found = new ArrayList<Book>();
		   for(Book search : FileReader.getBooks()) {
			   if(search.getTitle().contains(title)) {
				   found.add(search);
	   }}

		return found;}
	   
	   public static ArrayList<Book> searchByISBN(){
		   System.out.println("Enter the ISBN");
		   Scanner src = new Scanner(System.in);
		   String ISBN = src.next();
		   ArrayList<Book> found = new ArrayList<Book>();
		   for(Book search : FileReader.getBooks()) {
			   if(search.getISBN().contains(ISBN)) {
				   found.add(search);
			   }
		   }
		   return found;
	   }
	/**method to borrow a book  */
	public static void borrowBook(Book b, Student user ) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.MONTH, 1);

		if (user.penalties <= 0) {

			if (!b.getLent()) {
				b.setUniqueID();
				ArrayList<Book> newBooks = new ArrayList<>();
				newBooks = user.getBooksLent();
				newBooks.add(b);
				user.setBooksLent(newBooks);
				b.setLent(true);
				b.setReturnDate(date);
				FileReader.update();
				System.out.println("Book Successfully checked out!");
				System.out.println("Your Book ID is " + b.getUniqueID());
			} else {
				System.out.println("This book has been checked out");
			}
		} else {
			System.out.println("You may not borrow books until you have paid the balance");
		}
	}


	   public static void main(String[] args){

	   }

}
