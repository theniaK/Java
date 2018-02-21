package Console;

/*
 * 
 * Πληροφορίες για την Tax
 * 
 */

public class Tax extends Square {	// Η κλάση Tax είναι υποκλάση της Square
	
	private int taxToPay;			// Ο φόρος που πληρώνει ο παίκτης
	
	// Η κατασκευάστρια μέθοδος της κλάσης Tax. Δέχεται 3 ορίσματα (String, int, int)
	public Tax(String aName, int aNumber, int taxToPay){
		super(aName, aNumber);		//Καλείται η κατασκευάστρια της υπερκλάσης	
		this.taxToPay = taxToPay;
	}
	
	// Η μέθοδος αυτή δέχεται έναν παίκτη και αφαιρεί από το κεφάλαιο του την μεταβλητή taxToPay
	public void payTax(Player unlucky){
			unlucky.setBalance(unlucky.getBalance()-taxToPay);	
	}
	
// GET METHODS
	
	// Επιστρέφει τον φόρο που πληρώνει ο παικτης
	public int getTaxToPay(){
		return taxToPay;
	}

//ABSTRACT METHODS	
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		 return Square.TAX;
	}
}
