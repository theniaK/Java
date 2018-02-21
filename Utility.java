package Console;
import javax.swing.*;

/*
 * 
 *  ����������� ��� ��� Utility
 * 
 */

public class Utility extends Square{		//� ����� Utility ����� �������� ��� Square
	
	private int utilityBuyPrice;			//� ���� ������ ��� ���������
	private int	utilityMultiplierOwning1 ;	//��������������� ��� ������ ��� ������ ���� ���� ��� �������� 
	private int	utilityMultiplierOwning2; 	//��������������� ��� ������ ��� ������ ���� ���� ��� ��������� 
	private boolean hasOwner; 				//������ ��������� ���� ������������ �� ��� � �������� ���� ���������
	private Player owner;   				//� ���������� ��� ���������
	
	// � �������������� ������� ��� ������ Utility. ������� 5 �������� (String, int, int, int, int)
	public Utility(String name, int number, int utilityBuyPrice, int utilityMultiplierOwning1, int utilityMultiplierOwning2){
		super(name,number);											//�������� � �������������� ��� ����������	
		this.utilityBuyPrice = utilityBuyPrice;
		this.utilityMultiplierOwning1 = utilityMultiplierOwning1;
		this.utilityMultiplierOwning2 = utilityMultiplierOwning2;
		this.hasOwner = false; 										//���� ���������������, �� ��������� ��� ����� ���������
	}
	
	// � ������� ���� ������� ���� ������ � ������ �������� ������� ���� ���������
	public void payRent(Player unlucky){
		int utility_rent = 0;			//�� ������� ��� ���������
		if (owner.getUtilityCount() ==1){
			utility_rent = unlucky.getPlayersDice() * utilityMultiplierOwning1;
		}
		else if (owner.getUtilityCount() ==2){
			utility_rent = unlucky.getPlayersDice() * utilityMultiplierOwning2;
		}
		unlucky.setBalance(unlucky.getBalance()- utility_rent);		//�� ������� ���������� ��� ��� ������
		owner.setBalance(owner.getBalance()+ utility_rent);			//�� ������� ����������� ���� ���������
		JOptionPane.showMessageDialog(null, owner.getName() + " has this Utility.\nYou pay " + utility_rent +" euros",
									  squareName, JOptionPane.WARNING_MESSAGE);
	}
	
	//� ������� ���� ������� ���� ������ � ������ ��� �������� ��� ��������
	public void buyUtility(Player buyer){
		 
		if(buyer.getBalance()>this.utilityBuyPrice){				// � ������� ������ �� ���� ������ ������� ��� �� �������� ��� ��������
			buyer.setBalance(buyer.getBalance()- utilityBuyPrice);	// ���������� � ���� ������ ��� �� �������� ��� ������
		 	setOwner(buyer);										// �������� �� ���������� ��� ��������� � buyer
		 	hasOwner = true;										// � �������� ������ ���������
		 	buyer.addProperty(this);								// � ���������� ����������� ���� ����������� ��� buyer
		 	buyer.addUtilityCount();								// � ������� ������� ��� ��������� ��� ���� 1
		 	JOptionPane.showMessageDialog(null, "You just bought " + squareName, 
		 										squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else{														// � ������� ��� ���� ������ ������� ��� �� �������� ��� ��������
			JOptionPane.showMessageDialog(null, "You don't have the money to buy this Utility.", 
												squareName, JOptionPane.OK_OPTION);
		}
	}
	
//GET METHODS
	
	//���������� ��� ��������� ��� ���������
	public Player getowner(){
		return owner;
	}
	
	//���������� ��� ���� ������ ��� ���������
	public int getUtilityBuyPrice(){
		return utilityBuyPrice;
	}
	
	//���������� �� ��� � �������� ���� ��������� � ���
	public boolean isFree(){
		return !hasOwner;
	}
	
//SET METHODS
	
	//����� �� ��������� ��� ��������� ��� buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}
	
//ABSTRACT METHODS	
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		 return Square.UTILITY;
	}
}
