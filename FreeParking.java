package Console;

/*
 * 
 * 	����������� ��� ��� FreeParking
 * 
 */

public class FreeParking extends Square{	// � ����� FreeParking ����� �������� ��� Square
	
	// � �������������� ������� ��� ������ FreeParking. ������� 2 �������� (String, int)
	public FreeParking(String aName , int aNumber){
		super(aName ,aNumber);		//�������� � �������������� ��� ����������
	}
	
//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		return Square.FREE_PARKING;
	}
}
