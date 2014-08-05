package utilities;
import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * Essentially, the <code>Utilities</code> class is a collection of static methods that
 * perform various computations relevant to computing common and accrued interest.
 * @author UMD CS Department
 *
 */
public class Utilities {
    /**
     * Implements a simple interest computation, viz. \f[
     * SI = principle \times \dfrac{percentage}{100} \times years + principle
     * \f]
     * where \f$SI\f$ is simple interest, and the other variables are self-explanatory.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    
    public static double simpleInterest(double principal, double ratePercentage, double years) {
        return principal * ratePercentage / 100 * years + principal;
    }
    /**
     * Pretty print (displays) the Simple Interest --note this method 
     * use  <code>formattedCurrency</code>, defined within your class.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static String formattedSimpleInterest(double principal, double ratePercentage, double years) {
        return formattedCurrency(simpleInterest(principal, ratePercentage, years));
    }
    /**
     * To compute compound interest, use the following formula:
     * \f[
     * CI = principle \times \left(\dfrac{1+percentage}{100}\right)^{years}
     * \f]
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static double compoundInterest(double principal, double ratePercentage, double years) {
        double returnValue = principal;
        for (int i = 0; i < years; i ++)
            returnValue = returnValue * (1 + ratePercentage / 100);
        return returnValue;
    }
    /**
     * Pretty print the computed compound interest --note, this method should use
     * the <code>formattedCurrency</code> method.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static String formattedCompoundInterest(double principal, double ratePercentage, double years) {
        return formattedCurrency(compoundInterest(principal, ratePercentage, years));
    }
    /**
     * Use Java's <code>NumberFormat</code> to format the currency values to US (which will be
     * the default <em>locale</em>.
     * @param value
     * @return
     */
    private static String formattedCurrency(double value) {
        return  NumberFormat.getCurrencyInstance().format(value);

    }
    /**
     * Return a delimited <code>String</code> (that is, a string with carriage returns, etc.) suitable 
     * for display in the GUI.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static String simpleInterestTable(double principal, double ratePercentage, int years) {
        String returnValue = "Principal: " + formattedCurrency(principal) + " , Rate: " + new DecimalFormat(".#").format(ratePercentage) + "\n" + "Year, Simple Interest Amount \n";
        for (int i = 1; i <= years; i ++)
            returnValue += i + "-->" + formattedSimpleInterest(principal, ratePercentage, i) + "\n";
        return returnValue;
        
        
        
    }
    /**
     * Return a <code>String</code> containing necessary information formatted to suit the 
     * GUI.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static String compoundInterestTable(double principal, double ratePercentage, int years) {
        String returnValue = "Principal: " + formattedCurrency(principal) + " , Rate: " + new DecimalFormat(".#").format(ratePercentage) + "\n" + "Year, Compound Interest Amount \n";
        for (int i = 1; i <= years; i ++)
            returnValue += i + "-->" + formattedCompoundInterest(principal, ratePercentage, i) + "\n";
        return returnValue;
    }
    /**
     * Return a <code>String</code> embodying all of the relevant information for these interest
     * computations. Note, the string that this method creates should be suitable for display
     * in the GUI.
     * @param principal
     * @param ratePercentage
     * @param years
     * @return
     */
    public static String bothInterestsTable(double principal, double ratePercentage, int years) {
        String returnValue = "Principal: " + formattedCurrency(principal) + " , Rate: " + new DecimalFormat(".#").format(ratePercentage) + "\n" + "Year, Simple Interest Amount, Compound Interest Amount \n";
        for (int i = 1; i <= years; i ++)
            returnValue += i + "-->" + formattedSimpleInterest(principal, ratePercentage, i) + "-->" + formattedCompoundInterest(principal, ratePercentage, i) + "\n";
        return returnValue;
    }

}