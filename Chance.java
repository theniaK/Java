package Console;
import java.util.*;
import javax.swing.*;

/*
 * 
 * 	����������� ��� ��� Chance
 * 
 */

public class Chance extends Square {		// � ����� Chance ����� �������� ��� Square
	
	private Card cardDrawn;												// � ����� ��� ���� �������� � �������
	private static ArrayList<Card> chanceDeck = new ArrayList<Card>(); 	// � ������� �������� �� ��� ������ �������
	private static int cardCounter = 0;									// � �������� �������� ��� �� ����������� ��� ������
	
	// � �������������� ������� ��� ������ Chance. ������� 2 �������� (String, int)
	public Chance (String aName , int aNumber ){
		super(aName,aNumber);		// �������� � �������������� ��� ����������
		this.cardDrawn=null;		// � �������� ����� �������������� �� ��� ���� null
	}
	
	// � ������� ���� ����������� ��� ����� ��� ���� �������� � ������� � ������ ������� �� ������
	public void chanceActivate(Player unlucky){
		cardDrawn = drawChance();				// � ������� ������� ����� ��� ��� ��������
		int type = cardDrawn.getcardType();
		JOptionPane.showMessageDialog(null, cardDrawn.getcardText(), 
											cardDrawn.getcardName(), JOptionPane.OK_OPTION);
    	
		if (type==Card.ADD){							// �� � ����� ������ ����� ����� ��������� �������� �������� � AddMoney
			cardDrawn.addMoney(unlucky);	
		}
		else if (type==Card.DEDUCT){					// �� � ����� ������ ����� ����� ��������� �������� �������� � deductMoney
			cardDrawn.deductMoney(unlucky);
		}    
		else if (type==Card.MOVE){						// �� � ����� ������ ����� ����� ����������� ������ �������� � MovePlayer
			cardDrawn.movePlayer(unlucky);
		}
	}

	// � ������� ���� ������� ������� ��� ����� ��� ��� ��������� ���� ������� �������� �� ��� ������ �������
	public static void addCards(Card c){
		chanceDeck.add(c);		
	}
	
	// � ������� ���� ������� ���������� ��� �������� �������
	public static void shuffleChance (){
		Collections.shuffle(chanceDeck);
	}
	
	// ���� � ������� ������� ��� ����� ��� ��� �������� ��� ������ �������.
	public Card drawChance(){
		Card c = chanceDeck.get(cardCounter); 
		cardCounter ++;
		
		if (cardCounter == chanceDeck.size()){		//�� � �������� ���� ���������, ������� ���� ��� ����� �����.
			cardCounter=0;
		}
		return c;	
	}
	
//GET METHODS
	
	//���������� ��� ����� ��� ������� � �������
	public Card getCardDrawn(){
		return cardDrawn;
	}
	
//ABSTRACT METHODS
	
	// ���������� ��� ������� ��� Square ������� ��� ���� �������� ��� �����������
	public int returnType(){
		 return Square.CHANCE;	 
	}
}
