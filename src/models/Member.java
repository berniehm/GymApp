/**
 * This is a Subclass of the Person Class
 * The details that will be stored for a member include:
 *      A members height
 *      Starting Weight
 *      Chosen package
 *      Hashmap
 * @author Bernadette Murphy 
 * @version1.0(02/05/2017)
 */



package models;
import java.util.*;
import java.util.Date;
import java.util.HashMap;
import java.util.SortedSet;




public abstract class Member extends Person{
	
    private double height;
    private double startingWeight;
    private static String chosenPackage;
    private HashMap<Date, Assessment> trainerAssessment= new HashMap <>();
    
    /**
     * Constructor for objects of class Member.
     *
     * @param height The Member's height must be greater than or equal to 1 meter minimum(inclusive) and maximum height
     *                of 3 meters(inclusive).
     *
     * @param chosenPackage2 The Member's weight upon joining the gym must be 
     *              35kg minimum weight inclusive and maximum of 250kg(inclusive )is allowed in the gym.
     *              
     *   @param chosenPackage-A member can choose two packages :Premium and Student.If not specified default to "Unspecified"           
     */
    public Member(String email, String name, String address, String gender, double height, double startingWeight, String chosenPackage){

        super(chosenPackage, chosenPackage, chosenPackage, chosenPackage, chosenPackage);

		
        if ((height >= 1) && (height <= 3))
        {
            this.height = height;
        }
        if ((startingWeight >= 35) && (startingWeight <= 250)){
            this.startingWeight = startingWeight;
        }
    if (chosenPackage.toUpperCase().equals("PREMIUM")||chosenPackage.toUpperCase().equals("STUDENT")){
    	this.chosenPackage =chosenPackage;
    }
    else{
    	this.chosenPackage= "Unspecifed";
    }
    
    }

    


   
 
    //********************************************************************************
    //  GETTERS
    //********************************************************************************

   
	






	






	/**
     * Returns the member's height.
     * @return the member's height.
     */
    public double getHeight() {

        return height;
    }
    /*
     * Returns chosen package
     * @return the chosen package
     */
    public static String getChosenPackage() {
        return chosenPackage;
    }
    /**
     * Returns the member's starting weight.
     * @return the member's starting weight.
     */
    public double getWeight() {
        return startingWeight;
    }
    public String getGender() {
		
		return getGender();
	}






	public String getEmail() {
		
		return getEmail();
	}






	public String getName() {
		
		return getName();
	}

    /**
     * Returns the hash map of assessments
     * @return the hash map of assessments
     */
    public HashMap<Date, Assessment> getAssessments(){

        return trainerAssessment;
    }
    
    //-------
    //SETTERS
    //-------

    /**
     * Updates the member's height
     * @param height Updates the member's height
     */
    public void setHeight(double height) {
        if(height >= 1.0 && height <= 3.0) {
            this.height = height;
        }
    }

    /**
     * Updates the member's starting weight
     * @param startingWeight Updates the member's starting weight
     */
    public void setWeight(double startingWeight) {
        if(startingWeight >= 35 && startingWeight <= 250) {
            this.startingWeight = startingWeight;
        }
    }
    
    public void setChosenPackage(String chosenPackage) {
    	if(chosenPackage.toUpperCase().equals ("PREMIUM") || chosenPackage.toUpperCase().equals("STUDENT")){
        this.chosenPackage = chosenPackage;
    	}
    }

    //--------------
    //HELPER METHODS
    //--------------



    /**
     * Adds a new assessment to the  Assessment HashMap
     * @param newAssessment to be added to the assessment HashMap
     */
    public void addAssessment(Assessment newAssessment){

        trainerAssessment.put(new Date(), newAssessment);
    }

    /**
     * Returns the latest assessment based on last entry (by calendar date).
     * @return Returns the latest assessment based on last entry (by calendar date).
     */
    public Assessment latestAssessment(){

        return trainerAssessment.get(sortedAssessmentDates().last());

    }

    /**
     * Returns the first assessment based on the first entry (by calendar date).
     * @return Returns the first assessment based on the first entry (by calendar date).
     */
    public String progressAssessment(String option)
    {
        String assessProgress = "";

        switch(option){
            case "weight":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getWeight() + "kg";
                }
                assessProgress = "\n" + "Starting Weight:\n" + getWeight() + "kg" + assessProgress;
                break;

            case "chest":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getChest() + "cm";
                }
                break;

            case "thigh":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getThigh() + "cm";
                }
                break;

            case "upperArm":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getUpperArm() + "cm";
                }
                break;

            case "waist":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getWaist() + "cm";
                }
                break;

            case "hips":
                for (Date date : sortedAssessmentDates())
                {
                    assessProgress += "\n" + date + "\n" + trainerAssessment.get(date).getHips() + "cm";
                }
                break;

        }

        return assessProgress;
    }

    /**looked at stack overflow for help with this 
     * Returns the assessments dates sorted in date order.
     * @return Returns the assessments dates sorted in date order.
     */
    public SortedSet<Date> sortedAssessmentDates(){

        return new TreeSet<>(trainerAssessment.keySet());
    }

    /**
     * Adds a new hashmap of assessments to the the member's Assessment HashMap
     */
    public void addAllAssessments(HashMap<Date, Assessment> allAssessments){

        trainerAssessment.putAll(allAssessments);
    }

    public Object chosenPackage(String packageChoice){
    return chosenPackage(packageChoice);}

    /**
     * Returns a human readable String interpretation of the member's details
     * @return A string version of the member object.
    */
    @Override
    public String toString() {
        return  "NAME..........." + getName() + "\n" +
                "EMAIL.........." + getEmail() + "\n" +
                "GENDER........." + getGender() + "\n" +
                "HEIGHT........." + getHeight() + "\n" +
                "START WEIGHT..." + getWeight();
    }
}






	
