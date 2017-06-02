
package models;

import java.util.Date;
import java.util.Map;

/**
 * A concrete subclass of Member that holds no additional data.
 *
 *@author Bernadette Murphy 
 *@version 1.0 14/05/17
 */

public abstract class PremiumMember extends Person{

 
    /**
     * Constructor for PremiumMember class
     * stores the members email, name, address, gender, height, startingWeight and chosenPackage
     */

	
	public PremiumMember(String email, String name, String address, String gender, double height, double startingWeight,
            String chosenPackage) {
super (email, name, address, gender, chosenPackage);
}
		

 
   

  @Override
 public  Object chosenPackage(String packageChoice){

     return chosenPackage(packageChoice);
    }





public Map<Date, Assessment> getMemberProgress() {
	return getMemberProgress();}





public double getHeight() {
	
	return getHeight();
}





public double getStartingWeight() {
	
	return getStartingWeight();
}





public String getChosenPackage() {
	
	return getChosenPackage();
}





public double setHeight(double d) {
	return getHeight();
	
}





public double setStartingWeight(int d) {
	return getStartingWeight();
}





public Object  latestAssessment() {
	
	return latestAssessment(); 
}







}

