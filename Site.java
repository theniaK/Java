package Console;
import javax.swing.*;

/*
 * 
 * 	����������� ��� ��� Site
 * 
 */

public class Site extends Square{	// � ����� Site ����� �������� ��� Square
	
	private String siteColor;		// �� ����� ��� ���������
	private int siteLvl;			// �� ������� ��� ���������
	private int siteBuyPrice;		// � ���� ������ ��� ���������
	private int siteRentLvl0;		// �������� ��������� ��� �������� �������� 0 
	private int siteRentLvl1;		// �������� ��������� ��� �������� �������� 1
	private int siteRentLvl2;		// �������� ��������� ��� �������� �������� 2
	private int siteRentLvl3;		// �������� ��������� ��� �������� �������� 3
	private int buildPrice;			// ���� ��������� ��������� ��� ������� �������
	private boolean hasOwner; 		// ������ ��������� ���� ������������ �� ��� �� �������� ���� ���������
	private Player owner;			// � ���������� ��� ���������
	
	// � �������������� ������� ��� ������ Site. ������� 9 �������� (String, int, int, int, int, int, int, int, int)
	public Site(String name, int number, String siteColor, int siteBuyPrice, 
				int siteRentLvl0, int siteRentLvl1, int siteRentLvl2, int siteRentLvl3, int buildPrice){
		
		super(name,number);					//�������� � �������������� ��� ����������
		this.siteColor = siteColor;
		this.siteLvl = 0;
		this.siteBuyPrice = siteBuyPrice;
		this.siteRentLvl0 = siteRentLvl0;
		this.siteRentLvl1 = siteRentLvl1;
		this.siteRentLvl2 = siteRentLvl2;
		this.siteRentLvl3 = siteRentLvl3;
		this.buildPrice = buildPrice;
		this.hasOwner = false; 				//���� ���������������, �� �������� ��� ����� ���������
		
	}
	
	// � ������� ���� ������� ���� ������ � ������ �������� ������� ���� ���������
	public void payRent(Player unlucky){
		int site_rent = getSiteRentLvl(siteLvl);
		JOptionPane.showMessageDialog(null, owner.getName() + " has this site.\nYou pay " + site_rent +" euros", 
											squareName, JOptionPane.WARNING_MESSAGE);
		unlucky.setBalance(unlucky.getBalance() - site_rent);		//�� ������� ���������� ��� ��� ������
		owner.setBalance( owner.getBalance() + site_rent);			//�� ������� ����������� ���� ���������
	}
	 
	// � ������� ���� ������ �� �������� ��� ������� �������
	public void buildSiteToNextLvl(){ 
		if(owner.getBalance() > buildPrice && siteLvl<3){		/* ���� ��� � ������� ���� �� ������� �� ������ � �� ������� ��� 
													 			   ��������� ����� ��������� ��� 3 ����������� �� ������ � ������� */        
			siteLvl ++;
			owner.setBalance(owner.getBalance()- buildPrice);	// � ������� �������� ��� �� ������
		}	 
	}								 
	 
	//� ������� ���� ������� ���� ������ � ������ ��� �������� �� ��������
	public void buySite(Player buyer){
		if(buyer.getBalance()>this.siteBuyPrice){					// � ������� ������ �� ���� ������ ������� ��� �� �������� �� ��������
			buyer.setBalance(buyer.getBalance()- siteBuyPrice);		// ���������� � ���� ������ ��� �� �������� ��� ������
		 	setOwner(buyer);										// �������� �� ���������� ��� ��������� � buyer
		 	hasOwner = true;										// �� �������� ������ ���������
		 	buyer.addProperty(this);								// �� �������� ����������� ���� ����������� ��� buyer
		 	JOptionPane.showMessageDialog(null, "You just bought " + squareName,
		 										squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else{														// � ������� ��� ���� ������ ������� ��� �� �������� �� ��������
			JOptionPane.showMessageDialog(null, "You don't have the money to buy this Site.",
												squareName, JOptionPane.OK_OPTION);
		}
	}
	
//GET METHODS
	
	//H ������� ���� ���������� �� ������� ��� ��������� ������� �� ������� ���
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
	
	//���������� �� ����� ��� ���������
	public String getSiteColor(){
		return siteColor;
	}
	
	//���������� �� ������� ��� ���������
	public int getSiteLvl(){
		return siteLvl;
	}
	
	//���������� �� ��� � �������� ���� ��������� � ���
	public boolean isFree(){
		return !hasOwner;
	}
	
	//���������� ��� ���� ��������� ��� ���������
	public int getbuildPrice(){
		return buildPrice;
	}
	
	//���������� ��� ���� ������ ��� ���������
	public int getsiteBuyPrice(){
		return siteBuyPrice;
	}
	
	//���������� ��� ��������� ��� ���������
	public Player getowner(){
		return owner;
	}
	
//SET METHODS
	
	//����� �� ��������� ��� ��������� ��� buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}

//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		return Square.SITE;		 
	}
}
