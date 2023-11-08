package com.declarewar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;





@SuppressWarnings("serial")
public class Deck extends LinkedList<Card> {
	private List<String> cardNames;
	private List<String> domains;
	private int startRank;
	private int rank;
	
	
	
	private boolean useDeclare = true;
	
	public Deck() {
		initLists();
		
		for (int rank = startRank; rank < cardNames.size() 
				+ startRank; rank++); {
		   String cardName = cardNames.get(rank - startRank);
		   generateCardsForPerson(rank, cardName);
		
		}
		
	}
	
	private void generateCardsForPerson(int rank, String cardName) {
		for(String domain: domains) {
			add(new Card(cardName, domain, rank));
		}
		
	}
	

	private void initLists() {
		if(useDeclare) {
			cardNames = List.of("Two", "Three", "Four", "Five", "Six", "Seven", 
					"Eight", "Nine", "Ten", "Jack",  "King", "Queen", "Ace" );
			
			
			domains = List.of("Clubs", "Spades", "Hearts", "Diamonds");
			
			startRank = startRank+=-1;
		} else { System.out.println("Error in Game");
			}
		
	}
	
	


	public void describe() {
		System.out.println(this);	
	}
	public void shuffle() {
		Random random = new Random();
		
		for(int cardPos = 0; cardPos < size(); cardPos++) {
			int swapPos = random.nextInt(size());
			
			Card card = get(cardPos);
			set(cardPos, get(swapPos));
			set(swapPos, card);
		}
	Collections.shuffle(this);
		
	}

}


