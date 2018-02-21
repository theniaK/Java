package Console;
import java.util.*;

/*
 * 
 *  ����������� ��� ��� Game
 * 
 */

public class Game {
	
	private ArrayList<Player> playersList = new ArrayList<Player>();		//� ����� �� ���� ������� ��� ����� �������
	private Square[] allSquaresBoard = new Square[40];;						//� ����� �� ��� �� ��������� ��� ������ ���������� ������� �� ��� ����� ��������� ���� ��� ������
	private int startBonus = 200;											//�� ���� ��� ������� � ���� ������� ���� ������� ��� ��� ������

	private int currentDiceNumber = 0;										//�� ���� ��� ��������� ������
	
	// � �������������� ��� ������ Game. ������� 4 �������� (String, String, String, String)
	public Game(String p1, String p2, String p3, String p4){	
    	addPlayersToList(p1,p2,p3,p4);
      	createNewGame();
    }
	
	// � �������������� ��� ������ Game. ������� 3 �������� (String, String, String)
	public Game(String p1, String p2, String p3){	
		addPlayersToList(p1,p2,p3);
      	createNewGame();
    }
	
	// � �������������� ��� ������ Game. ������� 2 �������� (String, String)
	public Game(String p1, String p2){	
		addPlayersToList(p1,p2);
		createNewGame();
	}	
	
	//�� �������� ������� ����������� ������� ������� �� ��� �������������� ��� ���� ����������� ���� ����� playersList
	//��������� 2 ������� ���� �����
	public void addPlayersToList(String p1, String p2){
		playersList.add(new Player(p1,1));
		playersList.add(new Player(p2,2));
	}
	//��������� 3 ������� ���� �����
	public void addPlayersToList(String p1, String p2, String p3){
		playersList.add(new Player(p1,1));
		playersList.add(new Player(p2,2));
		playersList.add(new Player(p3,3));
	}
	//��������� 4 ������� ���� �����
	public void addPlayersToList(String p1, String p2, String p3, String p4){
		playersList.add(new Player(p1,1));
		playersList.add(new Player(p2,2));
		playersList.add(new Player(p3,3));
		playersList.add(new Player(p4,4));
	}
	
	// � ������� ���� ���������� ��� �� ���������, �� ��������� ��� ������ ��� ���� ��� ������ ������� ��� �������� ��� ��� ��������� ���� ��������� ����.
	public void createNewGame(){
		createSites();				//�������������� �� ��������
		createAirfield();			//�������������� �� ����������
		createUtility();			//�������������� �� ��������� ������ ��������
		createCommunityChest();		//�������������� �� ��������� ��������
		createChestCards();			//�������������� �� ������ ��������
		createChance();			//�������������� �� ��������� �������
		createChanceCards();		//�������������� �� ������ �������
		createOther();				//������������� � ��������, � ������, � �������� ���������, �� ��������� "������� ���� ������" ��� �� ��������� �����
	}
	
