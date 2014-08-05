package student_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;



public class Deck  implements  Comparator<Card>{
	ArrayList<Card> deck=new ArrayList<Card>(); 

	public Deck(){
		for(Suits suit:Suits.values()){
			for(Numerals num:Numerals.values()){
				Card card=new Card(suit,num);
				deck.add(card);
			}
		}
	}
	///////////////////////??????????????????????
	public Deck clone(){

		Deck copyCard=new Deck();
		for(int i=0;i<deck.size();i++){
			Card add= new Card(deck.get(i));
			copyCard.deck.add(add);	
		}

		return copyCard;

	}

	public Iterator<Card>iterator(){

		return deck.iterator();
	}

	public int compare (Card card1, Card card2){

		int outcome=card1.get_numeral().compareTo(card2.get_numeral());
		if(outcome==0){
			return card1.get_suit().compareTo(card2.get_suit());
		}
		return outcome;
	}


	public int size(){
		return deck.size();
	}

	public void shuffle(){

		Collections.shuffle(deck);

	}

	public void sort(){
		Collections.sort(deck, new Deck());
	}



}
