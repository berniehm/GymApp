package controllers;

import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This class will contain test code for the original GymApi Class 
 * 
 */
public class GymApiTest {
    private GymApi emptyGym, populatedGym;
    private List<Trainer> noTrainer, haveTrainer;
    private List<Member> noMember, haveMember;
    private Member member1;
	Member member2;
    private Trainer trainer1, trainer2;

    @Before
    public void setUp() throws Exception {
        //member1 = new StudentMember("lisasimpson@gmail.com", "Studentmember4", "4", "F", 3, 250, "20077699", "CIT");
       // member2 = new PremiumMember("nedflanders@gmail.com", "Premium 6", "Premium 2 Gym","M", 3.0, 252);

        trainer1 = new Trainer("nedflanders@gmail.com","NedFlanders", "Springfield"
                , "M", "skipping");
        trainer2 = new Trainer("margesimson@gmail.com", "Marge Simpson", "Springfield"
            , "FEMALE", "Running");

        noTrainer = new ArrayList<>();
        haveTrainer = new ArrayList<>();
        haveTrainer.add(trainer1);
        haveTrainer.add(trainer2);

        noMember = new ArrayList<>();
        haveMember = new ArrayList<>();
        haveMember.add(member1);
        haveMember.add(member2);

        emptyGym = new GymApi();
        populatedGym = new GymApi();
        populatedGym.getMembers().add(member1);
        populatedGym.getMembers().add(member2);
        populatedGym.getTrainers().add(trainer1);
        populatedGym.getTrainers().add(trainer2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstructors() {
        assertEquals(true, emptyGym.getMembers().isEmpty());
        assertEquals(true, emptyGym.getTrainers().isEmpty());
        assertEquals(false, populatedGym.getTrainers().isEmpty());
        assertEquals(false, populatedGym.getTrainers().isEmpty());
    }
    @Test
    public void testAddMember() throws Exception {
        assertEquals(true, emptyGym.getMembers().isEmpty());

        emptyGym.addMember(member1);
        assertEquals(1, emptyGym.getMembers().size());
        assertEquals("studentMember2@gmail.com", emptyGym.getMembers().get(0).getEmail());

        emptyGym.addMember(member2);
        assertEquals(2, emptyGym.getMembers().size());
        assertEquals("", emptyGym.getMembers().get(1).getEmail());
    }

    @Test
    public void testAddTrainer() throws Exception {
        assertEquals(true, emptyGym.getTrainers().isEmpty());

        emptyGym.addTrainer(trainer1);
        assertEquals(1, emptyGym.getTrainers().size());
        assertEquals("", emptyGym.getTrainers().get(0).getEmail());

        populatedGym.addTrainer(trainer2);
        assertEquals(3, populatedGym.getTrainers().size());
        assertEquals("", populatedGym.getTrainers().get(1).getEmail());
    }

    @Test
    public void testNumberOfMembers() throws Exception {
        assertEquals(0, emptyGym.numberOfMembers());
        emptyGym.addMember(member1);
        assertEquals(1, emptyGym.numberOfMembers());

        assertEquals(2, populatedGym.numberOfMembers());
        populatedGym.addMember(member2);
        assertEquals(3, populatedGym.numberOfMembers());
    }

    @Test
    public void testNumberOfTrainers() throws Exception {
        assertEquals(0, emptyGym.numberOfTrainers());
        emptyGym.addTrainer(trainer1);
        assertEquals(1, emptyGym.numberOfTrainers());

        assertEquals(2, populatedGym.numberOfTrainers());
        populatedGym.addTrainer(trainer2);
        assertEquals(3, populatedGym.numberOfTrainers());
    }

    @Test
    public void testGetMembers() throws Exception {
        //The new gymApi object returns an empty ArrayList of Members
        assertEquals(0, emptyGym.getMembers().size());
        assertEquals(noMember, emptyGym.getMembers());

        //The populated gymApi object returns an ArrayList with two items
        assertEquals(2, populatedGym.getMembers().size());
        assertEquals(haveMember, populatedGym.getMembers());
    }

    @Test
    public void testGetTrainers() throws Exception {
        //The new gymApi object returns an empty ArrayList of Trainers
        assertEquals(0, emptyGym.getTrainers().size());
        assertEquals(noTrainer, emptyGym.getTrainers());

        //The populated gymApi object returns an ArrayList with two items
        assertEquals(2, populatedGym.getTrainers().size());
        assertEquals(haveTrainer, populatedGym.getTrainers());
    }

    @Test
    public void testIsValidMemberIndex() throws Exception {
        //Boundary testing the gymApi object, which has an empty ArrayList of Members.
        assertEquals(0, emptyGym.getMembers().size());
        assertEquals(false, emptyGym.isValidMemberIndex(-1));
        assertEquals(false, emptyGym.isValidMemberIndex(0));
        assertEquals(false, emptyGym.isValidMemberIndex(1));

        //Boundary testing the gymApi object which has an ArrayList of two Members.
        //lower boundary tests / fence post error testing
        assertEquals(2, populatedGym.getMembers().size());
        assertEquals(false, populatedGym.isValidMemberIndex(-1));
        assertEquals(true, populatedGym.isValidMemberIndex(0));
        assertEquals(true, populatedGym.isValidMemberIndex(1));
        //upper boundary tests / fence post error testing
        assertEquals(false, populatedGym.isValidMemberIndex(2));
    }

    @Test
    public void testIsValidTrainerIndex() throws Exception {
        //Boundary testing the gymApi object, which has an empty ArrayList of Trainers.
        assertEquals(0, emptyGym.getTrainers().size());
        assertEquals(false, emptyGym.isValidTrainerIndex(-1));
        assertEquals(false, emptyGym.isValidTrainerIndex(0));
        assertEquals(false, emptyGym.isValidTrainerIndex(1));

        //Boundary testing the gymApi object which has an ArrayList of two Trainers.
        //lower boundary tests / fence post error testing
        assertEquals(2, populatedGym.getTrainers().size());
        assertEquals(false, populatedGym.isValidTrainerIndex(-1));
        assertEquals(true, populatedGym.isValidTrainerIndex(0));
        assertEquals(true, populatedGym.isValidTrainerIndex(1));
        //upper boundary tests / fence post error testing
        assertEquals(false, populatedGym.isValidTrainerIndex(2));
    }

    @Test
    public void testSearchMembersByEmail() throws Exception {
        assertEquals(0, emptyGym.getMembers().size());
        emptyGym.addMember(member1);
        assertEquals(member1, emptyGym.searchMembersByEmail("studentMember2@gmail.com"));
        assertEquals(null, emptyGym.searchMembersByEmail("wrong@gmail.com"));

        assertEquals(2, populatedGym.getMembers().size());
        assertEquals(member2, populatedGym.searchMembersByEmail("premium2@gmail.com"));
        assertEquals(null, populatedGym.searchMembersByEmail("wrong@gmail.com"));
    }

    @Test
    public void testSearchMembersByName() throws Exception {
        assertEquals(0, emptyGym.getMembers().size());
        assertEquals("There are no members in the gym", emptyGym.searchMembersByName("Name"));
        emptyGym.addMember(member1);
        assertEquals("0 email: studentMember2@gmail.com, name: StudentNameWithThirtyCharacter, address:" +
                " Address studentMember2, gender: F , height: 3.0, starting weight: 250.0, chosen package: , " +
                "member progress: 0, Student ID: Student2Id , College: College2 Name\n", emptyGym.searchMembersByName("Student"));
        assertEquals("There are no members with the name that matches: No Match", emptyGym.searchMembersByName("No Match"));

        assertEquals(2, populatedGym.getMembers().size());
        assertEquals("1 email: premium2@gmail.com, name: Premium 2, address: Premium 2 Home, gender: F , " +
                "height: 0.0, starting weight: 0.0, chosen package: , member progress: 0\n", populatedGym.searchMembersByName("Premium"));
        assertEquals("0 email: studentMember2@gmail.com, name: StudentNameWithThirtyCharacter, address: " +
                "Address studentMember2, gender: F , height: 3.0, starting weight: 250.0, chosen package: , member progress: " +
                "0, Student ID: Student2Id , College: College2 Name\n" +
                "1 email: premium2@gmail.com, name: Premium 2, address: Premium 2 Home, gender: F , height: 0.0, " +
                "starting weight: 0.0, chosen package: , member progress: 0\n", populatedGym.searchMembersByName("m"));
    }

    @Test
    public void testSearchTrainersByEmail() throws Exception {
        assertEquals(0, emptyGym.getTrainers().size());
        emptyGym.addTrainer(trainer1);
        assertEquals(trainer1, emptyGym.searchTrainersByEmail("trainer2@gmail.com"));
        assertEquals(null, emptyGym.searchTrainersByEmail("wrong@gmail.com"));

        assertEquals(2, populatedGym.getTrainers().size());
        assertEquals(trainer2, populatedGym.searchTrainersByEmail("trainer3@gmail.com"));
        assertEquals(null, populatedGym.searchTrainersByEmail("wrong@gmail.com"));
    }

    @Test
    public void testListMembers() throws Exception {
        //The new gym object returns an empty String
        assertEquals("There are no members in the gym", emptyGym.listMembers());

        //The populated gym object returns an String listing two items
        assertEquals("0: email: studentMember2@gmail.com, name: StudentNameWithThirtyCharacter, address:" +
                        " Address studentMember2, gender: F , height: 3.0, starting weight: 250.0, chosen package: , member progress: 0, Student ID: Student2Id , College: College2 Name\n"
                        + "1: email: premium2@gmail.com, name: Premium 2, address: Premium 2 Home, gender: F , " +
                        "height: 0.0, starting weight: 0.0, chosen package: , member progress: 0\n"
                        , populatedGym.listMembers());
    }

    @Test
    public void testListMembersWithIdealWeight() throws Exception {
        assertEquals("There are no members in the gym", emptyGym.listMembersWithIdealWeight());
        
        assertEquals("There are no members in the gym with an ideal weight", emptyGym.listMembersWithIdealWeight());
        
       
        assertEquals("email: email, name: name, address: address, gender: M , height: 1.53, starting weight: 53.0," +
                " chosen package: , member progress: 0\n", emptyGym.listMembersWithIdealWeight());
        
               
       
        assertEquals("email: bartsimspson@gmail.com, name:Bart Simspon, address: Springfield, gender: M , height: 1.53, starting weight: 53.0," +
                " chosen package: , member progress: 0\n" +
                "email: studentMember3@gmail.com, name: StudentNameWithThirtyCharacte, address: Address studentMember3, gender: Unspecified , " +
        "height: 1.68, starting weight: 60.0, chosen package: , member progress: 0, Student ID: Student3Id , College: College3 Name\n", emptyGym.listMembersWithIdealWeight());
    }

    @Test
    public void testListMembersBySpecificBMICategory() throws Exception {
        assertEquals("There are no members in the gym", emptyGym.listBySpecificBMICategory("underweight"));
        
        assertEquals("There are no members in the gym in this BMI category", emptyGym.listBySpecificBMICategory("obese"));
        assertEquals("email:margesimspon@gmail.com  name:Marge Simspon , address:Springfield , gender: F , " +
        "height: 0.0, starting weight: 0.0, chosen package: , member progress: 0\n", emptyGym.listBySpecificBMICategory("underweight"));
       
       
        assertEquals("email: nedflanders@gmail.com, name: Ned Flanders, address: Springfiled, gender: M, " +
                "height: 0.0, starting weight: 0.0, chosen package: , member progress: 0\n" +
                "email: email, name: name, address: address, gender: M , height: 2.43, starting weight: 50.0," +
                " chosen package: , member progress: 0\n", emptyGym.listBySpecificBMICategory("underweight"));
    }

    @Test
    public void testListMemberDetailsImperialAndMetric() throws Exception {
        assertEquals(0, emptyGym.getMembers().size());
        assertEquals("There are no members in the gym", emptyGym.listMemberDetailsImperialAndMetric());
        
        assertEquals("LisaSimspon:\t\t250.0 kg (550.0 lbs)\t\t3.0 metres (118.1 inches).\n", emptyGym.listMemberDetailsImperialAndMetric());
        
        assertEquals("Ned Flanders:\t\t250.0 kg (550.0 lbs)\t\t3.0 metres (118.1 inches).\n" +
                "Premium 2:\t\t0.0 kg (0.0 lbs)\t\t0.0 metres (0.0 inches).\n", emptyGym.listMemberDetailsImperialAndMetric());
        Assessment assessment = new Assessment (70, 241,120, 411, 210, 30, "comment", trainer1);
       
        assertEquals("NedFlanders:\t\t250.0 kg (550.0 lbs)\t\t3.0 metres (118.1 inches).\n" +
                "Premium 2:\t\t80.0 kg (176.0 lbs)\t\t0.0 metres (0.0 inches).\n", emptyGym.listMemberDetailsImperialAndMetric());
    }
}