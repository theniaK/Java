package Console;

/*
 * 
 * 	����������� ��� ��� Prison
 * 
 */

public class Prison extends Square{		// � ����� Prison ����� �������� ��� Square

	private int prisonFee = 50;			// � ����� ��� �� ���� � ������� ��� ��� ������
	
	// � �������������� ������� ��� ������ Prison. ������� 2 �������� (String, int)
	public Prison (String aName ,int aNumber){
		super(aName,aNumber);			//�������� � �������������� ��� ����������
	}
	
	// � ������� ���� ������� ��� ���� ��� �� ���� � ������� ��� ��� ������ ��� �� �������� ���
	public void payToBeFree(Player unlucky){
		unlucky.setBalance(unlucky.getBalance()-prisonFee);
    }

//GET METHODS
	
	// ���������� ��� ���� ��� �� ���� � ������� ��� ��� ������
	public int getPrisonFee(){
		return prisonFee;
	}
	
//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		return Square.PRISON;
	}
}
	
	
