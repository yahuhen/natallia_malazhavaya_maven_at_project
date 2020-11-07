package tests.training.peopleTest;

import org.junit.Test;

import tests.training.people.AutomatedEngineer;

import static org.junit.Assert.assertEquals;

public class AutomatedEngineerTess {
    AutomatedEngineer automatedEngineer = new AutomatedEngineer(25, 3);

    @Test
    public void testAAge()  {
        assertEquals("The age is not correct!", 25, automatedEngineer.getAge());
    }
    @Test
    public void testSkill()  {
        assertEquals("The skill is not correct!", 9, automatedEngineer.getSkill());
    }
    @Test
    public void testExperience()  {
        assertEquals("The experience is not correct!", 3, automatedEngineer.getExperience());
    }
    @Test
    public void testSetAge()  {
        automatedEngineer.setAge(30);
        assertEquals("The age is not correct!", 30, automatedEngineer.getAge());
    }
    @Test
    public void testSetSkill()  {
        automatedEngineer.setSkill(5);
        assertEquals("The skill is not correct!", 5, automatedEngineer.getSkill());
    }
    @Test
    public void testSetExperience()  {
        automatedEngineer.setExperience(5);
        assertEquals("The experience is not correct!", 5, automatedEngineer.getExperience());
    }

}
