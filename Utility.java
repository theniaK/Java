package Console;
import javax.swing.*;

/*
 * 
 *  Πληροφορίες για την Utility
 * 
 */

public class Utility extends Square{		//Η κλάση Utility είναι υποκλάση της Square
	
	private int utilityBuyPrice;			//Η τιμή αγοράς της υπηρεσίας
	private int	utilityMultiplierOwning1 ;	//πολλαπλασιαστές της ζαριάς του παίκτη όταν έχει μία υπηρεσία 
	private int	utilityMultiplierOwning2; 	//πολλαπλασιαστές της ζαριάς του παίκτη όταν έχει δύο υπηρεσίες 
	private boolean hasOwner; 				//Λογική μεταβλητή οπου αποθηκεύεται το εάν η υπηρεσία έχει ιδιοκτήτη
	private Player owner;   				//Ο ιδιοκτήτης της υπηρεσίας
	
	// Η κατασκευάστρια μέθοδος της κλάσης Utility. Δέχεται 5 ορίσματα (String, int, int, int, int)
	public Utility(String name, int number, int utilityBuyPrice, int utilityMultiplierOwning1, int utilityMultiplierOwning2){
		super(name,number);											//Καλείται η κατασκευάστρια της υπερκλάσης	
		this.utilityBuyPrice = utilityBuyPrice;
		this.utilityMultiplierOwning1 = utilityMultiplierOwning1;
		this.utilityMultiplierOwning2 = utilityMultiplierOwning2;
		this.hasOwner = false; 										//όταν κατασκευάζονται, οι υπηρεσίες δεν έχουν ιδιοκτήτη
	}
	
	// Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος πληρώνει ενοίκιο στον ιδιοκτήτη
	public void payRent(Player unlucky){
		int utility_rent = 0;			//Το ενοίκιο της υπηρεσίας
		if (owner.getUtilityCount() ==1){
			utility_rent = unlucky.getPlayersDice() * utilityMultiplierOwning1;
		}
		else if (owner.getUtilityCount() ==2){
			utility_rent = unlucky.getPlayersDice() * utilityMultiplierOwning2;
		}
		unlucky.setBalance(unlucky.getBalance()- utility_rent);		//Το ενοίκιο αφαιρείται από τον παίκτη
		owner.setBalance(owner.getBalance()+ utility_rent);			//Το ενοίκιο προστίθεται στον ιδιοκτήτη
		JOptionPane.showMessageDialog(null, owner.getName() + " has this Utility.\nYou pay " + utility_rent +" euros",
									  squareName, JOptionPane.WARNING_MESSAGE);
	}
	
	//Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος και αγοράζει την υπηρεσία
	public void buyUtility(Player buyer){
		 
		if(buyer.getBalance()>this.utilityBuyPrice){				// Ο πάικτης πρέπει να έχει αρκετά χρήματα για να αγοράσει την υπηρεσία
			buyer.setBalance(buyer.getBalance()- utilityBuyPrice);	// Αφαιρείται η τιμή αγοράς από το κεφάλαιο του παίκτη
		 	setOwner(buyer);										// Ορίζεται ως ιδιοκτήτης της υπηρεσίας ο buyer
		 	hasOwner = true;										// Η υπηρεσία αποκτά ιδιοκτήτη
		 	buyer.addProperty(this);								// Η Ιδιοκτησία προστίθεται στις ιδιοκτησίες του buyer
		 	buyer.addUtilityCount();								// Ο παίκτης αυξάνει τις υπηρεσίες του κατα 1
		 	JOptionPane.showMessageDialog(null, "You just bought " + squareName, 
		 										squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else{														// Ο πάικτης δεν έχει αρκετά χρήματα για να αγοράσει την υπηρεσία
			JOptionPane.showMessageDialog(null, "You don't have the money to buy this Utility.", 
												squareName, JOptionPane.OK_OPTION);
		}
	}
	
//GET METHODS
	
	//Επιστρέφει τον ιδιοκτήτη της υπηρεσίας
	public Player getowner(){
		return owner;
	}
	
	//Επιστρέφει την τιμή αγοράς της υπηρεσίας
	public int getUtilityBuyPrice(){
		return utilityBuyPrice;
	}
	
	//Επιστρέφει το εάν η υπηρεσία έχει ιδιοκτήτη η όχι
	public boolean isFree(){
		return !hasOwner;
	}
	
//SET METHODS
	
	//Θέτει ως ιδιοκτήτη της υπηρεσίας τον buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}
	
//ABSTRACT METHODS	
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		 return Square.UTILITY;
	}
}
