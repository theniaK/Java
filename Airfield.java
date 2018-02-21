package Console;
import javax.swing.*;

/*
 * 
 * 	Πληροφορίες για την Airfield
 * 
 */

public class Airfield extends Square {	// Η κλάση Airfield είναι υποκλάση της Square
	
	private int airfieldBuyPrice;		// Η τιμή αγοράς του αεροδρομίου
	private int	airfieldRentOwning1; 	// Ενοίκιο εάν ο ιδιοκτήτης του αεροδρομίου έχει 1 αεροδρόμιο
	private int	airfieldRentOwning2;	// Ενοίκιο παραμονής εάν ο ιδιοκτήτης του αεροδρομίου έχει 2 αεροδρόμια
	private int airfieldRentOwning3; 	// Ενοίκιο παραμονής εάν ο ιδιοκτήτης του αεροδρομίου έχει 3 αεροδρόμια
	private int airfieldRentOwning4; 	// Ενοίκιο παραμονής εάν ο ιδιοκτήτης του αεροδρομίου έχει 4 αεροδρόμια
	private boolean hasOwner; 			// Λογική μεταβλητή οπου αποθηκεύεται το εάν το αεροδρόμιο έχει ιδιοκτήτη
	private Player owner;   			// Ο ιδιοκτήτης του αεροδρομίου
	
	// Η κατασκευάστρια μέθοδος της κλάσης Airfield. Δέχεται 7 ορίσματα (String, int, int, int, int, int, int)
	public Airfield (String name, int number, int airfieldBuyPrice, 
					int airfieldRentOwning1, int airfieldRentOwning2, int airfieldRentOwning3, int airfieldRentOwning4){
		
		super(name, number);							//Καλείται η κατασκευάστρια της υπερκλάσης
		this.airfieldBuyPrice = airfieldBuyPrice;
		this.airfieldRentOwning1 = airfieldRentOwning1;
		this.airfieldRentOwning2 = airfieldRentOwning2;
		this.airfieldRentOwning3 = airfieldRentOwning3;
		this.airfieldRentOwning4 = airfieldRentOwning4;
		this.hasOwner = false; 							//όταν κατασκευάζονται, τα Αεροδρόμια δεν έχουν ιδιοκτήτη
		
	}
	
	// Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος πληρώνει ενοίκιο στον ιδιοκτήτη
	public void payRent(Player unlucky){
		 int airfield_rent = 0;						
		 switch (owner.getAirfieldCount()){
		 	case 1: airfield_rent = airfieldRentOwning1; break;
		 	case 2: airfield_rent = airfieldRentOwning2; break;
		 	case 3: airfield_rent = airfieldRentOwning3; break;
		 	case 4: airfield_rent = airfieldRentOwning4; break;
		 }
		JOptionPane.showMessageDialog(null, owner.getName()+" has this Airfield.\nYou pay "+ airfield_rent +" euros.",
				 							squareName, JOptionPane.WARNING_MESSAGE);
		unlucky.setBalance(unlucky.getBalance()- airfield_rent);	//Το ενοίκιο αφαιρείται από τον παίκτη
		owner.setBalance(owner.getBalance()+ airfield_rent);  		//Το ενοίκιο προστίθεται στον ιδιοκτήτη 
	}
	
	//Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος και αγοράζει το αεροδρόμιο
	public void buyAirfield(Player buyer){ 
		if (buyer.getBalance() > airfieldBuyPrice){					// Ο πάικτης πρέπει να έχει αρκετά χρήματα για να αγοράσει το αεροδρόμιο
			buyer.setBalance(buyer.getBalance()- airfieldBuyPrice);	// Αφαιρείται η τιμή αγοράς από το κεφάλαιο του παίκτη
			setOwner(buyer);										// Ορίζεται ως ιδιοκτήτης της υπηρεσίας ο buyer
			hasOwner = true;										// Το αεροδρόμιο αποκτά ιδιοκτήτη
			buyer.addProperty(this);								// Το αεροδρόμιο προστίθεται στις ιδιοκτησίες του buyer
			buyer.addAirfieldCount();								// Ο παίκτης αυξάνει τα αεροδρόμια του κατα 1
			JOptionPane.showMessageDialog(null, "You just bought " + squareName,
												squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else 														// Ο πάικτης δεν έχει αρκετά χρήματα για να αγοράσει την υπηρεσία
			JOptionPane.showConfirmDialog(null, "You don't have the money to buy this Airfield.", 
												 squareName, JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
	}
	
//GET METHODS
	
	// Επιστρέφει τον ιδιοκτήτη του αεροδρομίου
	public Player getowner(){
		return owner;
	}
	
	// Επιστρέφει το εάν το αεροδρόμιο έχει ιδιοκτήτη η όχι
	public boolean isFree(){
		return !hasOwner;
	}
	
	// Επιστρέφει την τιμή αγοράς του αεροδρομίου
	public int getAirfieldBuyPrice(){
		return airfieldBuyPrice;
	}
	
//SET METHODS
	
	// Θέτει ως ιδιοκτήτη του αεροδρομίου τον buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}
	
//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		 return Square.AIRFIELD;
	 }
}
