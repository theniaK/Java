package Console;

/*
 * 
 *  ����������� ��� ��� Start
 * 
 */

public class Start extends Square{  // � ����� Start ����� �������� ��� Square
	
	// �������������� ������� ��� ������ Start. ������� 2 �������� (String, int)
	public Start (String aName , int aNumber){
		super(aName,aNumber);		//�������� � �������������� ��� ����������	
	}
	
//ABSTRACT METHODS		
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		return Square.START;
	}
}
