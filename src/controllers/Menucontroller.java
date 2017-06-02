package controllers;

import models.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.lang.String;
import static utils.ScannerInput.*;
/**
 * This class allows the user to interact with the app
 *It displays a series of menus Trainer Menu,Member Menu
 *Trainer menu 
 *------------------
 *r)Add a  new member
 *1)List all members 
 *2)Search for a member by email 
 *3)Search a member by name 
 *4)List members with ideal body weight
 *5)List members with a specfic BMI category
 *This menu will also have a n assessment submenu and a reports sub menu
 *
 *Member Menu 
 *------------
 *1)view their profile 
 *2)Update their profile 
 *Progress sub-menu
 *------------------
 *1)View progress by weight
 *2)View progress by chest measurement
 *3)View progress by thigh measurement 
 *4)View progress by upperarm measurement 
 *5)View progress by waist measurement
 *6)View progress by hips measurement 
 * 
 * @author Bernadette Murphy
 *@version 1.0(12/05/17)
 *
 */
public class Menucontroller
{
    private GymApi gymApi = new GymApi();
    private String gobackToMenu="Bringing you back to  the last Menu ";

    public static void main(String[] args)
    {
        new Menucontroller();
        
    }

    public Menucontroller(){
    	Scanner input = new Scanner(System.in);
    	

     //  Object packages;
	//((Object) packages).put("Package 1", "Allowed access anytime to gym.\nFree access to all classes." +
    //            "\nAccess to all changing areas including deluxe changing rooms.");
      //  ((Object) packages).put("Package 2", "Allowed access anytime to gym.\n€3 fee for all classes.\n" +
      //         "\nAccess to all changing areas including deluxe changing rooms.");
     //   ((Object) packages).put("Package 3", "Allowed access to gym at off-peak times.\n€5 fee for all classes.\n" +
      //          "\nNo access to deluxe changing rooms.");
     //   ((Object) packages).put("WIT", "Allowed access to gym during term time.\n€4 fee for all classes.\n" +
       //         "\nNo access to deluxe changing rooms.");
    
        runMenu();
    }

    /**
     * 
     *
     * @return The users menu choice
     */
    private String mainMenu() {


        System.out.println("\t+ = = = = = = = = = = = = = = = = = = = +");
        System.out.println("\t|        Welcome to the Gym              |");
        System.out.println("\t|          ___   __                      |");
        System.out.println("\t|          | |___| |     O               | ");
        System.out.println("\t|          |_|   |_|     |/              |");
        System.out.println("\t|                       /|               | ");
        System.out.println("\t|                       /|               |");
        System.out.println("\t+ = = = = = = = = = = = = = = = = = = = +");
        System.out.println("Choose an option");
        System.out.println("");
        System.out.println(" l) Login");
        System.out.println(" r) Register");
        System.out.println(" 0) Exit");
        System.out.println("");
        String option = validNextString("->");
        return option.toLowerCase() ;
    }

