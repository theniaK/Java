package Console;

/*
 * 
 *  ����������� ��� ��� Square
 * 
 */

public abstract class Square {
	
	protected String squareName;  //�� ����� ��� ����������
	protected int squareNumber;   //�� �������������� ID ��� ����������
	
	// ������ �������� ��� �� ��������� ���� ���������� ��� ���������� �� ����������� ����
	public static final int START = 0;
	public static final int SITE = 1;
	public static final int UTILITY = 2;
	public static final int AIRFIELD = 3;
	public static final int COMMUNITY_CHEST = 4;
	public static final int CHANCE = 5;
	public static final int TAX = 6;
	public static final int FREE_PARKING = 7;
	public static final int PRISON = 8;
	public static final int GO_TO_PRISON = 9;
	
	// �������������� ������� ��� ������ Square. ������� 2 �������� (String, int)
	public Square(String sqName, int sqNumber){
		squareName = sqName;
		squareNumber = sqNumber;
	}
	
//GET METHODS
	
	//���������� �� ����� ��� ����������
	public String getsquareName(){
		return squareName;
	}
	
	//���������� �� �������������� ID ��� ����������
	public int getsquareNumber(){
		return squareNumber;
	}
	
//ABSTRACT METHODS	
	
	//Abstract ������� ��� ��������������� ��� ��� ���������� ��� ���������� ��� Square
	public abstract int returnType();
}
