package com.declarewar;
import java.util.LinkedList;


public class AbstractCardList  extends LinkedList<Card> {
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String lf = System.lineSeparator();
		String space = "	";
	
		
		result.append(getClass().getSimpleName()).append(": ").append(lf);
		
		for(Card card : this) {
			
			result.append(space).append(card).append(lf);
			
		}
		return result.toString();
	}

}

