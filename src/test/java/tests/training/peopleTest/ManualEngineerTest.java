package tests.training.peopleTest;

import org.junit.Test;
import people.ManualEngineer;

import static org.junit.Assert.assertEquals;

public class ManualEngineerTest {

    ManualEngineer manualEngineer = new ManualEngineer(25, 3);

    @Test
    public void testAge()  {
        assertEquals("The age is not correct!", 25, manualEngineer.getAge());
    }
    @Test
    public void testSkill()  {
        assertEquals("The skill is not correct!", 6, manualEngineer.getSkill());
    }
    @Test
    public void testExperience()  {
        assertEquals("The experience is not correct!", 3, manualEngineer.getExperience());
    }
    @Test
    public void testSetAge()  {
        manualEngineer.setAge(30);
        assertEquals("The age is not correct!", 30, manualEngineer.getAge());
    }
    @Test
    public void testSetSkill()  {
        manualEngineer.setSkill(5);
        assertEquals("The skill is not correct!", 5, manualEngineer.getSkill());
    }
    @Test
    public void testSetExperience()  {
        manualEngineer.setExperience(5);
        assertEquals("The experience is not correct!", 5, manualEngineer.getExperience());
    }

}