	// � ������� ���� ���������� ��� �� �������� ��� �� ���������� ���� ������ allSquaresBoard
	private void createSites(){
		//                        �����        ����   �����    ����  �0   �1   �2    �3   ��������   (� = �������)
		Square site1 = new Site ("Vilna"      ,  1 , "Brown"  , 60 ,  2,  10,  90 ,  250, 50 );
		Square site3 = new Site ("Riga"       ,  3 , "Brown"  , 60 ,  4,  20,  180,  450, 50 );
		Square site6 = new Site ("Sofia"      ,  6 , "Cyan"   , 100,  6,  30,  270,  550, 50 );
		Square site8 = new Site ("Bucharest"  ,  8 , "Cyan"   , 100,  6,  30,  270,  550, 50 );
		Square site9 = new Site ("Warsaw"     ,  9 , "Cyan"   , 120,  8,  40,  300,  600, 50 );
		Square site11 = new Site("Budapest"   , 11 , "Pink"   , 140, 10,  50,  450,  750, 100);
		Square site13 = new Site("Geneva"     , 13 , "Pink"   , 140, 10,  50,  450,  750, 100);
		Square site14 = new Site("Helsinki"   , 14 , "Pink"   , 160, 12,  60,  500,  900, 100);
		Square site16 = new Site("Stockholm"  , 16 , "Orange" , 180, 14,  70,  550,  950, 100);
		Square site18 = new Site("Vienna"     , 18 , "Orange" , 180, 14,  70,  550,  950, 100);
		Square site19 = new Site("Lisbon"     , 19 , "Orange" , 200, 16,  80,  600, 1000, 100);
		Square site21 = new Site("Madrid"     , 21 , "Red"    , 220, 18,  90,  700, 1050, 150);
		Square site23 = new Site("Athens"     , 23 , "Red"    , 220, 18,  90,  700, 1050, 150);
		Square site24 = new Site("Dublin"     , 24 , "Red"    , 240, 20, 100,  750, 1100, 150);
		Square site26 = new Site("Copenhagen" , 26 , "Yellow" , 260, 22, 110,  800, 1150, 150);
		Square site27 = new Site("London"     , 27 , "Yellow" , 260, 22, 110,  800, 1150, 150);
		Square site29 = new Site("Luxembourg" , 29 , "Yellow" , 280, 24, 120,  850, 1200, 150);
		Square site31 = new Site("Brussels"   , 31 , "Green"  , 300, 26, 130,  900, 1275, 200);
		Square site32 = new Site("Amsterdam"  , 32 , "Green"  , 300, 26, 130,  900, 1275, 200);
		Square site34 = new Site("Rome"       , 34 , "Green"  , 320, 28, 150, 1000, 1400, 200);
		Square site37 = new Site("Berlin"     , 37 , "Blue"   , 350, 35, 175, 1100, 1500, 200);
		Square site39 = new Site("Paris"      , 39 , "Blue"   , 400, 50, 200, 1400, 2000, 200);
		
		// �� ���� �� ������ �� �������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[1 ] = site1 ;
		allSquaresBoard[3 ] = site3 ;
		allSquaresBoard[6 ] = site6 ;
		allSquaresBoard[8 ] = site8 ;
		allSquaresBoard[9 ] = site9 ;
		allSquaresBoard[11] = site11;
		allSquaresBoard[13] = site13;
		allSquaresBoard[14] = site14;
		allSquaresBoard[16] = site16;
		allSquaresBoard[18] = site18;
		allSquaresBoard[19] = site19;
		allSquaresBoard[21] = site21;
		allSquaresBoard[23] = site23;
		allSquaresBoard[24] = site24;
		allSquaresBoard[26] = site26;
		allSquaresBoard[27] = site27;
		allSquaresBoard[29] = site29;
		allSquaresBoard[31] = site31;
		allSquaresBoard[32] = site32;
		allSquaresBoard[34] = site34;
		allSquaresBoard[37] = site37;
		allSquaresBoard[39] = site39;
	}
	
	// � ������� ���� ���������� ��� �� ���������� ��� �� ���������� ���� ������ allSquaresBoard
	private void createAirfield(){
		//                                �����              ���� ����	�1  �2  �3   �4       (� = �������)
		Square airfield1 = new Airfield ("Schiphol"          , 5 , 200, 25, 50, 100, 200);
		Square airfield2 = new Airfield ("RheinMein"         , 15, 200, 25, 50, 100, 200);
		Square airfield3 = new Airfield ("Charles de Gaulle" , 25, 200, 25, 50, 100, 200);
		Square airfield4 = new Airfield ("Heathrow"          , 35, 200, 25, 50, 100, 200);
		
		// �� ���� �� ������ �� ���������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[5 ] = airfield1;
		allSquaresBoard[15] = airfield2;
		allSquaresBoard[25] = airfield3;
		allSquaresBoard[35] = airfield4;
	}
	
