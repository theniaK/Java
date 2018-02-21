package Console;
import java.util.*;
import javax.swing.*;

/*
 * 
 * 	Πληροφορίες για την CommunityChest
 * 
 */

public class CommunityChest extends Square{		// Η κλάση CommunityChest είναι υποκλάση της Square
	
	private Card cardDrawn;														// Η κάρτα που έχει τραβήξει ο παίκτης
	private static ArrayList<Card> communityChestDeck = new ArrayList<Card>(); 	// Η στατική τράπουλα με τις κάρτες Απόφασης
	private static int cardCounter = 0;											// Ο στατικός μετρητής για να διατρέχουμε τις κάρτες

	// Η κατασκευάστρια μέθοδος της κλάσης CommunityChest. Δέχεται 2 ορίσματα (String, int)
	public CommunityChest (String aName , int aNumber){
		 super(aName,aNumber);		// Καλείται η κατασκευάστρια της υπερκλάσης
		 this.cardDrawn=null;		// Η τρέχουσα κάρτα αρχικοποιείται με την τιμή null
	}
	
	// Η μέθοδος αυτή ενεργοποιεί την κάρτα που έχει τραβήξει ο παίκτης ο οποίος δέχεται ως όρισμα
    public void chestActivate(Player unlucky){
    	cardDrawn = drawFromChest();			// Ο παίκτης τραβάει κάρτα απο την τράπουλα
		int type = cardDrawn.getcardType();		
		JOptionPane.showMessageDialog(null, cardDrawn.getcardText(), 
											cardDrawn.getcardName(), JOptionPane.OK_OPTION);
    	
		if (type==Card.ADD){							// Αν ο τύπος κάρτας είναι τύπου προσθήκης χρημάτων καλείται η AddMoney
			cardDrawn.addMoney(unlucky);	
		}
		else if (type==Card.DEDUCT){					// Αν ο τύπος κάρτας είναι τύπου αφαίρεσης χρημάτων καλείται η deductMoney
			cardDrawn.deductMoney(unlucky);
		}    
		else if (type==Card.MOVE){						// Αν ο τύπος κάρτας είναι τύπου μετακίνησης παίκτη καλείται η MovePlayer
			cardDrawn.movePlayer(unlucky);
		}
	}
    
	// Η στατική αυτή μέθοδος δέχεται μια κάρτα και την προσθέτει στην στατική τράπουλα με τις κάρτες Απόφασης
	public static void addCards(Card c){
		communityChestDeck.add(c);		
	}
	
    // Η μέθοδος αυτή ανακατέυει την τράπουλα Αποφάσεων
	public static void shuffleChest(){
		Collections.shuffle(communityChestDeck);
	}
	
	// Αυτή η μέθοδος τραβάει μια κάρτα από την τράπουλα των καρτών απόφασης. 
	public Card drawFromChest(){
		Card c = communityChestDeck.get(cardCounter); 
		cardCounter ++;
		
		if (cardCounter == communityChestDeck.size()){	//Αν η τράπουλα έχει τελειώσει, τραβάει ξανά την πρώτη καρτα.
			cardCounter=0;
		}
		return c; 	
	}
	
//GET METHODS
	
	//Επιστρέφει την κάρτα που τράβηξε ο παίκτης
	public Card getCardDrawn(){
		return cardDrawn;
	}
	
//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.COMMUNITY_CHEST; 
	}
}
	
	
	


