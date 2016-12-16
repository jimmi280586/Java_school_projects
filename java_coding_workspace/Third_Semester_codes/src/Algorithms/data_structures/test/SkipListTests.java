package data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import data_structures.SkipList;
import data_structures.test.common.JavaCollectionTest;
import data_structures.test.common.SetTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class SkipListTests {

    @Test
    public void testSkipList() {
        TestData data = Utils.generateTestData(1000);

        String sName = "SkipList";
        SkipList<Integer> sList = new SkipList<Integer>();
        Collection<Integer> lCollection = sList.toCollection();

        assertTrue(SetTest.testSet(sList, sName,
                                   data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(lCollection, Type.Integer, sName,
                                                     data.unsorted, data.sorted, data.invalid));
    }
}
