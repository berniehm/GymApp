package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Bernadette Murphy
 * This is class of code to test the orginal Assesment class 
 */
public class AssessmentTest {

    private Assessment assessment1, assessment2, assessment3;
    private Trainer NedFlanders, MargeSimpson, kerryKatone ;


    @Before
    public void setUp() throws Exception {

    	NedFlanders = new Trainer("nedflanders@gmail.com", "Ned Flanders", "Springfield", "M", "Skipping");
    	MargeSimpson= new Trainer("margesimpson@gmail.com", "Marge Simpson", "Springfield", "F", "Running");
        kerryKatone = new Trainer("kerryKat@gmail.com", "Kerry Katone", "Springfield", "F", "Zumba Dancing");

        assessment1 = new Assessment(14, 24, 27, 46, 56, 66, "didly good", NedFlanders);
        assessment2 = new Assessment(17, 29, 37, 47, 57, 67, "mmmmmm", MargeSimpson );
        assessment3 = new Assessment(18, 30, 38, 48, 58, 68, "Well done",kerryKatone );
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getWeight() throws Exception {
        assertEquals(14, assessment1.getWeight(), 0);
        assertEquals(17, assessment2.getWeight(), 0);
        assertEquals(18, assessment3.getWeight(), 0);
    }

    @Test
    public void getChest() throws Exception {
        assertEquals(24, assessment1.getChest(), 0);
        assertEquals(29, assessment2.getChest(), 0);
        assertEquals(30, assessment3.getChest(), 0);
    }

    @Test
    public void getThigh() throws Exception {
        assertEquals(27, assessment1.getThigh(), 0);
        assertEquals(37, assessment2.getThigh(), 0);
        assertEquals(38, assessment3.getThigh(), 0);
    }

    @Test
    public void getUpperArm() throws Exception {
        assertEquals(46, assessment1.getUpperArm(), 0);
        assertEquals(47, assessment2.getUpperArm(), 0);
        assertEquals(48, assessment3.getUpperArm(), 0);
    }

    @Test
    public void getWaist() throws Exception {
        assertEquals(56, assessment1.getWaist(), 0);
        assertEquals(57, assessment2.getWaist(), 0);
        assertEquals(58, assessment3.getWaist(), 0);
    }

    @Test
    public void getHips() throws Exception {
        assertEquals(66, assessment1.getHips(), 0);
        assertEquals(67, assessment2.getHips(), 0);
        assertEquals(68, assessment3.getHips(), 0);
    }

    @Test
    public void getComment() throws Exception {
        assertEquals("didly good", assessment1.getComment());
        assertEquals("mmmmmm", assessment2.getComment());
        assertEquals("Well done", assessment3.getComment());
    }

    @Test
    public void getTrainer() throws Exception {
        assertEquals(NedFlanders, assessment1.getTrainer());
        assertEquals(MargeSimpson, assessment2.getTrainer());
        assertEquals(kerryKatone, assessment3.getTrainer());
    }

    @Test
    public void setWeight() throws Exception {
        assessment1.setWeight(16);
        assertEquals(17, assessment1.getWeight(), 0);
        assessment2.setWeight(17);
        assertEquals(18, assessment2.getWeight(), 0);
        assessment3.setWeight(18);
        assertEquals(19, assessment3.getWeight(), 0);
    }

    @Test
    public void setChest() throws Exception {
        assessment1.setChest(21);
        assertEquals(21, assessment1.getChest(), 0);
        assessment2.setChest(22);
        assertEquals(22, assessment2.getChest(), 0);
        assessment3.setChest(23);
        assertEquals(23, assessment3.getChest(), 0);
    }

    @Test
    public void setThigh() throws Exception {
        assessment1.setThigh(31);
        assertEquals(31, assessment1.getThigh(), 0);
        assessment2.setThigh(32);
        assertEquals(32, assessment2.getThigh(), 0);
        assessment3.setThigh(33);
        assertEquals(33, assessment3.getThigh(), 0);
    }

    @Test
    public void setUpperArm() throws Exception {
        assessment1.setUpperArm(41);
        assertEquals(41, assessment1.getUpperArm(), 0);
        assessment2.setUpperArm(42);
        assertEquals(42, assessment2.getUpperArm(), 0);
        assessment3.setUpperArm(43);
        assertEquals(43, assessment3.getUpperArm(), 0);
    }

    @Test
    public void setWaist() throws Exception {
        assessment1.setWaist(51);
        assertEquals(51, assessment1.getWaist(), 0);
        assessment2.setWaist(52);
        assertEquals(52, assessment2.getWaist(), 0);
        assessment3.setWaist(53);
        assertEquals(53, assessment3.getWaist(), 0);
    }

    @Test
    public void setHips() throws Exception {
        assessment1.setHips(61);
        assertEquals(61, assessment1.getHips(), 0);
        assessment2.setHips(62);
        assertEquals(62, assessment2.getHips(), 0);
        assessment3.setHips(63);
        assertEquals(63, assessment3.getHips(), 0);
    }

    @Test
    public void setComment() throws Exception {
        assessment1.setComment("test1");
        assertEquals("test1", assessment1.getComment());
        assessment2.setComment("test2");
        assertEquals("test2", assessment2.getComment());
        assessment3.setComment("test3");
        assertEquals("test3", assessment3.getComment());
    }

    @Test
    public void setTrainer() throws Exception {
        assessment1.setTrainer(NedFlanders);
        assertEquals(NedFlanders, assessment1.getTrainer());
        assessment2.setTrainer(MargeSimpson);
        assertEquals(MargeSimpson, assessment2.getTrainer());
        assessment3.setTrainer(MargeSimpson);
        assertEquals(kerryKatone, assessment3.getTrainer());
    }

    @Test
    public void testToString() throws Exception {

        assertEquals("WEIGHT.........17.0" + "\n" +
                "CHEST..........27.0" + "\n" +
                "THIGH..........37.0" + "\n" +
                "UPPER ARM......47.0" + "\n" +
                "WAIST..........57.0" + "\n" +
                "HIPS...........67.0" + "\n" +
                "COMMENT........diddlygood" + "\n" +
                "TRAINER........Ned Flanders\n", assessment1.toString());

        assertEquals("WEIGHT.........18.0" + "\n" +
                "CHEST..........28.0" + "\n" +
                "THIGH..........38.0" + "\n" +
                "UPPER ARM......48.0" + "\n" +
                "WAIST..........58.0" + "\n" +
                "HIPS...........68.0" + "\n" +
                "COMMENT........mmmmmm" + "\n" +
                "TRAINER........MargeSimspson\n", assessment2.toString());

        assertEquals("WEIGHT.........19.0" + "\n" +
                "CHEST..........29.0" + "\n" +
                "THIGH..........39.0" + "\n" +
                "UPPER ARM......49.0" + "\n" +
                "WAIST..........59.0" + "\n" +
                "HIPS...........69.0" + "\n" +
                "COMMENT........Well done" + "\n" +
                "TRAINER........kerryKatone\n", assessment3.toString());
    }

}
