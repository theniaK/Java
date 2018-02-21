package Console;

/*
 * 
 *  Πληροφορίες για την Square
 * 
 */

public abstract class Square {
	
	protected String squareName;  //Το όνομα του τετραγώνου
	protected int squareNumber;   //Το χαρακτηριστικό ID του τετραγώνου
	
	// Δήλωση σταθερών που θα βοηθήσουν στων διαχωρισμό των τετραγώνων σε διαφορετικά είδη
	public static final int START = 0;
	public static final int SITE = 1;
	public static final int UTILITY = 2;
	public static final int AIRFIELD = 3;
	public static final int COMMUNITY_CHEST = 4;
	public static final int CHANCE = 5;
	public static final int TAX = 6;
	public static final int FREE_PARKING = 7;
	public static final int PRISON = 8;
	public static final int GO_TO_PRISON = 9;
	
	// Κατασκευάστρια μέθοδος της κλάσης Square. Δέχεται 2 ορίσματα (String, int)
	public Square(String sqName, int sqNumber){
		squareName = sqName;
		squareNumber = sqNumber;
	}
	
//GET METHODS
	
	//Επιστρέφει το όνομα του τετραγώνου
	public String getsquareName(){
		return squareName;
	}
	
	//Επιστρέφει το χαρακτιριστικό ID του τετραγώνου
	public int getsquareNumber(){
		return squareNumber;
	}
	
//ABSTRACT METHODS	
	
	//Abstract μέθοδος που χρησιμοποιείται για τον διαχωρισμό των υποκλάσεων της Square
	public abstract int returnType();
}
