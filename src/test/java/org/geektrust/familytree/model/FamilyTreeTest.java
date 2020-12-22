package org.geektrust.familytree.model;

import org.geektrust.familytree.entity.Family;
import org.geektrust.familytree.entity.Person;
import org.junit.Assert;
import org.junit.Test;

public class FamilyTreeTest {

    @Test
    public void testCreateFamilyTreeWithHeadFamily() {
        //given
        Person husband = new Person("King Shan", Person.Gender.MALE);
        Person wife = new Person("Queen Agna", Person.Gender.FEMALE);
        Family family = new Family(husband, wife);

        //when
        FamilyTree familyTree = new FamilyTree(family);

        //then
        Assert.assertNotNull(familyTree);
        Assert.assertEquals(family, familyTree.getHead());
    }

    @Test
    public void testFindFamilyByFirstPersonName() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        Person queenAgna = new Person("Queen Agna", Person.Gender.FEMALE);
        Person chit = new Person("Chit", Person.Gender.MALE);
        Person amba = new Person("Amba", Person.Gender.FEMALE);

        Family kingShanFamily = new Family(kingShan, queenAgna);
        Family chitFamily = new Family(chit, amba);

        chitFamily.ancestorOf(kingShanFamily);
        kingShanFamily.getChildern().add(chitFamily);

        FamilyTree familyTree = new FamilyTree( kingShanFamily );

        //when
        Family searchResultKingShan = familyTree.findFamilyByPersonName("King Shan");
        Family searchResultAmba = familyTree.findFamilyByPersonName("Amba");
        Family searchResultAmit = familyTree.findFamilyByPersonName("Amit");

        //then
        Assert.assertNotNull(searchResultKingShan);
        Assert.assertNotNull(searchResultAmba);
        Assert.assertNull(searchResultAmit);
        Assert.assertEquals(kingShanFamily, searchResultKingShan);
        Assert.assertEquals(chitFamily,  searchResultAmba);
    }

    @Test
    public void testFindPersonByName() {
        //given
        Person kingShan = new Person("King Shan", Person.Gender.MALE);
        Person queenAgna = new Person("Queen Agna", Person.Gender.FEMALE);
        Person chit = new Person("Chit", Person.Gender.MALE);
        Person amba = new Person("Amba", Person.Gender.FEMALE);

        Family kingShanFamily = new Family(kingShan, queenAgna);
        Family chitFamily = new Family(chit, amba);

        chitFamily.ancestorOf(kingShanFamily);
        kingShanFamily.getChildern().add(chitFamily);

        FamilyTree familyTree = new FamilyTree( kingShanFamily );

        //when
        Person searchResultChit = familyTree.findPersonByName("Chit");
        Person searchResultAmba = familyTree.findPersonByName("Amba");
        Person searchResultAmit = familyTree.findPersonByName("Amit");

        //then
        Assert.assertNotNull(searchResultChit);
        Assert.assertNotNull(searchResultAmba);
        Assert.assertNull(searchResultAmit);
        Assert.assertEquals(chit, searchResultChit);
        Assert.assertEquals(amba, searchResultAmba);
    }


}
