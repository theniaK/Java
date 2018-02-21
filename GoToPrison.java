package Console;

/*
 * 
 * 	Πληροφορίες για την GoToPrison
 * 
 */

public class GoToPrison extends Square {	// Η κλάση GoToPrison είναι υποκλάση της Square
	
	// Η κατασκευάστρια μέθοδος της κλάσης GoToPrison. Δέχεται 2 ορίσματα (String, int)
	public GoToPrison (String aName , int aNumber){
	    super(aName , aNumber);		//Καλείται η κατασκευάστρια της υπερκλάσης
	}
	
	// Η μέθοδος αυτή δέχεται έναν παίκτη, τον μετακινεί στην φυλακή και θέτει την μεταβλητή inPrison του παίκτη σε true
	public void moveToPrison (Player unlucky){
		unlucky.setPosition(10); 	//Ο παίκτης μετακινείται στην φυλακή
		unlucky.setinPrison(true); 	//Ο παίκτης είναι πια φυλακισμένος
	}
	
//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.GO_TO_PRISON; 
	}
}
