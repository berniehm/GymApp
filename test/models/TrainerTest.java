package models;




import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bernadette Murphy on the 21/05/17
 * This will be a class to test the code in the original Trainer class
 */
public class TrainerTest {
    private Trainer premMember1, premMember2, premMember3;

    @Before
    public void setUp() throws Exception {
        premMember1 = new Trainer("nedflanders@gmail.com", "Ned Flanders", "Springfield", "M", "Skipping");
        premMember2 = new Trainer("margesimpson@gmail.com", "Marge Simpson", "Springfield", "F", "Running");
        premMember3 = new Trainer("kerrykat@gmail.com", "Kery Katone", "Springfield", "F","ZumbaDancing");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSpeciality() throws Exception {
        assertEquals("Skipping", premMember1.getSpeciality());
        assertEquals("Running", premMember2.getSpeciality());
        assertEquals("ZumbaDancing", premMember3.getSpeciality());
    }

    @Test
    public void getEmail() throws Exception {
        assertEquals("nedflanders@gmail.com", premMember1.getEmail());
        assertEquals("margesimpson@gmail.com", premMember2.getEmail());
        assertEquals("kerrykat@gmail.com", premMember3.getEmail());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Ned Flanders", premMember1.getName());
        assertEquals("Marge Simpson", premMember2.getName());
        assertEquals("Kerry Katone", premMember3.getName());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("Springfield", premMember1.getAddress());
        assertEquals("Springfield", premMember2.getAddress());
        assertEquals("Springfield", premMember3.getAddress());
    }

    @Test
    public void getGender() throws Exception {
        assertEquals("M", premMember1.getGender());
        assertEquals("F", premMember2.getGender());
        assertEquals("F", premMember3.getGender());
    }

    @Test
    public void setEmail() throws Exception {

        premMember1.setEmail("nedflanders@gmail.com");
        assertEquals("nedflanders@gmail.com", premMember1.getEmail());

        premMember2.setEmail("margesimpson@gmail.com");
        assertEquals("margesimpson@gmail.com", premMember2.getEmail());

        premMember3.setEmail("kerrykat@gmail.com");
        assertEquals("kerrykat@gmail.com", premMember3.getEmail());
    }

    @Test
    public void setName() throws Exception {

        //30 characters long
        premMember1.setName("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww");
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwwwwwwww", premMember1.getName());
        //31 characters long
        premMember2.setName("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        assertEquals("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx", premMember2.getName());
        //29 characters long
        premMember3.setName("yyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        assertEquals("yyyyyyyyyyyyyyyyyyyyyyyyyyyyy", premMember3.getName());
    }

    @Test
    public void setAddress() throws Exception {

        premMember1.setAddress("SpringField3");
        assertEquals("SpringField3", premMember1.getAddress());

        premMember2.setAddress("SpringField4");
        assertEquals("SpringField4", premMember2.getAddress());

        premMember3.setAddress("SpringField5");
        assertEquals("SpringField5", premMember3.getAddress());
    }

    @Test
    public void setGender() throws Exception {

        //Changing M to F
        premMember1.setGender("F");
        assertEquals("F", premMember1.getGender());

        //Changing M to Z
        //getGender() should return M
        premMember2.setGender("Z");
        assertEquals("M", premMember2.getGender());


        //Changing F to male
        //should return M
        premMember3.setGender("male");
        assertEquals("M", premMember3.getGender());
    }

    @Test
    public void testToString() throws Exception {

        assertEquals("NAME...........Ned Flanders" + "\n" +
                "EMAIL..........nedflanders@gmail.com" + "\n" +
                "GENDER.........M" + "\n" +
                "SPECIALITY.....Skipping", premMember1.toString());

        assertEquals("NAME...........Marge Simpson" + "\n" +
                "EMAIL..........margesimpson@gmail.com" + "\n" +
                "GENDER.........F" + "\n" +
                "SPECIALITY.....Running", premMember2.toString());

        assertEquals("NAME...........Kery Katone" + "\n" +
                "EMAIL..........kerrykat@gmail.com" + "\n" +
                "GENDER.........F" + "\n" +
                "SPECIALITY.....ZumbaDancing", premMember3.toString());
    }
}
