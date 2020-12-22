package org.geektrust.familytree.entity;

import org.junit.Assert;
import org.junit.Test;

public class FamilyTest {

    @Test
    public void testCreateFamilyMemberWithFirstPerson() {
        //when
        Family family = new Family( new Person("King Shan", Person.Gender.MALE) );
        family.weds( new Person("Queen Agna", Person.Gender.FEMALE) );

        //then
        Assert.assertNotNull(family);
        Assert.assertEquals("King Shan", family.getFirstPerson().getName());
        Assert.assertEquals("Queen Agna", family.getSpouse().getName());
        Assert.assertNull(family.getParentFamily());
        Assert.assertNotNull(family.getChildern());
        Assert.assertEquals(Person.Gender.MALE, family.getFirstPerson().getGender());
        Assert.assertEquals(Person.Gender.FEMALE, family.getSpouse().getGender());
    }

    @Test
    public void testEquateFamilies() {
        //when
        Family family1 = new Family( new Person("King Shan", Person.Gender.MALE),
                new Person("Queen Agna", Person.Gender.FEMALE) );

        Family family2 = new Family( new Person("King Shan", Person.Gender.MALE),
                new Person("Queen Agna", Person.Gender.FEMALE) );

        Family family3 = new Family( new Person("Chit", Person.Gender.MALE),
                new Person("Amba", Person.Gender.FEMALE) );

        //then
        Assert.assertTrue( family1.equals(family2) );
        Assert.assertFalse( family1.equals(family3) );
        Assert.assertTrue( family1.hashCode()==family2.hashCode() );
    }

    @Test
    public void testCreateFamilyWithFirstPersonAndSpouse() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        Person queenAgna = new Person("Queen Agna", Person.Gender.FEMALE);

        //when
        Family kingShanFamily = new Family(kingShan, queenAgna);

        //then
        Assert.assertNotNull(kingShanFamily);
        Assert.assertEquals(kingShan, kingShanFamily.getFirstPerson());
        Assert.assertEquals(queenAgna, kingShanFamily.getSpouse());
        Assert.assertNull(kingShanFamily.getParentFamily());
        Assert.assertNotNull(kingShanFamily.getChildern());
    }

    @Test
    public void testSetParentFamilyToNewFamily() {
        //given
        Family parentFamily = new Family( new Person("King Shan", Person.Gender.MALE),
                new Person("Queen Agna", Person.Gender.FEMALE) );

        Family childFamily = new Family( new Person("Chit", Person.Gender.MALE),
                new Person("Amba", Person.Gender.FEMALE) );

        //when
        childFamily.ancestorOf(parentFamily);

        //then
        Assert.assertNotNull(childFamily.getParentFamily());
        Assert.assertEquals(parentFamily, childFamily.getParentFamily());
    }

    @Test
    public void testIsFamilyMarried() {
        //when
        Family kingShanFamily = new Family( new Person("King Shan", Person.Gender.MALE) );
        kingShanFamily.weds( new Person("Queen Agna", Person.Gender.FEMALE) );
        Family chitFamily = new Family( new Person("Chit", Person.Gender.MALE) );

        //then
        Assert.assertTrue(kingShanFamily.isMarried());
        Assert.assertFalse(chitFamily.isMarried());
    }
}
