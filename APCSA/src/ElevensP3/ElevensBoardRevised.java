package ElevensP3;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoardRevised extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}
  public void printNPDCN(){
    System.out.println("Derek Nakanishi, Period 4,3/28/2018,CN:25");
  }
	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		if (selectedCards.size()==2 &&containsPairSum11(selectedCards)){
			return true;
		}
		if (selectedCards.size()==3 &&containsTripleSum11(selectedCards)){
			return true;
		}
		if (selectedCards.size() == 2&& containsPairFace(selectedCards)){
		  return true;
		}
		else if (selectedCards.size()==3 && containsJQK(selectedCards)){
			return true;
		}
		return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	public boolean anotherPlayIsPossible() {
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		//List<Integer> cardBoard = new ArrayList<Integer>();
		//for (int i=0; i<=8; i++) {
		//	cardBoard.add(i);
		//}
		if(containsJQK(cardIndexes())||containsTripleSum11(cardIndexes())||containsPairFace(cardIndexes)||containsPairSum11(cardIndexes)){
		  return true;
		}
		return false;
		//return containsJQK(cardBoard) || containsTripleSum11(cardBoard);
		
	}
	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards)
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for (int First:selectedCards){
			for (int Second:selectedCards){
				if (cards[First].pointValue()+cards[Second].pointValue()==11){
					return true;
				}
			}
		}
		return false;
	}
	private boolean containsTripleSum11(List<Integer> selectedCards)
	{
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		for (int First:selectedCards){
			for (int Second:selectedCards){
			    for( int Third:selectedCards){
				if (cards[First].pointValue()+cards[Second].pointValue()+cards[Third].pointValue()==11){
					return true;
				}
			}
		}
		}
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
		boolean J=false;
		boolean Q=false;
		boolean K=false;
		for (int i=0; i<selectedCards.size(); i++){
			Card c = cards[selectedCards.get(i)];
			if (c.rank() =="jack"){
			  {J=true;}
			}
			if (c.rank()=="queen"){
			  {Q=true;}
			}
			if (c.rank() =="king"){
			  {K=true;}
			}
			
		}
		return J&&(Q&&K);
	}
	private boolean containsPairFace(List<Integer>selectedCards) {
	  int Jcount = 0;
	  int Qcount = 0;
	  int Kcount = 0;
	  
	  for (int z = 0;z<selectedCards.size();i++){
	    Card d = cards[selectedCards.get(i)];
	    if (d.rank() == "jack"){
	      Jcount++;
	    }
	    if (d.rank() == "queen"){
	      Qcount++;
	    }
	    if (d.rank() == "king"){
	      Kcount++;
	    }
	  }
	if (Jcount == 2){
	   return true;
	}
    if (Qcount == 2){
      return true;
    }
    if (Kcount == 2){
      return true;
    }
    else{
      return false;
    }
	}
	
	public static void printCards(ElevensBoard board){
		List<Integer> cIndex=  board.cardIndexes();
		for (Integer i: cIndex){
			System.out.println(board.cardAt(i));
		}
	}
	
}