package Console;

/*
 * 
 * 	Πληροφορίες για την Card
 * 
 */

public class  Card {
	
	private int cardNumber;			// Το ID της κάρτας
	private String cardName;		// Ο τίτλος της κάρτας
	private String cardText;		// Το κείμενο της κάρτας
	private int cardType; 			// Ο τύπος της κάρτας (ADD, DEDUCT, MOVE)
	private int plusMoney;			// Τα χρήματα προς είσπραξη
	private int minusMoney;			// Τα χρήματα προς πληρωμή
	private int movePlayerPosition;	// Η θέση για μετακίνηση του παίκτη
	
	// Δήλωση σταθερών που θα βοηθήσουν στων διαχωρισμό του είδους των καρτών
	public static final int ADD = 1; 
	public static final int DEDUCT = 2;
	public static final int MOVE = 3;
	
	// Η κατασκευάστρια μέθοδος της κλάσης Card. Δέχεται 7 ορίσματα (int, String, String, int, int, int, int)
	public Card (int cNumber ,String cName ,String cText ,int cType, int plusMoney , int minusMoney , int movePlayerPosition){
		  this.cardNumber=cNumber;
		  this.cardName=cName;
		  this.cardText=cText;
		  this.cardType=cType;
		  this.plusMoney=plusMoney;
		  this.minusMoney=minusMoney;
		  this.movePlayerPosition=movePlayerPosition;	
	}
	
	// Η μέθοδος αυτή μετακινεί τον παίκτη που δέχεται ως όρισμα στην θέση movePlayerPosition
	public void movePlayer(Player unlucky){ 
		unlucky.setPosition(movePlayerPosition);	 
	}
	
	// Η μέθοδος αυτή προσθέτει στο κεφάλαιο του παίκτη που δέχεται ως όρισμα την μεταβλητή plusMoney
	public void addMoney(Player unlucky){
		unlucky.setBalance(unlucky.getBalance() + plusMoney);	 
	}
	
	// Η μέθοδος αυτή αφαιρεί από το κεφάλαιο του παίκτη που δέχεται ως όρισμα την μεταβλητή deductMoney
	public void deductMoney(Player unlucky){
		unlucky.setBalance(unlucky.getBalance() - minusMoney);
	}
	
//GET METHODS
	
	//Επιστρέφει το κείμενο της κάρτας
	public String getcardText (){
		return(cardText);	
	}
	
	// Επιστρέφει το όνομα της κάρτας
	public String getcardName(){
		return(cardName);
	}
	// Επιστρέφει τον τύπο της κάρτας
	public int getcardType(){
		return cardType;
	}		
	
	//Επιστρέφει την Θέση που θα μετακινηθεί ο παίκτης
	public int getmovePlayerPosition(){
		return movePlayerPosition;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	


