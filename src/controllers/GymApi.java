/**
 * 
 * This class handles a collection of Members and Trainers 
 *
 * The details stored for a gym include:
 *     
 *      An ArrayList collection of its Members
 *   
 * Along with the standard constructors, getters, setters and toString methods listed below, 
 * there are specific methods that:
 *    
 * -Returns a boolean indicating if the index passed as a parameter a valid index for the member's array list.       
 * -Returns a boolean indicating if the index passed a parameter is a valid index for the trainers array list . 
 * -Searches for a members email 
 * -Searches for a members name
 * -Searches for trainers email 
 * -Searches for a trainers name
 * -Lists members in the array list 
 * -List members with the ideal weight 
 * -List members by specific BMi Category
 * -Lists members imperically and Metreically
 * -Allows these details to be stored
 * -Allows these details to be loaded 
 * @author Bernadette Murphy
 * @version 1 12/05/17
 */
    
package controllers;


import models.*;
import utils.Analytics;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import java.util.ArrayList;
import java.util.Iterator;

public class GymApi {

   public static ArrayList<Member> members;
    public ArrayList<Trainer> trainers;

    public GymApi(){

        members = new ArrayList<>();
        trainers = new ArrayList<>();
try {
	load();
}

catch (Exception e){
	System.out.print(e.toString());
}

 }
      
   
   
		
		
	


	/**
     * Adds a member class to the members array
     * @param member1 Adds a member class to the members array
     */
    public void addMember(Member member1){

        members.add(member1);
    }
    /**
     * Deletes a member from a member class to the members array
     * @param
     */
    public void removeMember(Member member){
    	members.remove(member);
    }

    /**
     * Adds a trainer class to the trainers array
     * @param trainer Adds a member class to the trainers array
     */
    public void addTrainer(Trainer trainer){

        trainers.add(trainer);
    }

    /**
     * Returns the size of the members array list
     * @return Returns the size of the members array list
     */
    public int numberOfMembers(){

        return members.size();
    }

    /**
     * Returns the size of the trainers array list
     * @return Returns the size of the trainers array list
     */
    public int numberOfTrainers(){

        return trainers.size();
    }

    /**
     * Provides information of all the members in the members array
     * @return Information of all the members in the members array
     */
    public ArrayList<Member> getMembers(){
        return members;
    }

    /**
     * Provides information of all the trainers in the trainers array
     * @return Information of all the trainers in the trainers array
     */
    public ArrayList<Trainer> getTrainers() {
        return trainers;
    }

