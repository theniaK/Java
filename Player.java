package Console;
import java.util.*;

/*
 * 
 * 	����������� ��� ��� Player
 * 
 */

public class Player {
	
	private String playerName;												// �� ����� ��� ������
	private int playerID;													// �� ID ��� ������
	private int playerBalance;												// �� �������� ��� ������
	private ArrayList<Square> playerProperties = new ArrayList<Square>();	// � ����� �� ��� ����������� ��� ������
	private int playerPosition;												// � ���� ��� ������
	private boolean inPrison;												// ������ ��������� ��� ������� ��� � ������� ����� ������������
	private boolean bankrupt;												// ������ ��������� ��� ������� ��� � ������� ���� �����������
	private int playersDice;												// � ���� ��� ������ ��� ������
	private int currentAirfield;											// ���� ���������� ���� � �������
	private int currentUtility;												// ����� ��������� ���� � �������
	private int pawnNumber;													// �� ID ��� ������� ��� ���� ������
	
	// � �������������� ��� ������ Player. ������� 2 �������� (String, int)
	public Player(String plName, int plID){
		playerName = plName;
		playerID = plID;
		playerBalance = 1500;		// �� ������ ���� ��� ������ ����� 1500 ����
		playerPosition = 0;			// � ������ ���� ��� ������ ����� ���� ��������
		inPrison = false;			// � ������� ������� �� �������� ���������
		bankrupt = false;			// � ������� ������� �� �������� �� �������������
		playersDice = 0;			// � ������ ����� ��� ������ ����� 0
		currentAirfield = 0;		// � ������� ������� �� �������� ����� ������ ����������
		currentUtility = 0;			// � ������� ������� �� �������� ����� ����� ��������
		pawnNumber = plID;			/* ��� ID ��� ������� ������������ �� ID ��� ������. ����� �� ������� ����������,
									   �� ID ���� ������� ���� �� pawnNumber ���� ���. ���� ��������� ��� ���������
									   ��� ������� ��� ����� ���� ���� ��� ����������, �� �� ����� �������.			 */
	}
	
	// � ������� ���� ������� �� ���� ����������� � ������� ������� �� �� �������� ���
	public boolean checkBankrupt(){
		if (playerBalance<0){
			this.bankrupt = true;	// �� � ������� ���� �����������, � ��������� ��� bankrupt ������� true
			return true;
		}
		else
			return false;
	}
	
	// � ������� ���� ������� �� ���������� ��� ������ ���� 1
	public void addAirfieldCount(){
		currentAirfield ++;
	}
	// � ������� ���� ������� ��� ��������� ��� ������ ���� 1
	public void addUtilityCount(){
		currentUtility++;
	}
	
	// � ������� ���� ��������� ��� ���������� ���� ����� ��� ������
	public void addProperty(Square sq){
		playerProperties.add(sq);
	}
	
//GET METHODS
	
	public int getPawnNumber(){
		return pawnNumber;
	}

	// ���������� �� ����� ��� ������
	public String getName(){
		return playerName;
	}
	
	// ���������� �� �������� ��� ������
	public int getBalance(){
		return playerBalance;
	}
	
	// ���������� �� ���� ��� ������
	public int getPlayersDice(){
		return playersDice;
	}
	
	// ���������� �� ��� � ������� ���� ����������� � ���
	public boolean isBankrupt(){
		return bankrupt;
	}
	
	// ���������� ��� ������� ��� ����������� ��� ������
	public int getAirfieldCount(){
		return currentAirfield;
	}
	
	// ���������� ��� ������� ��� ��������� ��� ������
	public int getUtilityCount(){
		return currentUtility;
	}
	
	// ���������� ��� ���� ��� ������
	public int getPosition(){
		return playerPosition;
	}
	
	// ���������� �� ��� � ������� ����� ������������
	public boolean isInPrison(){
		return inPrison;
	}
	
	// ���������� ��� ����� �� ��� ����������� ��� ������
	public ArrayList<Square> getPlayerProperties(){
		return playerProperties;
	}
	
	// ���������� �� ID ��� ������
	public int getPlayerID(){
		return playerID;
	}
	
//SET METHODS
	
	public void setPlayerID(int id){
		playerID = id;
	}
	
	// ����� �� ���� ��� ������ ��� �� �� ������ ��� �������
	public void setPlayersDice(int diceNumber){
		playersDice = diceNumber;
	}
	
	// ����� �� �������� ��� ������ ��� �� �� ������ ��� �������
	public void setBalance(int balance){
		playerBalance = balance;
	}
	
	// ����� ��� ���� ��� ������ ��� �� �� ������ ��� �������
	public void setPosition(int position){
		playerPosition = position;
	}
	
	// ������� ��� ��������� inPrison ��� ������ ������� �� �� ������ ��� �������
	public void setinPrison(boolean inPrison){
		this.inPrison = inPrison;
	}
}
