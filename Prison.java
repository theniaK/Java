package Console;

/*
 * 
 * 	Πληροφορίες για την Prison
 * 
 */

public class Prison extends Square{		// Η κλάση Prison είναι υποκλάση της Square

	private int prisonFee = 50;			// Ο φόρος για να βγει ο πάικτης από την φυλακή
	
	// Η κατασκευάστρια μέθοδος της κλάσης Prison. Δέχεται 2 ορίσματα (String, int)
	public Prison (String aName ,int aNumber){
		super(aName,aNumber);			//Καλείται η κατασκευάστρια της υπερκλάσης
	}
	
	// Η μέθοδος αυτή αφαιρεί τον φόρο για να βγεί ο παίκτης από την φυλακή από το κεφάλαιο του
	public void payToBeFree(Player unlucky){
		unlucky.setBalance(unlucky.getBalance()-prisonFee);
    }

//GET METHODS
	
	// Επιστρέφει τον φόρο για να βγει ο παίκτης από την φυλακή
	public int getPrisonFee(){
		return prisonFee;
	}
	
//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.PRISON;
	}
}
	
	
