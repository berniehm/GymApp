package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * PremiumMember Test class. 
 * 
 * Created by Bernadette Murphy
 */
public class PremiumMemberTest {
    private PremiumMember premiumMember1, premiumMember2, premiumMember3;
    private Assessment assessment1, assessment2;
    private String date1, date2;
    private SimpleDateFormat sdf;

    @Before
    public void setUp() throws Exception {
       // premiumMember1 = new PremiumMember("premium1@gmail.com", "Premium 1 With A lot Of Characters", "Premium 1 Home",
           //     "M", 0.9, 34);
        //premiumMember2 = new PremiumMember("premium2@gmail.com", "Premium 2", "Premium 2 Home",
           //     "f", 3.1, 251);
        //premiumMember3 = new PremiumMember("premium3@gmail.com", "Premium 3", "Premium 3 Home",
            //    "Male", 1.75, 69);
        assessment1 = new Assessment(64, 46, 53, 53, 23, 53, "didly good",
                new Trainer("nedflanders@gmail.com", "Ned Flanders", "Springfield", "M",
                        "Skipping"));
        assessment2 = new Assessment(23, 46, 75, 34, 34, 64, "mmmmmmm",
                new Trainer("margesimpson@gmail.com", "Marge Simpson", "Springfields", "f",
                        "running"));
        sdf = new SimpleDateFormat("dd/MM/yyyy");
        date1 = "04/06/2017";
        date2 = "19/02/2014";
        premiumMember1.getMemberProgress().put(sdf.parse(date1), assessment1);
        premiumMember1.getMemberProgress().put(sdf.parse(date2), assessment2);
        premiumMember2.getMemberProgress().put(sdf.parse(date2), assessment1);
        premiumMember2.getMemberProgress().put(sdf.parse(date1), assessment2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testConstructor() {
        assertEquals("nedflanders@gmail.com", premiumMember1.getEmail());
        assertEquals("Ned flanders ", premiumMember1.getName());
        assertEquals("Springfiled", premiumMember1.getAddress());
        assertEquals("M", premiumMember1.getGender());
        assertEquals(0, premiumMember1.getHeight(), 0);
        assertEquals(0, premiumMember1.getStartingWeight(), 0);

        assertEquals("margesimspon@gmail,com", premiumMember2.getEmail());
        assertEquals("Marge Simspon", premiumMember2.getName());
        assertEquals("Springfield", premiumMember2.getAddress());
        assertEquals("F", premiumMember2.getGender());
        assertEquals(0, premiumMember2.getHeight(), 0);
        assertEquals(0, premiumMember2.getStartingWeight(), 0);

       
    }

    @Test
    public void testChosenPackage() throws Exception {
        premiumMember1.chosenPackage("premium");
        assertEquals("Some package", premiumMember1.getChosenPackage());
        premiumMember2.chosenPackage("No validation");
        assertEquals("No validation", premiumMember2.getChosenPackage());
        premiumMember3.chosenPackage("Package 3");
        assertEquals("Package 3", premiumMember3.getChosenPackage());
    }

    @Test
    public void testGetHeight() throws Exception {
        assertEquals(0, premiumMember1.getHeight(), 0);
        assertEquals(0, premiumMember2.getHeight(), 0);
        assertEquals(1.75, premiumMember3.getHeight(), 0);
    }

    @Test
    public void testSetHeight() throws Exception {
        premiumMember1.setHeight(2.99);
        assertEquals(2.99, premiumMember1.getHeight(), 0);
        premiumMember2.setHeight(1);
        assertEquals(1, premiumMember2.getHeight(), 0);
        premiumMember3.setHeight(2.3);
        assertEquals(2.3, premiumMember3.getHeight(), 0);
    }

    @Test
    public void testGetStartingWeight() throws Exception {
        assertEquals(0, premiumMember1.getStartingWeight(), 0);
        assertEquals(0, premiumMember2.getStartingWeight(), 0);
        assertEquals(69, premiumMember3.getStartingWeight(), 0);
    }

    @Test
    public void testSetStartingWeight() throws Exception {
        premiumMember1.setStartingWeight(35);
        assertEquals(35, premiumMember1.getStartingWeight(), 0);
        premiumMember2.setStartingWeight(250);
        assertEquals(250, premiumMember2.getStartingWeight(), 0);
        
    }

    @Test
    public void testGetChosenPackage() throws Exception {
        assertEquals("", premiumMember1.getChosenPackage());
        assertEquals("", premiumMember2.getChosenPackage());

    }

    @Test
    public void testGetMemberProgress() throws Exception {
        assertEquals(2, premiumMember1.getMemberProgress().size());
        assertEquals(2, premiumMember2.getMemberProgress().size());
        
    }

    @Test
    public void testSetMemberProgress() throws Exception {
        Map<Date, Assessment> progress1 = new HashMap<>();
        assertEquals(progress1, premiumMember1.getMemberProgress());
        Map<Date, Assessment> progress2 = new HashMap<>();
        assertEquals(progress2, premiumMember2.getMemberProgress());
        
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("email: nedflanders@gmail.com, name: Ned Flanders, address: Springfield, gender: M , " +
                "height: 0.0, starting weight: 0.0, chosen package: , member progress: 2", premiumMember1.toString());
        assertEquals("email: margesimpson@gmail.com, name: MargeSimspon, address: Springfield, gender: F , " +
                "height: 0.0, starting weight: 0.0, chosen package: , member progress: 2", premiumMember2.toString());
       
    }

    @Test
    public void testLatestAssessment() throws Exception {
        assertEquals(assessment1, premiumMember1.latestAssessment());
        assertEquals(assessment2, premiumMember2.latestAssessment());
        
    }

    

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("premium1@gmail.com", premiumMember1.getEmail());
        assertEquals("premium2@gmail.com", premiumMember2.getEmail());
        
    }

    @Test
    public void testSetEmail() throws Exception {
        premiumMember1.setEmail("nedflanders@gmail.com");
        assertEquals("nedflanders@gmail.com", premiumMember1.getEmail());
        premiumMember2.setEmail("Doesn't check for @ or a .");
        assertEquals("Doesn't check for @ or a .", premiumMember2.getEmail());
       
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Ned Flanders", premiumMember1.getName());
        assertEquals("Marge Simpson", premiumMember2.getName());
        
    }

    @Test
    public void testSetName() throws Exception {
        premiumMember1.setName("AnotherTestForOverThirtyCharacters");
        assertEquals("AnotherTestForOverThirtyCharac", premiumMember1.getName());
        premiumMember2.setName("Has no name");
        
    }

    @Test
    public void testGetAddress() throws Exception {
        assertEquals("Springfield", premiumMember1.getAddress());
        assertEquals("Springfield", premiumMember2.getAddress());
        
    }

    @Test
    public void testSetAddress() throws Exception {
        premiumMember1.setAddress("Springfield");
        assertEquals("Springfield", premiumMember1.getAddress());
        premiumMember2.setAddress("Springfield");
        assertEquals("Springfield", premiumMember2.getAddress());
        
    }

    @Test
    public void testGetGender() throws Exception {
        assertEquals("M", premiumMember1.getGender());
        assertEquals("F", premiumMember2.getGender());

    }

    @Test
    public void testSetGender() throws Exception {
        premiumMember1.setGender("Female");
        assertEquals("Unspecified", premiumMember1.getGender());
        premiumMember2.setGender("m");
        assertEquals("M", premiumMember2.getGender());
        
    }
}




