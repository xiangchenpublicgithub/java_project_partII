package model;

import student_classes.TwoSpaceMixin;
/**
 * Our model consists of Moving Objects, such as People, animals, and
 * machines. Each of these will use this class as its common basis.
 * 
 * @author CS Dept.
 */
public class MovingObject extends TwoSpaceMixin< Double > {

	public MovingObject( Double xPos, Double yPos ) {
		super( xPos, yPos );
	}

	@Override
	public Double distance( TwoSpaceMixin< Double > other ) {
		Double otherXPos = other.getXPos();
		Double otherYPos = other.getYPos();
		Double difference = Math.pow( ( this.getXPos() - otherXPos ), 2 )
				+ Math.pow( this.getXPos() - otherYPos, 2 );
		return Math.sqrt( difference );
	}

}
