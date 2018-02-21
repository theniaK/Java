package Console;

/*
 * 
 *  Πληροφορίες για την Start
 * 
 */

public class Start extends Square{  // Η κλάση Start είναι υποκλάση της Square
	
	// Κατασκευάστρια μέθοδος της κλάσης Start. Δέχεται 2 ορίσματα (String, int)
	public Start (String aName , int aNumber){
		super(aName,aNumber);		//Καλείται η κατασκευάστρια της υπερκλάσης	
	}
	
//ABSTRACT METHODS		
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.START;
	}
}
