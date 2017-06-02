package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.*;

public class StudentMemberTest{
	private StudentMember studentMember4, studentMember5,studentMember6;
	private Assessment assesment1, assessment2;
	private String date1, date2;
	private SimpleDateFormat sdf;

	 @Before
	    public void setUp() throws Exception {
    	//studentMember4 = new StudentMember("lisasimpson@gmail.com","Lisa Simspon","Springfield", "F",3.0,35, "200776699", "CIT","Student");
       //studentMember5 = new StudentMember("bartsimson@gmail.com","Bart Simspon","Springfield","M", 2, 39,   "344556677", "UL","Student");
	   //studentMember6= new StudentMember("maggiesimspon@gmail.com","Maggie Simspon","Springfield","F",1,40,"211665588","DIT","Student");
	    assesment1 = new Assessment(14, 24, 27, 46, 56, 66, "Diddly good",
                new Trainer("nedflanders@gmail.com", " NedFlanders", "Springfield", "M",
                        "skipping"));
        assessment2 = new Assessment(17, 29, 37, 47, 57, 67, "mmmmmmmmmm",
                new Trainer("margesimpson@gmail.com", "Marge Simspon", "Springfield", "F",
                        "Running"));
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        date1 = "12/12/2014";
        date2 = "13/11/2014";
        
    }
	 @After
	    public void tearDown() throws Exception {
	    }
	 @Test
	 public void testConstructor(){
		 assertEquals("lisasimpson@gmail.com",studentMember4.getEmail());
		 assertEquals("StudentNameWithThirtyCharacter", studentMember5.getCollgeName());
	        assertEquals("Address studentMember1", studentMember6.getAddress());
	        assertEquals("F", studentMember4.getGender());
	        assertEquals(17, studentMember4.getHeight(), 0);
	        assertEquals(29, studentMember4.getWeight(), 0);
	        assertEquals("200776699", studentMember4.getStudentId());
	        assertEquals("CIT", studentMember4.getCollgeName());
	        assertEquals("Student", studentMember4.getChosenPackage());
	        //assertEquals(0, studentMember4.getMemberProgress().size());
	    }
	 @Test
	    public void testGetStudentId() throws Exception {
	        assertEquals("200077669", studentMember4.getStudentId());
	        assertEquals("", studentMember5.getStudentId());
	        assertEquals("", studentMember6.getStudentId());
	    }
	 @Test
	    public void testSetStudentId() throws Exception {
		 //studentMember4.setStudentId("200776699");
		 assertEquals("200776699",studentMember4.getStudentId());}
		 @Test
		 public void testgetCollegeName()throws Exception {
			 assertEquals("CIT", studentMember4.getCollgeName());
		        assertEquals("UL", studentMember5.getCollgeName());
		        assertEquals("DIT", studentMember6.getCollgeName());
		    }
	@Test	 
	 public void testSetCollegeName()throws Exception{
		 studentMember4.setCollegeName("CIT");
		 assertEquals("CIT",studentMember4.getCollgeName());
		 studentMember5.setCollegeName("UL");
		 assertEquals("UL",studentMember5.getCollgeName());
		 studentMember6.setCollegeName("DIT");
		 assertEquals("DIT",studentMember6.getCollgeName());
	 }
	 @Test
	    public void testChosenPackage() throws Exception {
	        studentMember4.chosenPackage("CIT");
	        assertEquals("Package 3", studentMember4.getChosenPackage());
	        studentMember5.chosenPackage("Package 1");
	        assertEquals("Package 3", studentMember5.getChosenPackage());
	        studentMember6.chosenPackage("UL");
	        assertEquals("Package 3", studentMember6.getChosenPackage());
	    }
	 @Test
	    public void testStudentToString() throws Exception {
	        assertEquals("email: lisasimpson@gmail.com, name:Lisa Simpson , address: Springfield, gender: F, " +
	                "height: 3.0, starting weight: 35.0, chosen package:student , member progress: 0, Student ID:200776699  , College: CIT", studentMember4.toString());
	        assertEquals("email:bartsimson@gmail.com, name:Bart Simpson , address: Springfield, gender: F , " +
	                "height: 3.0, starting weight: 250.0, chosen package:student , member progress: 5, Student ID: 344556677 , College:UL ", studentMember5.toString());
	        assertEquals("email:maggiesimspon@gmail.com  name:Maggie Simspon , address:  Springfield, gender: M , " +
	                "height: 0.0, starting weight: 0.0, chosen package:student , member progress: 3, Student ID: 211665588 , College: DIT Name", studentMember6.toString());
	    }
	 @Test 
	 public void getAddress()throws Exception{
		 assertEquals("Springfield", studentMember4.getAddress());
	        assertEquals("Springfield", studentMember5.getAddress());
	        assertEquals("Springfield", studentMember6.getAddress());
	    }
		 
	 }