package data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import data_structures.Queue;
import data_structures.test.common.JavaCollectionTest;
import data_structures.test.common.QueueTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class QueueTests {

    @Test
    public void testArrayQueue() {
        TestData data = Utils.generateTestData(100);

        String aName = "Queue [array]";
        Queue.ArrayQueue<Integer> aQueue = new Queue.ArrayQueue<Integer>();
        Collection<Integer> aCollection = aQueue.toCollection();

        assertTrue(QueueTest.testQueue(aQueue, aName,
                                       data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(aCollection, Type.Integer, aName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

    @Test
    public void testLinkedQueue() {
        TestData data = Utils.generateTestData(100);

        String lName = "Queue [linked]";
        Queue.LinkedQueue<Integer> lQueue = new Queue.LinkedQueue<Integer>();
        Collection<Integer> lCollection = lQueue.toCollection();

        assertTrue(QueueTest.testQueue(lQueue, lName,
                                       data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(lCollection, Type.Integer, lName,
                                                     data.unsorted, data.sorted, data.invalid));
    }
}