    //This is the method that controls the loop
    private void runMenu(){
        String option = mainMenu();
       // while(!option.){
            switch(option){
                case "l":
                    //brings the user to the log in menu
                    login();
                    break;

                case "r":
                    //allows a new person to be registered
                   addMember();
                    break;

                case "a":
                    updateMember(gymApi.getMembers().get(0));
                break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            option = mainMenu();
        }
        //the user chose option 0, so exit the program
        //System.out.println("Exiting... bye");
     //   System.exit(0);

   // }

    /**
     * If the user has selected to login they will be asked if they're a member or trainer. This
     * will be to know which array(members or trainers) to search when asked for an email to log in.
     * It will also let the method know which menu to display.
     */
    private  void login(){

       
        String personLogin= "";


       
        //This is checking if they're a member or trainer
        String personType = validNextString("Are you a Member or a Trainer? (M or T)");
        //ensuring what the entered it upper case
        personType = personType.toUpperCase();

        //if they have not entered 'm' or 't' then the user will be brought back to the menu
        //matches.matches("[0-9]+")
        if(!personType.equals("M") && !personType.equals("T")){
            //Telling the user they inputed the wrong value  
            System.out.println("Invalid option entered: " + personType +
                                "\nReturning to Menu.");
          
            //returns to main menu
            return;
        }
    
    else if(personType.equals("M")){
        personLogin = "MEMBER";
    }
    else if(personType.equals("T")){
        personLogin = "TRAINER";
    }
  
       

        System.out.println(personLogin +"LOGIN SCREEN:");

        //asking for users email
        String personEmail = validNextString("Enter Your Email:");

        //If user typed M just above AND it finds their email address then it will launch the member menu
        if (personType.contains("M") && gymApi.searchMembersByEmail(personEmail) != null){
            memberMenu(personType, gymApi.searchMembersByEmail(personEmail));
        }
        //If user typed T just above AND it finds their email address then it will launch the trainer menu
        else if(personType.contains("T") && gymApi.searchTrainersByEmail(personEmail) != null){
            trainerMenu(personType, gymApi.searchTrainersByEmail(personEmail));
        }
        //if neither turn out to be true the user will be returned to menu
        else {
            System.out.println("Invalid Email entered: " + personEmail +
                    "\nReturning to Menu.");
            //Program is paused for 3.5 seconds to allow reading time
            
            //Clears screen of previous text from above
           
        }
    }

    /**
     * 
     * @param menuType
     * @return
     */
    private int loginMenu(String menuType) {

        String profileChoices = "";

        switch(menuType) {
            case "M":
                profileChoices = " 1) View Profile\n" +
                        " 2) Update Profile\n" +
                        " 3) Progress Sub-Menu\n\n" +
                        " 0) Return to Main Menu";
                break;

            case "T":
                profileChoices = " 1) Add New Member\n" +
                        " 2) List All Members\n" +
                        " 3) Search For Member By Email\n" +
                        " 4) Search For Member By Name\n" +
                        " 5) List Members By Ideal Body Weight\n" +
                        " 6) List Members With A Specific BMI\n" +
                        " 7) Assessment Sub-Menu\n" +
                        " 8) Reports Sub-Menu\n\n" +
                        " 0) Return to Main Menu";
                break;

            case "memberProgress":
                profileChoices = " 1) View progress by weight\n" +
                        " 2) View progress by chest measurement\n" +
                        " 3) View progress by thigh measurement\n" +
                        " 4) View progress by upper arm measurement\n" +
                        " 5) View progress by waist measurement\n" +
                        " 6) View progress by hips measurement";
                break;

            case "trainerAssessmentMenu":
                profileChoices = " 1) Add an assessment for a member\n" +
                        " 2) Update comment on an assessment for a member\n";
                break;

            case "trainerReportsMenu":
                profileChoices = " 1) Specific member progress (via email search)\n" +
                        " 2) Specific member progress (via name search)\n" +
                        " 3) Overall members’ report\n";
                break;

            default:
                profileChoices = "loginMenu Switch Error";
        }


        System.out.println("Enter the number for the action you wish to take:");
        System.out.println("");
        System.out.println(profileChoices);
        System.out.println("");
        System.out.println(" 0) Previous Menu");
        int option = validNextInt("");
        return option;
    }


    private void memberMenu(String personType, Member currentMember){
        int option = loginMenu(personType);
        while(option != 0){
            switch(option){
                case 1:
                    System.out.println(currentMember.toString()+ hasLatestAssessments(currentMember));
                    validNextString("Press  to return");
				char[] goingbackToMenu = null;
				System.out.println(goingbackToMenu);
                    break;
                case 2:
                    updateMember(currentMember) ;
                    try {
                    	gymApi.save();
                    }
                    catch (Exception e ){
                    	System.out.print(e.toString());
                    }
                	
                    break;

                case 3:
                    //Progress Menu that will let them see their current measurements
                    memberProgress(currentMember);
                    break;
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
            

            option = loginMenu(personType);
        }
        //the user chose option 0, so exit the program
        //System.out.println("Exiting... bye");
        //System.exit(0);
    }

    private String hasLatestAssessments(Member currentMember) {
	String assessment = null;
	return assessment;
	}

	private Object updateMember(Member currentMember) {
		Object memberupdate = null;
		return memberupdate;
	}

	private void trainerMenu(  String Member, Trainer currTrainer){
        int option = loginMenu( Member);
        while(option != 0){
            switch(option){
                case 1:
                    addMember();
                    break;

                case 2:
                	System.out.println(GymApi.listMembers());
                    break;

                case 3:
                    //Search members by email;
                	System.out.println(GymApi.searchMembersByEmail(Member));
                    break;

                case 4:
                    //Search members by name;
                	System.out.println(GymApi.searchMembersByName(Member));
                    break;


                case 5:
                    //List members with ideal body weight;
                	 System.out.println(GymApi.listMembersWithIdealWeight());
                    break;


                case 6:
                    // List members with a specific BMI category;
                	System.out.println(GymApi.listBySpecificBMICategory(Member));
                    break;


                case 7:
                    trainerAssessSubMenu(currTrainer);
                    break;


                case 8:
                    trainerReportsSubMenu();
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            option = loginMenu(Member);
        }
        
        
    
    }

    private void memberProgress(Member presentMember){
        int option = loginMenu("memberProgress");
        while(option != 0){
            switch(option){
                case 1:
                    System.out.println(presentMember.latestAssessment().getWeight());
                    break;

                case 2:
                    System.out.println(presentMember.latestAssessment().getChest());
                    break;

                case 3:
                    System.out.println(presentMember.latestAssessment().getThigh());
                    break;

                case 4:
                    System.out.println(presentMember.latestAssessment().getUpperArm());
                    break;

                case 5:
                    System.out.println(presentMember. latestAssessment().getWaist());
                    break;

                case 6:
                    System.out.println(presentMember.latestAssessment().getHips());
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            option = loginMenu("");
        }
        //the user chose option 0, so exit the program
        //System.out.println("Exiting... bye");
        //System.exit(0);

    }

    private void trainerAssessSubMenu(Trainer currTrainer){

        int option = loginMenu("trainerAssessmentMenu");
        while(option != 0){
            switch(option){
                case 1:
                    //Add assessment for member;
                    break;

                case 2:
                    //Update comment and assessment for member;
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }

            option = loginMenu("trainerAssessmentMenu");
        }
    }

    private void trainerReportsSubMenu(){
        int option = loginMenu("trainerReportsMenu");
        while(option != 0){
            switch(option){
                case 1:
                    //Specific member progress (via email search). Note: brings the user to memberProgress()
                    break;

                case 2:
                    //. Specific member progress (via name search). Note: brings the user to memberProgress()
                    break;

                case 3:
                    //Overall members’ report;
                    break;

                default:
                    System.out.println("Invalid option entered: " + option);
                    break;
            }
        }
    }

           // option = loginMenu("");
      //  }
    
private void addMember()
{
	{Scanner input = new Scanner(System.in);
        System.out.println("Please enter the following member details...");
        System.out.print("\tId (between 100001 and 999999): ");
        int memberId = input.nextInt();
        System.out.print("\tName (max 30 chars): ");
        String memberName = input.nextLine();
        memberName = input.nextLine();
        System.out.print("\tAddress: ");
        String memberEmail = input.nextLine();
        System.out.print("\tEmail with***@.*** ");
        memberEmail=input.nextLine();
        String memberAddress = input.nextLine();
        System.out.print("\tHeight (between 1 and 3 metres): ");
        double height = input.nextDouble();
        System.out.print("\tStarting weight (between 35kg and 250kg): ");
        double startingWeight = input.nextDouble();
        System.out.print("\tGender (M/F): ");
        String gender = input.next().toUpperCase();
        

       // GymApi.add(new Member(memberId, memberName,memberEmail, memberAddress, 
              //  height, startingWeight, gender));
    }
}
    }







