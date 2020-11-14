package tests.training.peopleTest;

import org.junit.Test;
import people.Person;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testPersonAge()  {
        Person person = new Person(25);
        assertEquals("The age is not correct!", 25, person.getAge());
    }
    @Test
    public void testPersonSetAge()  {
        Person person = new Person(25);
        person.setAge(26);
        assertEquals("The age is not correct!", 26, person.getAge());
    }
    @Test
    public void testPersonDoubleAge()  {
        Person person = new Person(2*20);
        assertEquals("The age is not correct!", 40, person.getAge());
    }

    @Test
    public void testDemo()  {
        assertThat("bugagaha", both(containsString("bu")).and(containsString("ga")));
//        boolean check = false;
//        String s = "bugagaha";
//        String s1 = "bu";
//        String s2 = "ga";
//        if (s.contains(s1) && s.contains(s2)) {
//            check = true;
//        }
//        assertEquals("Wrong!", true, check);
    }
}
