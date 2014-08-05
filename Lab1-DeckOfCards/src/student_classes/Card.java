package student_classes;

public class Card {

	Suits suit;
	Numerals num;

	public Card(Suits aSuit, Numerals aNumeral){
		this.suit=aSuit;
		this.num=aNumeral;
	}
	
	public Card(Card aCard){
		this.suit=aCard.suit;
		this.num=aCard.num;
	}
	
	public Suits get_suit(){
		return suit;
	}
	
	public Numerals get_numeral(){
		return num;
	}
	
	
	public int compareTo(Card otherCard){
	
		return num.compareTo(otherCard.num);
		
	}
	
	public boolean equals(Object other){
		if(other==null) return false;
		if(other.getClass()!=this.getClass()) return false;
		Card compar = (Card)other;
		return this.num.compareTo(compar.num)==0;
		
		
		
		
	}


}
