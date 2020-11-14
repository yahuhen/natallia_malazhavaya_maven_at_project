package tests.training.peopleTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import people.AutomatedEngineer;
import people.Engineer;
import people.ManualEngineer;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CommonEngineerTest {
    private Engineer en;
    private int expSkill;

    public CommonEngineerTest(Engineer en, int expSkill) {
        this.en = en;
        this.expSkill = expSkill;
    }
@Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(
                new Object[][] {
                        { new AutomatedEngineer(25,3), 9},
                        {new ManualEngineer(25,3), 6}
                }
        );
    }
    @Test
    public void testAAge()  {
        assertEquals("The age is not correct!", 25, en.getAge());
    }
    @Test
    public void testSkill()  {
        assertEquals("The skill is not correct!", 9, en.getSkill());
    }
    @Test
    public void testExperience()  {
        assertEquals("The experience is not correct!", 3, en.getExperience());
    }
    @Test
    public void testSetAge()  {
        en.setAge(30);
        assertEquals("The age is not correct!", 30, en.getAge());
    }
    @Test
    public void testSetSkill()  {
        en.setSkill(5);
        assertEquals("The skill is not correct!", 5, en.getSkill());
    }
    @Test
    public void testSetExperience()  {
        en.setExperience(5);
        assertEquals("The experience is not correct!", 5, en.getExperience());
    }

}
