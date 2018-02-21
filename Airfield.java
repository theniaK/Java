package Console;
import javax.swing.*;

/*
 * 
 * 	����������� ��� ��� Airfield
 * 
 */

public class Airfield extends Square {	// � ����� Airfield ����� �������� ��� Square
	
	private int airfieldBuyPrice;		// � ���� ������ ��� �����������
	private int	airfieldRentOwning1; 	// ������� ��� � ���������� ��� ����������� ���� 1 ����������
	private int	airfieldRentOwning2;	// ������� ��������� ��� � ���������� ��� ����������� ���� 2 ����������
	private int airfieldRentOwning3; 	// ������� ��������� ��� � ���������� ��� ����������� ���� 3 ����������
	private int airfieldRentOwning4; 	// ������� ��������� ��� � ���������� ��� ����������� ���� 4 ����������
	private boolean hasOwner; 			// ������ ��������� ���� ������������ �� ��� �� ���������� ���� ���������
	private Player owner;   			// � ���������� ��� �����������
	
	// � �������������� ������� ��� ������ Airfield. ������� 7 �������� (String, int, int, int, int, int, int)
	public Airfield (String name, int number, int airfieldBuyPrice, 
					int airfieldRentOwning1, int airfieldRentOwning2, int airfieldRentOwning3, int airfieldRentOwning4){
		
		super(name, number);							//�������� � �������������� ��� ����������
		this.airfieldBuyPrice = airfieldBuyPrice;
		this.airfieldRentOwning1 = airfieldRentOwning1;
		this.airfieldRentOwning2 = airfieldRentOwning2;
		this.airfieldRentOwning3 = airfieldRentOwning3;
		this.airfieldRentOwning4 = airfieldRentOwning4;
		this.hasOwner = false; 							//���� ���������������, �� ���������� ��� ����� ���������
		
	}
	
	// � ������� ���� ������� ���� ������ � ������ �������� ������� ���� ���������
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
		unlucky.setBalance(unlucky.getBalance()- airfield_rent);	//�� ������� ���������� ��� ��� ������
		owner.setBalance(owner.getBalance()+ airfield_rent);  		//�� ������� ����������� ���� ��������� 
	}
	
	//� ������� ���� ������� ���� ������ � ������ ��� �������� �� ����������
	public void buyAirfield(Player buyer){ 
		if (buyer.getBalance() > airfieldBuyPrice){					// � ������� ������ �� ���� ������ ������� ��� �� �������� �� ����������
			buyer.setBalance(buyer.getBalance()- airfieldBuyPrice);	// ���������� � ���� ������ ��� �� �������� ��� ������
			setOwner(buyer);										// �������� �� ���������� ��� ��������� � buyer
			hasOwner = true;										// �� ���������� ������ ���������
			buyer.addProperty(this);								// �� ���������� ����������� ���� ����������� ��� buyer
			buyer.addAirfieldCount();								// � ������� ������� �� ���������� ��� ���� 1
			JOptionPane.showMessageDialog(null, "You just bought " + squareName,
												squareName, JOptionPane.INFORMATION_MESSAGE);
		}
		else 														// � ������� ��� ���� ������ ������� ��� �� �������� ��� ��������
			JOptionPane.showConfirmDialog(null, "You don't have the money to buy this Airfield.", 
												 squareName, JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE);
	}
	
//GET METHODS
	
	// ���������� ��� ��������� ��� �����������
	public Player getowner(){
		return owner;
	}
	
	// ���������� �� ��� �� ���������� ���� ��������� � ���
	public boolean isFree(){
		return !hasOwner;
	}
	
	// ���������� ��� ���� ������ ��� �����������
	public int getAirfieldBuyPrice(){
		return airfieldBuyPrice;
	}
	
//SET METHODS
	
	// ����� �� ��������� ��� ����������� ��� buyer
	public void setOwner(Player buyer){
		owner = buyer;
	}
	
//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		 return Square.AIRFIELD;
	 }
}
