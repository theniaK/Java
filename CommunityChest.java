package Console;
import java.util.*;
import javax.swing.*;

/*
 * 
 * 	����������� ��� ��� CommunityChest
 * 
 */

public class CommunityChest extends Square{		// � ����� CommunityChest ����� �������� ��� Square
	
	private Card cardDrawn;														// � ����� ��� ���� �������� � �������
	private static ArrayList<Card> communityChestDeck = new ArrayList<Card>(); 	// � ������� �������� �� ��� ������ ��������
	private static int cardCounter = 0;											// � �������� �������� ��� �� ����������� ��� ������

	// � �������������� ������� ��� ������ CommunityChest. ������� 2 �������� (String, int)
	public CommunityChest (String aName , int aNumber){
		 super(aName,aNumber);		// �������� � �������������� ��� ����������
		 this.cardDrawn=null;		// � �������� ����� �������������� �� ��� ���� null
	}
	
	// � ������� ���� ����������� ��� ����� ��� ���� �������� � ������� � ������ ������� �� ������
    public void chestActivate(Player unlucky){
    	cardDrawn = drawFromChest();			// � ������� ������� ����� ��� ��� ��������
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
    
	// � ������� ���� ������� ������� ��� ����� ��� ��� ��������� ���� ������� �������� �� ��� ������ ��������
	public static void addCards(Card c){
		communityChestDeck.add(c);		
	}
	
    // � ������� ���� ���������� ��� �������� ���������
	public static void shuffleChest(){
		Collections.shuffle(communityChestDeck);
	}
	
	// ���� � ������� ������� ��� ����� ��� ��� �������� ��� ������ ��������. 
	public Card drawFromChest(){
		Card c = communityChestDeck.get(cardCounter); 
		cardCounter ++;
		
		if (cardCounter == communityChestDeck.size()){	//�� � �������� ���� ���������, ������� ���� ��� ����� �����.
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
		return Square.COMMUNITY_CHEST; 
	}
}
	
	
	


