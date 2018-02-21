package Console;

/*
 * 
 * 	����������� ��� ��� GoToPrison
 * 
 */

public class GoToPrison extends Square {	// � ����� GoToPrison ����� �������� ��� Square
	
	// � �������������� ������� ��� ������ GoToPrison. ������� 2 �������� (String, int)
	public GoToPrison (String aName , int aNumber){
	    super(aName , aNumber);		//�������� � �������������� ��� ����������
	}
	
	// � ������� ���� ������� ���� ������, ��� ��������� ���� ������ ��� ����� ��� ��������� inPrison ��� ������ �� true
	public void moveToPrison (Player unlucky){
		unlucky.setPosition(10); 	//� ������� ������������ ���� ������
		unlucky.setinPrison(true); 	//� ������� ����� ��� ������������
	}
	
//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		return Square.GO_TO_PRISON; 
	}
}
