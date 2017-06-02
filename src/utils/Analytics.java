/**This class will have  along with the standard constructors, getters, setters and toString methods listed below, 
 * there are specific methods that:
 *    
 *       - List all the members that have an ideal starting weight.
 *       - List all the members of a specific BMI category.
 *       - List all the members' weight and height both imperically and metrically.
 * 
 *
 */

package utils;
import models.*;
//import controllers.GymApi;
//import java.util.ArrayList;


public class Analytics{
	
	/**
     * This method calculate the BMI value for the member. BMI = KG x (Height x Height)
     *
     * @return the BMI value for the member. The number returned is truncated to two decimal places.
     */
	 public static double calculateBMI(Member member, Assessment assessment){
	        Assessment latestAssessment = member.latestAssessment();
	        return toTwoDecimalPlaces((assessment.getWeight()) / (member.getHeight() * member.getHeight()));
	    }

public static double convertWeightKGtoPounds(double weight){
    double weightPounds = weight * 2.2;
    return toTwoDecimalPlaces(weightPounds);
}
/**
 * This method determines the BMI category that the member belongs to.
 * The category is determined by the magnitude of the members BMI according to the following:
 *
 * BMI less than    15   (exclusive)                      is "VERY SEVERLY UNDERWEIGHT"
 * BMI between      15   (inclusive) and 16   (exclusive) is "SEVERELY UNDERWEIGHT"
 * BMI between      16   (inclusive) and 18.5 (exclusive) is "UNDERWEIGHT"
 * BMI between      18.5 (inclusive) and 25   (exclusive) is "NORMAL"
 * BMI between      25   (inclusive) and 30   (exclusive) is "OVERWEIGHT"
 * BMI between      30   (inclusive) and 35   (exclusive) is "MODERATELY OBESE"
 * BMI between      35   (inclusive) and 40   (exclusive) is "SEVERELY OBESE"
 * BMI greater than 40   (inclusive)                      is "VERY SEVERELY OBESE"
 *
 * @return the format of a String is similar to (note the double quotes around the category): "NORMAL".
 */
public static String determineBMICategory(double bmiValue)
{
    String bmiResult;

    if (bmiValue < 15){
        bmiResult = "VERY SEVERELY UNDERWEIGHT";
    }
    else if(bmiValue >= 15 && bmiValue < 16){
        bmiResult = "SEVERELY UNDERWEIGHT";
    }
    else if(bmiValue >= 16 && bmiValue < 18.5){
        bmiResult = "UNDERWEIGHT";
    }
    else if(bmiValue >= 18.5 && bmiValue < 25){
        bmiResult = "NORMAL";
    }
    else if(bmiValue >= 25 && bmiValue < 30){
        bmiResult = "OVERWEIGHT";
    }
    else if(bmiValue >= 30 && bmiValue < 35){
        bmiResult = "MODERATELY OBESE";
    }
    else if(bmiValue >= 35 && bmiValue < 40){
        bmiResult = "SEVERELY OBESE";
    }
    else if(bmiValue >= 40){
        bmiResult = "VERY SEVERELY OBESE";
    }
    else{
        bmiResult = "Invalid result";
    }
    return bmiResult;
}
/**
 * This method returns a boolean to indicate if the member has an ideal body weight based on the
 * Devine formula.
 * men: kg = 50 + 2.3kg per inch over 5ft
 * women: kg = 45.5 + 2.3kg per inch over 5ft
 *
 * @return Is the person at their ideal body weight
 */
public static boolean isIdealBodyWeight(Member member, Assessment assessment){
    //60 inches = 5ft
    double heightInches = convertHeightMetresToInches(member.getHeight());
    double idealWeight = 0.0;

    if(heightInches <= 60){
        if(member.getGender().equals("M")){
            idealWeight = 50.0;
        }
        else{
            idealWeight = 45.5;
        }
    }
    else if(member.getGender().equals("M")){
        idealWeight = 50 + (2.3 * (heightInches-60));
    }
    else if (member.getGender().equals("F")){
        idealWeight = 45.5 + (2.3 * (heightInches-60));
    }

    if(idealWeight >= (assessment.getWeight()-2) && idealWeight <= (assessment.getWeight()+2)){
        return true;
    }
    else{
        return false;
    }
}
/**
 * A method to truncate any double to two decimal places
*
* @return end result is a double with only 2 decimal places
*/
private static double toTwoDecimalPlaces(double num) {
   return(int)(num*100)/100.0;
}

/**
* This method returns the member height converted from metres to inches.
*
* @return member height converted from meters to inches using the formula: metres x 39.37.
*          The number returned is truncated to 2 decimal places.
*/
public static double convertHeightMetresToInches(double height){
   return toTwoDecimalPlaces(height * 39.37);
}
}
