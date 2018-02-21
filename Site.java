package Console;
import javax.swing.*;

/*
 * 
 * 	Πληροφορίες για την Site
 * 
 */

public class Site extends Square{	// Η κλάση Site είναι υποκλάση της Square
	
	private String siteColor;		// Το χρώμα του οικοπέδου
	private int siteLvl;			// Το επίπεδο του οικοπέδου
	private int siteBuyPrice;		// Η τιμή αγοράς του οικοπέδου
	private int siteRentLvl0;		// Αντίτιμο παραμονής για οικόπεδο επιπέδου 0 
	private int siteRentLvl1;		// Αντίτιμο παραμονής για οικόπεδο επιπέδου 1
	private int siteRentLvl2;		// Αντίτιμο παραμονής για οικόπεδο επιπέδου 2
	private int siteRentLvl3;		// Αντίτιμο παραμονής για οικόπεδο επιπέδου 3
	private int buildPrice;			// Τιμή επένδυσης οικοπέδου στο επόμενο επίπεδο
	private boolean hasOwner; 		// Λογική μεταβλητή οπου αποθηκεύεται το εάν το οικόπεδο έχει ιδιοκτήτη
	private Player owner;			// Ο ιδιοκτήτης του οικοπέδου
	
	// Η κατασκευάστρια μέθοδος της κλάσης Site. Δέχεται 9 ορίσματα (String, int, int, int, int, int, int, int, int)
	public Site(String name, int number, String siteColor, int siteBuyPrice, 
				int siteRentLvl0, int siteRentLvl1, int siteRentLvl2, int siteRentLvl3, int buildPrice){
		
		super(name,number);					//Καλείται η κατασκευάστρια της υπερκλάσης
		this.siteColor = siteColor;
		this.siteLvl = 0;
		this.siteBuyPrice = siteBuyPrice;
		this.siteRentLvl0 = siteRentLvl0;
		this.siteRentLvl1 = siteRentLvl1;
		this.siteRentLvl2 = siteRentLvl2;
		this.siteRentLvl3 = siteRentLvl3;
		this.buildPrice = buildPrice;
		this.hasOwner = false; 				//όταν κατασκευάζονται, τα Οικόπεδα δεν έχουν ιδιοκτήτη
		
	}
	
	// Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος πληρώνει ενοίκιο στον ιδιοκτήτη
	public void payRent(Player unlucky){
		int site_rent = getSiteRentLvl(siteLvl);
		JOptionPane.showMessageDialog(null, owner.getName() + " has this site.\nYou pay " + site_rent +" euros", 
											squareName, JOptionPane.WARNING_MESSAGE);
		unlucky.setBalance(unlucky.getBalance() - site_rent);		//Το ενοίκιο αφαιρείται από τον παίκτη
		owner.setBalance( owner.getBalance() + site_rent);			//Το ενοίκιο προστίθεται στον ιδιοκτήτη
	}
	 
	// Η μέθοδος αυτή χτίζει το οικόπεδο στο επόμενο επίπεδο
	public void buildSiteToNextLvl(){ 
		if(owner.getBalance() > buildPrice && siteLvl<3){		/* Μόνο εάν ο παίκτης έχει τα χρήματα να χτίσει ή το επίπεδο του 
													 			   οικοπέδου είναι μικρότερο του 3 επιτρέπεται να χτίσει ο παικτης */        
			siteLvl ++;
			owner.setBalance(owner.getBalance()- buildPrice);	// Ο παίκτης πληρώνει για να χτίσει
		}	 
	}								 
	 
	//Η μέθοδος αυτή δέχεται έναν παίκτη ο οποίος και αγοράζει το οικόπεδο
	public void buySite(Player buyer){
		if(buyer.getBalance()>this.siteBuyPrice){					// Ο πάικτης πρέπει να έχει αρκετά χρήματα για να αγοράσει το οικόπεδο
			buyer.setBalance(buyer.getBalance()- siteBuyPrice);		// Αφαιρείται η τιμή αγοράς από το κεφάλαιο του παίκτη
		 	setOwner(buyer);										// Ορίζεται ως ιδιοκτήτης της υπηρεσίας ο buyer
		 	hasOwner = true;										// Το οικόπεδο αποκτά ιδιοκτήτη
		 	buyer.addProperty(this);								// Το οικόπεδο προστίθεται στις ιδιοκτησίες του buyer
		 	JOptionPane.showMessageDialog(null, "You just bought " + squareName,
		 										squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else{														// Ο πάικτης δεν έχει αρκετά χρήματα για να αγοράσει το οικόπεδο
			JOptionPane.showMessageDialog(null, "You don't have the money to buy this Site.",
												squareName, JOptionPane.OK_OPTION);
		}
	}
	
//GET METHODS
	
	//H μέθοδος αυτή επιστρέφει το ενοίκιο του οικοπέδου ανάλογα το επίπεδό του
	public int getSiteRentLvl(int lvl){
		int rent = 0;
		switch (lvl) {
		case 0: rent = siteRentLvl0; break;
		case 1: rent = siteRentLvl1; break;
		case 2: rent = siteRentLvl2; break;
		case 3: rent = siteRentLvl3; break;
		}
		return rent;
	}
	
	//Επιστρέφει το χρώμα του οικοπέδου
	public String getSiteColor(){
		return siteColor;
	}
	
	//Επιστρέφει το επίπεδο του οικοπέδου
	public int getSiteLvl(){
		return siteLvl;
	}
	
	//Επιστρέφει το εάν η υπηρεσία έχει ιδιοκτήτη η όχι
	public boolean isFree(){
		return !hasOwner;
	}
	
	//Επιστρέφει την τιμή επένδυσης του οικοπέδου
	public int getbuildPrice(){
		return buildPrice;
	}
	
	//Επιστρέφει την τιμή αγοράς του οικοπέδου
	public int getsiteBuyPrice(){
		return siteBuyPrice;
	}
	
	//Επιστρέφει τον ιδιοκτήτη του οικοπέδου
	public Player getowner(){
		return owner;
	}
	
//SET METHODS
	
	//Θέτει ώς ιδιοκτήτη του οικοπέδου τον buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}

//ABSTRACT METHODS
	
	// Επιστρέφει μία σταθερά της Square ανάλογα την κάθε υποκλάση που υλοποιείται
	public int returnType(){
		return Square.SITE;		 
	}
}
