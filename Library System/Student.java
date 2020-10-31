import java.util.*;

public class Student extends Book implements java.io.Serializable
{
	private static ArrayList<Book> booksLent = new ArrayList<>();
	int penalties;
	private String name;
	private String username;
	private String password;


	/** @param //name is the name of the student provided for when creating a new student Account
	 * @param //password is the password that will be used in order for the student to login
	 * @param //username is the a personalized student account name in order for the student to login
	 * these will be used for identifying a student */
	public Student(String sName, String sUsername, String sPassword, ArrayList<Book> lent, int penalties)
	{
		name = sName;
		username = sUsername;
		password = sPassword;
		booksLent = lent;
	}
	public String getUsername()
	{
		return this.username;
	}
	public String getName(){
	    return this.name;
    }
	public String getPassword()
	{
		return this.password;
	}
	public static ArrayList<Book> getBooks()
	{
		FileReader.update();
		Collections.sort(booksLent, new Comparator<Book>()
		{
			public int compare(Book s1, Book s2) {
				return s1.getReturnDate().compareTo(s2.getReturnDate());
			} } );
		return booksLent;
	}
	public int getPenalties(){
		return this.penalties;
	}

	/**@param uniqueID you must enter the uniqueID given when being lent a book to return a book
	 * method to return a borrowed book*/
	public void returnBook(String uniqueID)
	{
		if (booksLent.size() > 0){
			for (int i = 0; i < booksLent.size(); i++){
				if (booksLent.get(i).getUniqueID().equals(uniqueID)){
					booksLent.get(i).setLent(false);
					booksLent.get(i).uniqueID = null;
                    booksLent.get(i).setReturnDate(null);
					System.out.println("Book successfully returned");
					this.booksLent.remove(i);
				}
			}
		}
		else
			{
			System.out.println("You have no books checked out.");
		}
	}

	public void setBooksLent(ArrayList<Book> b){
		booksLent = b;
	}
    public ArrayList<Book> getBooksLent(){
        return booksLent;
    }

	public static void main(String[] args)
	{

		}
	}