	// � ������� ���� ���������� ���� ��� ��������� ������ �������� ��� ��� ���������� ���� ������ allSquaresBoard
	private void createUtility(){
		//                               �����                 ���� ���� �1  �2       (� = ���������������)
		Square utility1 = new Utility ( "European Parliament" , 12 , 150, 4, 10);
		Square utility2 = new Utility ( "European Court"      , 28 , 150, 4, 10);
		
		// �� ���� �� ������ �� ��������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[12] = utility1;
		allSquaresBoard[28] = utility2;
	}
	
	
	private void createCommunityChest(){
		//                                                 �����        ����
		Square communityChest1 = new CommunityChest ("Community Chest" , 2 );
		Square communityChest2 = new CommunityChest ("Community Chest" , 17);
		Square communityChest3 = new CommunityChest ("Community Chest" , 32);
		
		// �� ���� �� ������ �� ��������� �������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[2 ] = communityChest1;
		allSquaresBoard[17] = communityChest2;
		allSquaresBoard[33] = communityChest3;
		
	}
	
	// � ������� ���� ���������� ��� �� ��������� ������� ��� �� ���������� ���� ������ allSquaresBoard
	private void createChance(){
		//                            �����    ����
		Square chance1 = new Chance ("Chance" , 7 );
		Square chance2 = new Chance ("Chance" , 22);
		Square chance3 = new Chance ("Chance" , 36);
		
		// �� ���� �� ������ �� ��������� ������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[7 ] = chance1;
		allSquaresBoard[22] = chance2;
		allSquaresBoard[36] = chance3;
		
	}
	
	/*  �  �������  ����  ����������  ��  ���������  ���������,  �������,  ���������  ���������� ,  */
	/*  "������� ���� ������" ��� �� ��������� ����� ��� �� ���������� ���� ������ allSquaresBoard  */
	private void createOther(){
		//                                       �����        ���� �����
		Square incomeTax   = new Tax         ("Income Tax"   , 4  , 200);
		Square luxuryTax   = new Tax         ("Luxury Tax"   , 38 , 100);
		Square start       = new Start       ("Start"        , 0       );
		Square freeParking = new FreeParking ("Free Parking" , 20      );
		Square goToPrison  = new GoToPrison  ("Go To Prison" , 30      );
		Square prison      = new Prison      ("Prison"       , 10      );
		
		// �� ���� �� ������ �� ��������� ������������� ���� ������ ���� ��� ������
		allSquaresBoard[4 ] = incomeTax;
		allSquaresBoard[38] = luxuryTax;
		allSquaresBoard[0 ] = start;
		allSquaresBoard[10] = prison;
		allSquaresBoard[20] = freeParking;
		allSquaresBoard[30] = goToPrison;
	}
	
	// � ������� ���� ���������� ���� ��� ������ �������� ��� ��� ���������� ���� ������� ����� communityChestDeck ��� ������ CommunityChest
	public void createChestCards(){
		//                                           ������                                     �������                                        �����     ����  ���� ����       
		CommunityChest.addCards(new Card (1  , "Pay Money"         , "Pay school tuition : 150 euros."                                       , Card.DEDUCT , -1  , 150 , -1 ));
		CommunityChest.addCards(new Card (2  , "Pay Money"         , "Speeding fine : 15 euros."                                         , Card.DEDUCT , -1  , 15  , -1 ));
		CommunityChest.addCards(new Card (3  , "Pay Money"         , "You have been drinking while in charge.\n Fine : 20 euros."        , Card.DEDUCT , -1  , 20  , -1 ));
		CommunityChest.addCards(new Card (4  , "Get Money"         , "You received 50 euros from the bank."                              , Card.ADD    , 50  , -1  , -1 ));
		CommunityChest.addCards(new Card (5  , "Get Money"         , "You won the lotto! Collect 100 euros"								 , Card.ADD    , 100 , -1  , -1 ));
		CommunityChest.addCards(new Card (6  , "Get Money"         , "Housing loan : Collect 150 euros."                                 , Card.ADD    , 150 , -1  , -1 ));
		CommunityChest.addCards(new Card (7  , "Move"              , "Move to Start."                                                    , Card.MOVE   , -1  , -1  ,  0 ));
		CommunityChest.addCards(new Card (8  , "Move"              , "Move to Dublin.\n If you pass Start collect 200 euros."            , Card.MOVE   , -1  , -1  , 24 ));
		CommunityChest.addCards(new Card (9  , "Move" 			   , "Move to Airport Rheinmein.\n If you pass Start collect 200 euros." , Card.MOVE   , -1  , -1  , 15 ));
		CommunityChest.addCards(new Card (10 , "Move"              , "Move to Paris." 													 , Card.MOVE   , -1  , -1  , 39 ));
		CommunityChest.addCards(new Card (11 , "Move"              , "Move to Budapest.\n If you pass Start collect 200 euros."          , Card.MOVE   , -1  , -1  , 11 ));
		
		// �� ���� �� ������ ������������ � �������� �� ��� ������ ��������
		CommunityChest.shuffleChest(); 
	}
	
