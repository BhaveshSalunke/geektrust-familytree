package org.geektrust.familytree.entity;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testCreatePersonWithGivenNameAndGender() {
        //when
        Person person = new Person("King Shan", Person.Gender.MALE);

        //then
        Assert.assertNotNull(person);
        Assert.assertEquals("King Shan", person.getName());
        Assert.assertEquals(Person.Gender.MALE, person.getGender());
    }

    @Test
    public void testEquatePersons() {
        //when
        Person person1 = new Person("name1", Person.Gender.MALE);
        Person person2 = new Person("name1", Person.Gender.MALE);
        Person person3 = new Person("name2", Person.Gender.FEMALE);

        //then
        Assert.assertTrue( person1.equals(person2) );
        Assert.assertFalse( person1.equals(person3) );
    }

}
