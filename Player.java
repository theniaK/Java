package Console;
import java.util.*;

/*
 * 
 * 	Πληροφορίες για την Player
 * 
 */

public class Player {
	
	private String playerName;												// Το όνομα του παίκτη
	private int playerID;													// Το ID του παίκτη
	private int playerBalance;												// Το κεφάλαιο του παίκτη
	private ArrayList<Square> playerProperties = new ArrayList<Square>();	// Η λίστα με τις ιδιοκτησίες του παίκτη
	private int playerPosition;												// Η θέση του παίκτη
	private boolean inPrison;												// Λογική μεταβλητή που δείχνει εάν ο παίκτης είναι φυλακισμένος
	private boolean bankrupt;												// Λογική μεταβλητή που δείχνει εάν ο παίκτης έχει χρεωκοπήσει
	private int playersDice;												// Η τιμή των ζαριών του παίκτη
	private int currentAirfield;											// Πόσα αεροδρόμια έχει ο παίκτης
	private int currentUtility;												// Πόσες υπηρεσίες έχει ο παίκτης
	private int pawnNumber;													// Το ID του πιονιού του κάθε παίκτη
	
	// Η κατασκευάστρια της κλάσης Player. Δέχεται 2 ορίσματα (String, int)
	public Player(String plName, int plID){
		playerName = plName;
		playerID = plID;
		playerBalance = 1500;		// Το αρχικό ποσό του παίκτη είναι 1500 ευρώ
		playerPosition = 0;			// Η αρχική θέση του πάικτη είναι στην αφετηρία
		inPrison = false;			// Ο παίκτης αρχίζει το παιχνίδι ελεύθερος
		bankrupt = false;			// Ο παίκτης αρχίζει το παιχνίδι μη χρεωκοπημένος
		playersDice = 0;			// Η αρχική ζαριά του παίκτη είναι 0
		currentAirfield = 0;		// Ο παίκτης αρχίζει το παιχνίδι χωρίς κανένα αεροδρόμιο
		currentUtility = 0;			// Ο παίκτης αρχίζει το παιχνίδι χωρίς καμία υπηρεσία
		pawnNumber = plID;			/* Στο ID του πιονιού αποθηκεύεται το ID του παίκτη. Καθώς οι παίκτες χρεωκοπούν,
									   το ID τους αλλάζει αλλά το pawnNumber τους όχι. Έτσι διατηρούν την κυριότητα
									   των πιονιών που είχαν στην αρχή του παιχνιδιού, με τα σωστά χρώματα.			 */
	}
	
	// Η μέθοδος αυτή ελέγχει αν έχει χρεωκοπήσει ο παίκτης ανάλογα με το κεφάλαιό του
	public boolean checkBankrupt(){
		if (playerBalance<0){
			this.bankrupt = true;	// Αν ο παίκτης έχει χρεωκοπήσει, η μεταβλητή του bankrupt γίνεται true
			return true;
		}
		else
			return false;
	}
	
	// Η μέθοδος αυτή αυξάνει τα αεροδρόμια του παίκτη κατα 1
	public void addAirfieldCount(){
		currentAirfield ++;
	}
	// Η μέθοδος αυτή αυξάνει τις υπηρεσίες του παίκτη κατα 1
	public void addUtilityCount(){
		currentUtility++;
	}
	
	// Η μέθοδος αυτή προσθέτει μια ιδιοκτησία στην λίστα του παίκτη
	public void addProperty(Square sq){
		playerProperties.add(sq);
	}
	
//GET METHODS
	
	public int getPawnNumber(){
		return pawnNumber;
	}

	// Επιστρέφει το όνομα του παίκτη
	public String getName(){
		return playerName;
	}
	
	// Επιστρέφει το κεφάλαιο του παίκτη
	public int getBalance(){
		return playerBalance;
	}
	
	// Επιστρέφει το ζάρι του παίκτη
	public int getPlayersDice(){
		return playersDice;
	}
	
	// Επιστρέφει το εάν ο πάικτης έχει χρεωκοπήσει ή όχι
	public boolean isBankrupt(){
		return bankrupt;
	}
	
	// Επιστρέφει τον μετρήτή των αεροδρομίων του παίκτη
	public int getAirfieldCount(){
		return currentAirfield;
	}
	
	// Επιστρέφει τον μετρητή των υπηρεσιών του παίκτη
	public int getUtilityCount(){
		return currentUtility;
	}
	
	// Επιστρέφει την θέση του παίκτη
	public int getPosition(){
		return playerPosition;
	}
	
	// Επιστρέφει το εάν ο παίκτης είναι φυλακισμένος
	public boolean isInPrison(){
		return inPrison;
	}
	
	// Επιστρέφει την λίστα με τις ιδιοκτησίες του παίκτη
	public ArrayList<Square> getPlayerProperties(){
		return playerProperties;
	}
	
	// Επιστρέφει το ID του παίκτη
	public int getPlayerID(){
		return playerID;
	}
	
//SET METHODS
	
	public void setPlayerID(int id){
		playerID = id;
	}
	
	// Θέτει το ζάρι του πάιχτη ίσο με το όρισμα που δέχεται
	public void setPlayersDice(int diceNumber){
		playersDice = diceNumber;
	}
	
	// Θέτει το κεφάλαιο του παίκτη ίσο με το όρισμα που δέχεται
	public void setBalance(int balance){
		playerBalance = balance;
	}
	
	// Θέτει την θέση του παίκτη ίση με το όρισμα που δέχεται
	public void setPosition(int position){
		playerPosition = position;
	}
	
	// Αλλάζει την μεταβλητή inPrison του παίκτη ανάλογα με το όρισμα που δέχεται
	public void setinPrison(boolean inPrison){
		this.inPrison = inPrison;
	}
}
