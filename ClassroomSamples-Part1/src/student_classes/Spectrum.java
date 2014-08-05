package student_classes;

import javax.swing.JOptionPane;
/**
 * Simple example of a <code>enum</code> (enumeration class) that might be used to 
 * represent the visible light spectrum as a collection of Color Names paired with
 * their corresponding range in nanometers.
 * 
 * @author UMD CS Dept.
 *
 */
public enum Spectrum {
	VIOLET (380,450),
	BLUE (451,495),
	GREEN (496,570),
	YELLOW (571, 590),
	ORANGE (591,620),
	RED (621, 750);
	
	// FIELDS
	private double lowEnd, highEnd;
	/**
	 * Observe that the "default" constructor for an enumerated class is module level.
	 * @param low
	 * @param high
	 */
	Spectrum( double low, double high ) {
		this.lowEnd=low;
		this.highEnd=high;
	}
	/**
	 * @return the lowEnd
	 */
	public double getLowEnd() {
		return lowEnd;
	}
	/**
	 * @return the highEnd
	 */
	public double getHighEnd() {
		return highEnd;
	}
	
	public static boolean inRange( double candidate, Spectrum color  ) {
		return candidate >= color.lowEnd && candidate <= color.highEnd;
	}
	
	// entry point
	public static void main( String[] args ) {
		String userInput = JOptionPane.showInputDialog("Enter a wavelength in nanometers: ");
		double dblUsersValue = Double.valueOf(userInput);
		
		for( Spectrum acolor : Spectrum.values())
			if( inRange( dblUsersValue, acolor )) {
				JOptionPane.showMessageDialog(null, "Found the color " + acolor);
				return;
			}
		JOptionPane.showMessageDialog(null, userInput + " does not match any color");
	}
}
	