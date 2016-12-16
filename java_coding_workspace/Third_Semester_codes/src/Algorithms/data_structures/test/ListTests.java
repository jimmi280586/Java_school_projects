package data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import data_structures.List;
import data_structures.test.common.JavaCollectionTest;
import data_structures.test.common.ListTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class ListTests {

    @Test
    public void testArrayList() {
        TestData data = Utils.generateTestData(1000);

        String aName = "List [array]";
        List.ArrayList<Integer> aList = new List.ArrayList<Integer>();
        Collection<Integer> aCollection = aList.toCollection();

        assertTrue(ListTest.testList(aList, aName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollection, Type.Integer, aName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

    @Test
    public void testLinkedList() {
        TestData data = Utils.generateTestData(1000);

        String lName = "List [linked]";
        List.LinkedList<Integer> lList = new List.LinkedList<Integer>();
        Collection<Integer> lCollection = lList.toCollection();

        assertTrue(ListTest.testList(lList, lName,
                                      data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(lCollection, Type.Integer, lName,
                                                      data.unsorted, data.sorted, data.invalid));
    }
}
