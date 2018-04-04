package ELEVENSV2;

import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"Spades", "Hearts", "Diamonds", "Clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};


	/**
	 * The cards on this board.
	 */
	private Card[] cards;

	/**
	 * The deck of cards being used to play the current game.
	 */
	private Deck deck;

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
		
		cards = new Card[BOARD_SIZE];
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		
		if (I_AM_DEBUGGING) {
			System.out.println(deck);
			System.out.println("----------");
		}
		dealMyCards();
		
	}

	/**
	 * Start a new game by shuffling the deck and
	 * dealing some cards to this board.
	 */
	public void newGame() {
		cards = new Card[BOARD_SIZE];
		deck = new Deck(RANKS, SUITS, POINT_VALUES);
		deck.shuffle();
		dealMyCards();
	}

	/**
	 * Accesses the size of the board.
	 * Note that this is not the number of cards it contains,
	 * which will be smaller near the end of a winning game.
	 * @return the size of the board
	 */
	public int size() {
		return cards.length;
	}

	/**
	 * Determines if the board is empty (has no cards).
	 * @return true if this board is empty; false otherwise.
	 */
	public boolean isEmpty() {
		for (int p = 0; p < cards.length; p++) {
			if (cards[p] != null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Deal a card to the kth position in this board.
	 * If the deck is empty, the kth card is set to null.
	 * @param p the index of the card to be dealt.
	 */
	public void deal(int p) {
		cards[p] = deck.deal();
	}

	/**
	 * Accesses the deck's size.
	 * @return the number of undealt cards left in the deck.
	 */
	public int deckSize() {
		return deck.size();
	}

	/**
	 * Accesses a card on the board.
	 * @return the card at position p on the board.
	 * @param p is the board position of the card to return.
	 */
	public Card cardAt(int p) {
		return cards[p];
	}

	/**
	 * Replaces selected cards on the board by dealing new cards.
	 * @param selectedCards is a list of the indices of the
	 *        cards to be replaced.
	 */
	public void replaceSelectedCards(List<Integer> selectedCards) {
		for (Integer p : selectedCards) {
			deal(p.intValue());
		}
	}

	/**
	 * Gets the indexes of the actual (non-null) cards on the board.
	 *
	 * @return a List that contains the locations (indexes)
	 *         of the non-null entries on the board.
	 */
	public List<Integer> cardIndexes() {
		List<Integer> selected = new ArrayList<Integer>();
		for (int p = 0; p < cards.length; p++) {
			if (cards[p] != null) {
				selected.add(new Integer(p));
			}
		}
		return selected;
	}

	/**
	 * Generates and returns a string representation of this board.
	 * @return the string version of this board.
	 */
	public String toString() {
		String s = "";
		for (int p = 0; p < cards.length; p++) {
			s = s + p + ": " + cards[p] + "\n";
		}
		return s;
	}

	/**
	 * Determine whether or not the game has been won,
	 * i.e. neither the board nor the deck has any more cards.
	 * @return true when the current game has been won;
	 *         false otherwise.
	 */
	public boolean gameIsWon() {
		if (deck.isEmpty()) {
			for (Card c : cards) {
				if (c != null) {
					return false;
				}
			}
			return true;
		}
		return false;
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
		if(containsJQK(cardIndexes())||containsPairSum11(cardIndexes())){
		  return true;
		}
		return false;
		//return containsJQK(cardBoard) || containsPairSum11(cardBoard);
		
	}


	/**
	 * Deal cards to this board to start the game.
	 */
	private void dealMyCards() {
		for (int p = 0; p < cards.length; p++) {
			cards[p] = deck.deal();
		}
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
				if (First != Second && cards[First].pointValue()+cards[Second].pointValue()==11){
					return true;
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
			if (c.rank() =="Jack"){
			  {J=true;}
			}
			if (c.rank()=="Queen"){
			  {Q=true;}
			}
			if (c.rank() =="King"){
			  {K=true;}
			}
			
		}
		return J&&(Q&&K);
	}
	public static void printCards(ElevensBoard board){
		List<Integer> cIndex=  board.cardIndexes();
		for (Integer i: cIndex){
			System.out.println(board.cardAt(i));
		}
	}
	
}