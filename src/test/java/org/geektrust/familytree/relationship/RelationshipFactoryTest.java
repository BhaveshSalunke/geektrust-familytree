package org.geektrust.familytree.relationship;

import org.geektrust.familytree.relationship.Impl.*;
import org.junit.Assert;
import org.junit.Test;

public class RelationshipFactoryTest {

    @Test
    public void testRelationshipFactoryToSingleton() {
        //when
        RelationshipFactory relationshipFactory1 = RelationshipFactory.getInstance();
        RelationshipFactory relationshipFactory2 = RelationshipFactory.getInstance();

        //then
        Assert.assertNotNull(relationshipFactory1);
        Assert.assertNotNull(relationshipFactory2);
        Assert.assertEquals(relationshipFactory1, relationshipFactory2);
    }

    @Test
    public void testGetRelationshipFromName() {
        //when
        RelationshipFactory relationshipFactory = RelationshipFactory.getInstance();

        //then
        Assert.assertTrue( relationshipFactory.getRelationship("Brother-In-Law") instanceof BrotherInLaws);
        Assert.assertTrue( relationshipFactory.getRelationship("Brother") instanceof Brothers );
        Assert.assertTrue( relationshipFactory.getRelationship("Daughter") instanceof Daughters);
        Assert.assertTrue( relationshipFactory.getRelationship("Maternal-Aunt") instanceof MaternalAunt);
        Assert.assertTrue( relationshipFactory.getRelationship("Maternal-Uncle") instanceof MaternalUncle);
        Assert.assertTrue( relationshipFactory.getRelationship("Paternal-Aunt") instanceof PaternalAunt );
        Assert.assertTrue( relationshipFactory.getRelationship("Paternal-Uncle") instanceof PaternalUncle );
        Assert.assertTrue( relationshipFactory.getRelationship("Siblings") instanceof Siblings );
        Assert.assertTrue( relationshipFactory.getRelationship("Sister-In-Law") instanceof SisterInLaws );
        Assert.assertTrue( relationshipFactory.getRelationship("Sister") instanceof Sisters );
        Assert.assertTrue( relationshipFactory.getRelationship("Son") instanceof Sons );
        Assert.assertNull( relationshipFactory.getRelationship("") );
    }
}
