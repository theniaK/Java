package Console;

/*
 * 
 * 	Πληροφορίες για την FreeParking
 * 
 */

public class FreeParking extends Square{	// Η κλάση FreeParking είναι υποκλάση της Square
	
	// Η κατασκευάστρια μέθοδος της κλάσης FreeParking. Δέχεται 2 ορίσματα (String, int)
	public FreeParking(String aName , int aNumber){
		super(aName ,aNumber);		//Καλείται η κατασκευάστρια της υπερκλάσης
	}
	
//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.FREE_PARKING;
	}
}
