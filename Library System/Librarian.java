
import java.util.ArrayList;

public class Librarian implements java.io.Serializable{
	
	   private String username;
	   private String password;
	   
	   private String name;
	   /** @param name name of the librarian */
	   public Librarian(String name, String username, String password)
	   {
		   this.name = name;
		   this.password = password;
		   this.username = username;
	   }
	   /** method to delete book from system*/
	   public void delete(int index)
	   {
		   FileReader.getBooks().remove(index);
	   }
	   /** method to add book to system */
	   public void add(String title, String author, String ISBN)
	   {
		   Book newBook = new Book(title,author,ISBN,false, null,null);
		   FileReader.getBooks().add(newBook);
	   }
	   public String getUsername()
	   {
		   return username;
	   }
	   public String getPassword()
	   {
		   return password;
	   }

}
