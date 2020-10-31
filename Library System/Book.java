import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Book implements java.io.Serializable{

	   private String author;
	   private String title;
	   private String ISBN;
	   String uniqueID;
	   private Boolean lent;
	   private Calendar returnDate;

	   /**  @param //author is the author of the book being created in the system
	    * @param //ISBN is the number by which the book is identified
	    * @param //title is the title of the book being created in the system*/
	   public Book(){
	   }
	   public Book (String title, String author, String ISBN, Boolean lent, String uniqueID, Calendar returnDate){
			this.title = title;
			this.author = author;
			this.ISBN = ISBN;
			this.lent = lent;
		    this.returnDate = returnDate;
		    this.uniqueID = uniqueID;
	   }
	   /** @return gives back the author of a book*/
	   public String getAuthor()
	   {
	      return author;
	   }

	   /** @param author name of the author that you wish to change the book author to*/
	   public void setAuthor(String author)
	   {
	      this.author = author;
	   }

	   /** @return gives the title of a book*/
	   public String getTitle()
	   {
	      return title;
	   }

	   /** @param title name of the title that you wish to change the book title to*/
	   public void setTitle(String title)
	   {
	      this.title = title;
	   }

	   /** @return gives ISBN of a book*/
	   public String getISBN()
	   {
	      return ISBN;
	   }

	   /**@param ISBN that you wish to change the book isbn to */
	   public void setISBN(String ISBN)
	   {
	      this.ISBN = ISBN;
	   }

	   /** @return gives the uniqueID of a book that is lent*/
	   public String getUniqueID()
	   {
	      return uniqueID;
	   }

	   /** @param //uniqueID sets new uniqueID to a lent book*/
	   public void setUniqueID()
	   {
			   Random rand = new Random();
			   int id = rand.nextInt((999999 - 100000) + 1) + 100000;
			   this.uniqueID = Integer.toString(id);
	   }

	   public void setReturnDate(Calendar c){
	   		this.returnDate = c;
	   }
	   public Calendar getReturnDate() {
		   return returnDate;
	   }

	   /** @return returns either true or false if a book is lent*/
	   public Boolean getLent()
	   {
	      return lent;
	   }

	   /** @param lent set whether a book is lent to tru or false*/
	   public void setLent(Boolean lent)
	   {
	      this.lent = lent;
	   }

	   public String toString() {
	   	if(returnDate == null) {
			return ("Title: " + title + " Author: " + author + " ISBN: " + ISBN);
		}
		else {return ("Title: " + title + " Author: " + author + " ISBN: " + ISBN + " due date: " + returnDate.toString());}
	   }

	   /** @param bookInfo the title author or isbn of a book being searched for
	    * @return book searched for*/
//	   public Book searchBook(String bookInfo){
//	      return getBooks().get(0);
//	}
}
