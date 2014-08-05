package student_classes;
/**
 * A "mixin" class only exists to be used by subordinate classes.
 * Essentially, this mixin implements two accessors, one for each
 * dimension, a toString and an equals method.
 * 
 * @author CS Dept.
 *
 * @param <T> any Numeric Object type.
 */
public abstract class TwoSpaceMixin<T extends Number> implements Space {
	private T	x_pos;
	private T	y_pos;
	
	public TwoSpaceMixin( T xPos, T yPos ) {
		this.x_pos = xPos;
		this.y_pos = yPos;
	}
	
	public T getXPos() { return this.x_pos; }
	public T getYPos() { return this.y_pos; }
	
	/* overrides */
	/**
	 * Two subordinate objects of this class are equal only
	 * when their coordinates are likewise equal.
	 */
	@SuppressWarnings("unchecked")
	public boolean equals( Object other ) {
		if( other instanceof TwoSpaceMixin ) 
			return x_pos.equals(((TwoSpaceMixin<T>) other).x_pos )
					&& y_pos.equals(((TwoSpaceMixin<T>) other).y_pos );
		else return false;
	}
	/**
	 * Standard toString just prints the pair
	 */
	public String toString() {
		return "(" + x_pos +", " + y_pos + ")";
	}
	
	
	/* required method: must be implemented by subclass */
	public abstract T distance( TwoSpaceMixin<T> other );


}
