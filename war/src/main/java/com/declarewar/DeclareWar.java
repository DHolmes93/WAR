package com.declarewar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DeclareWar {
    
private List<String> people = List.of("Don", "Mike", "Xavier", "Janelle");
	
	private Random random = new Random();
	private Player player1;
	private Player player2;
	private Deck deck;
	
		
	public static void main(String[] args) {
		new DeclareWar().run();
		
	}
	private void run() {
		selectPlayers();
		createAndShuffleDeck();
		dealTheCards();
		player2.describe();
		playTheGame();
		declareWinner();
		
		
	}
	
	private void createAndShuffleDeck() {
		deck = new Deck();
		deck.shuffle();
		
		
	}
	private void selectPlayers() {
		List<String> names = new LinkedList<>(people);
		player1 = selectPlayer(names);
		player2 = selectPlayer(names);
		
		System.out.printf("%s is Playing %s.%n", player1, player2);
		
	}
	private Player selectPlayer(List<String> names) {
		int pos = random.nextInt(names.size());
		String name = names.remove(pos);
		return new Player(name);
	}
	private void declareWinner() {
		if(player1.getScore() > player2.getScore()) {
			printWinner(player1);
			printLoser(player2);
		}
		else if(player2.getScore() > player1.getScore()) {
			printWinner(player2);
			printLoser(player1);
		}
		else {
			printTie(player1, player2);
		}
		
	}
	private void printTie(Player player1, Player player2) {
		System.out.printf("%s and %s tied with a score of %d.%n",
				player1, player2, player1.getScore());
		
	}
	private void printLoser(Player loser) {
		System.out.printf("%s is the loser with a score of %d.%n",
				loser, loser.getScore());
	}
	private void printWinner(Player winner) {
		System.out.printf("%s is the glorius winner with a score of %d.%n",
				winner, winner.getScore());
		
	}
	private void playTheGame() {
		int numTurns = player1.getHand().size();
		
		for(int turn = 0; turn < numTurns; turn++) {
			playersFlipCards();
		}
		
	}
	private void playersFlipCards() {
		Card card1 = player1.flip();
		Card card2 = player2.flip();
		
		if(card1.getRank() > card2.getRank()) {
			player1.incrementScore();
			
		}
		else if(card2.getRank() > card1.getRank()) {
			player2.incrementScore();
		}
		
	}
	private void dealTheCards() {
		int size = deck.size();
		for (int index = 0; index < size; index++) {
			if(index % 2 == 0) {
			player1.draw(deck);
			}
			else {
			player2.draw(deck);
		}
		}
		player1.describe();
		
	}

}