	// � ������� ���� ���������� ���� ��� ������ ������� ��� ��� ���������� ���� ������� ����� chanceDeck ��� ������ Chance
	public void createChanceCards(){
		//                        ID     ������     							�������									     �����         ���� ����  ����
		Chance.addCards(new Card (1 ,  "Get Money", "You won the Eurovision song contest.\n Collect 25 euros." 			   , Card.ADD    , 25  , -1  , -1 ));
		Chance.addCards(new Card (2 ,  "Pay Money", "Pay hospital fee : 100 euros." 									   , Card.DEDUCT , -1  , 100 , -1 ));
		Chance.addCards(new Card (3 ,  "Pay Money", "Pay insurance fee : 50 euros." 									   , Card.DEDUCT , -1  , 50  , -1 ));
		Chance.addCards(new Card (4 ,  "Pay Money", "Pay doctor fee : 50 euros." 										   , Card.DEDUCT , -1  , 50  , -1 ));
		Chance.addCards(new Card (5 ,  "Get Money", "You won the second prize in a beauty contest.\n Collect 10 euros. "   , Card.ADD    , 10  , -1  , -1 ));
		Chance.addCards(new Card (6 ,  "Get Money", "A bank error has occured.\n Collect 200 euros."                       , Card.ADD    , 200 , -1  , -1 ));
		Chance.addCards(new Card (7 ,  "Get Money", "You have inherited 100 euros."                                        , Card.ADD    , 100 , -1  , -1 ));
		Chance.addCards(new Card (8 ,  "Gey Money", "You've got a grant from the Community.\n Collect 20 euros."           , Card.ADD    , 20  , -1  , -1 ));
		Chance.addCards(new Card (9 ,  "Get Money", "The laws of the European Court are by your side.\n Collect 50 euros." , Card.ADD    , 50  , -1  , -1 ));
		Chance.addCards(new Card (10 , "Get Money", "You've got an ERASMUS scholarship.\n Collect 100 euros" 			   , Card.ADD    , 100 , -1  , -1 ));
		Chance.addCards(new Card (11 , "Move"	  , "Move to Start."                                                       , Card.MOVE   , -1  , -1  ,  0 )); 
		// �� ���� �� ������ ������������ � �������� �� ��� ������ �������
		Chance.shuffleChance();
	}
	
	//� ������� ���� �������� �� 2 ����� ��� ����������. ���������� ��� ������ ������� ���� ��� 2 ��� 12
	public int throwDice(){
		Random generator = new Random();
		currentDiceNumber = generator.nextInt(11)+2;  //�� ������ ������� ������ ������� �� ��� ����� ����� ��� �������
		return currentDiceNumber;         
	}
	
	//� ������� ���� ��������� ��� �������� ��� ������ lucky �� startBonus
	public void addStartPassMoney(Player lucky){
		lucky.setBalance(lucky.getBalance()+ startBonus);
	}
	
//GET METHODS
	
	// ���������� ��� ����� ��� �������
	public ArrayList<Player> getPlayersList(){
		return playersList;
	}
	
	//���������� �� ��������� ��� ��������� ���� ���� index
	public Square getSquare(int index){
		return allSquaresBoard[index];	
	}	
}