    /**
     * Returns a boolean indicating if the index passed as a parameter is a valid index for the
     * members array list.
     * @param index the index to be tested
     * @return A boolean to determine if the index is valid
     */
    public boolean isValidMemberIndex(int index){
        if(index < (members.size())){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns a boolean indicating if the index passed as a parameter is a valid index for the
     * trainers array list.
     * @param index the index to be tested
     * @return A boolean to determine if the index is valid
     */
    public boolean isValidTrainerIndex(int index){
        if(index < (trainers.size())){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method that when called will loop through the members array and try to find an email
     * that matches one the user has inputted
     *
     * @param emailEntered The email inputted by the user
     * @return A member object that has a matching email or a simple null
     */
    public static Member searchMembersByEmail(String emailEntered){

        //Will  contain members emails if one is found
        Member foundMember = null;

       for(Member member : members){

            
            if(emailEntered.equals(member.getEmail())){
                foundMember = member;
                break;
            }
        }

        return foundMember;
    }

    /**
     * A method that when called will go through the members array list in search of members
     * whose name partially or entirely matches the entered name and return is as a String.
     *
     * @param nameEntered The email entered by the user
     * @return Returns a list of members whose name partially or entirely matches the entered name
     */
    public static String searchMembersByName(String nameEntered){

        //Will be contain member's name if one is found
        String foundMembers = "";
        int searchCounter = 0;

        for(Member member : members){

            //If the two strings match then the toString() method is called from
            //the member with the matching name and stored in foundMember
            //both strings being tested are set to lower case so the search is not case sensitive
            if(member.getName().toLowerCase().contains(nameEntered.toLowerCase())){
                foundMembers += "\n" + member.getName();
                searchCounter++;
            }
        }

        //If there are any members found to have a matching name then the results are returned
        if(searchCounter > 0){
            return "" + searchCounter + " Results found for: " + nameEntered + "\n" + foundMembers;
        }

        //if there are zero members in the members array list then it will return this string
        else if (members.size() == 0 && searchCounter == 0){
            return "no members in gym";
        }
		return foundMembers;

    }


    /**
     * A method that when called will go  through the trainers array and try to find an email
     * that matches one the user has put in
     * @param emailEntered The email put in  by the user
     *
     */
    public Trainer searchTrainersByEmail(String emailEntered){

        //Will be contain member details if one is found
        Trainer foundTrainer = null;

        for(Trainer trainer : trainers){

            
            if(emailEntered.equals(trainer.getEmail())){
                foundTrainer = trainer;
                break;
            }
        }

        return foundTrainer;
    }

    /**
     * 
     */
    public static String listMembers(){

        //string to be later returned
        String membersToString = "";

        //if there are members within the members array it will go through the array and
        //add all the information from each member object into a string that will be returned
        if(members.size() > 0){
            for(Member member : members){

                membersToString += member.toString() + "\n";
            }
            return membersToString;
        }
        else{
            return "no members in the gym";
        }
    }

   
    public String listMemberDetailsImperialAndMetric() {

        //the string to be later returned
        String memberDetails = "";
        //testing to make sure there are members in the members array
        if(members.size() > 0) {
            //for each loop to loop through the members array
            for (Member member : members) {
                //populating memberDetails with the member's Name, weight(kg & lbs) and height(meter & inches)
                memberDetails += member.getName() + ":\t"
                        + member.getWeight() + " kg ("
                        + Analytics.convertWeightKGtoPounds(member.getWeight()) + " lbs) \t"
                        + member.getHeight() + " metres ("
                        + Analytics.convertHeightMetresToInches(member.getHeight()) + " inches).\n";
            }
            return memberDetails;
        }
        else {
            return "no members in the gym";
        }
    }

  
    public static String listMembersWithIdealWeight() {
        String idealMember = "";
        Iterator var2 = members.iterator();

        while(var2.hasNext()) {
            Member member = (Member)var2.next();
            if(Analytics.isIdealBodyWeight(member, member.latestAssessment())) {
                idealMember = idealMember + member.toString() + "\n";
            }
        }

        if(members.size() > 0 && idealMember.equals("")) {
            return "There are no members in the gym with an ideal weight";
        } else if(members.size() == 0) {
            return "There are no members in the gym";
        } else {
            return idealMember;
        }
    }


   
    public static String listBySpecificBMICategory(String category) {
        //A string to be populated and returned if members are found that match the entered category
        String listBMI = "";
        //ensures what the user enters is converted to upper case
        category = category.toUpperCase();
        //loops through the members array to search for people who match the entered category
        for (Member member : members) {
            if (Analytics.determineBMICategory(Analytics.calculateBMI(member, member.latestAssessment())).contains(category)) {
                listBMI += member.toString() + "\n";
            }
        }
        //this message is returned if there are no members in the members array
        if (members.size() == 0) {
            return "No members in the gym";
        }
        //if no matches are found in a populated members array then an appropriate message is returned
        else if (members.size() > 0 && listBMI.equals("")) {

            String response;

            if(category.contains("UNDERWEIGHT")){
                response = "no members underwight!";
            }
            else if (category.contains("OBESE")){
                response = "no members obese";
            }
            else if (category.contains("NORMAL")){
                response = "no members with a normal body weight";
            }
            else{
                response = "No one by that category!";
            }
            return response;
        }
        //if matches are found the the results are returned
        else {
            return listBMI;
        }
    }

        public void save() throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("gym.xml"));
            out.writeObject(members);
            out.writeObject(trainers);
            out.close();
        }

        public void load() throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("gym.xml"));
            members = (ArrayList<Member>) is.readObject();
            trainers = (ArrayList<Trainer>) is.readObject();
            is.close();
        }

    }
