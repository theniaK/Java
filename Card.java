package Console;

/*
 * 
 * 	����������� ��� ��� Card
 * 
 */

public class  Card {
	
	private int cardNumber;			// �� ID ��� ������
	private String cardName;		// � ������ ��� ������
	private String cardText;		// �� ������� ��� ������
	private int cardType; 			// � ����� ��� ������ (ADD, DEDUCT, MOVE)
	private int plusMoney;			// �� ������� ���� ��������
	private int minusMoney;			// �� ������� ���� �������
	private int movePlayerPosition;	// � ���� ��� ���������� ��� ������
	
	// ������ �������� ��� �� ��������� ���� ���������� ��� ������ ��� ������
	public static final int ADD = 1; 
	public static final int DEDUCT = 2;
	public static final int MOVE = 3;
	
	// � �������������� ������� ��� ������ Card. ������� 7 �������� (int, String, String, int, int, int, int)
	public Card (int cNumber ,String cName ,String cText ,int cType, int plusMoney , int minusMoney , int movePlayerPosition){
		  this.cardNumber=cNumber;
		  this.cardName=cName;
		  this.cardText=cText;
		  this.cardType=cType;
		  this.plusMoney=plusMoney;
		  this.minusMoney=minusMoney;
		  this.movePlayerPosition=movePlayerPosition;	
	}
	
	// � ������� ���� ��������� ��� ������ ��� ������� �� ������ ���� ���� movePlayerPosition
	public void movePlayer(Player unlucky){ 
		unlucky.setPosition(movePlayerPosition);	 
	}
	
	// � ������� ���� ��������� ��� �������� ��� ������ ��� ������� �� ������ ��� ��������� plusMoney
	public void addMoney(Player unlucky){
		unlucky.setBalance(unlucky.getBalance() + plusMoney);	 
	}
	
	// � ������� ���� ������� ��� �� �������� ��� ������ ��� ������� �� ������ ��� ��������� deductMoney
	public void deductMoney(Player unlucky){
		unlucky.setBalance(unlucky.getBalance() - minusMoney);
	}
	
//GET METHODS
	
	//���������� �� ������� ��� ������
	public String getcardText (){
		return(cardText);	
	}
	
	// ���������� �� ����� ��� ������
	public String getcardName(){
		return(cardName);
	}
	// ���������� ��� ���� ��� ������
	public int getcardType(){
		return cardType;
	}		
	
	//���������� ��� ���� ��� �� ����������� � �������
	public int getmovePlayerPosition(){
		return movePlayerPosition;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	


