package Console;

/*
 * 
 * ����������� ��� ��� Tax
 * 
 */

public class Tax extends Square {	// � ����� Tax ����� �������� ��� Square
	
	private int taxToPay;			// � ����� ��� �������� � �������
	
	// � �������������� ������� ��� ������ Tax. ������� 3 �������� (String, int, int)
	public Tax(String aName, int aNumber, int taxToPay){
		super(aName, aNumber);		//�������� � �������������� ��� ����������	
		this.taxToPay = taxToPay;
	}
	
	// � ������� ���� ������� ���� ������ ��� ������� ��� �� �������� ��� ��� ��������� taxToPay
	public void payTax(Player unlucky){
			unlucky.setBalance(unlucky.getBalance()-taxToPay);	
	}
	
// GET METHODS
	
	// ���������� ��� ���� ��� �������� � �������
	public int getTaxToPay(){
		return taxToPay;
	}

//ABSTRACT METHODS	
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		 return Square.TAX;
	}
}
