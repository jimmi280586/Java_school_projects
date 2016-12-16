package data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import data_structures.BinarySearchTree;
import data_structures.SplayTree;
import data_structures.test.common.JavaCollectionTest;
import data_structures.test.common.TreeTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class SplayTreeTests {

    @Test
    public void testSplayTree() {
        TestData data = Utils.generateTestData(1000);

        String bstName = "Splay Tree";
        BinarySearchTree<Integer> bst = new SplayTree<Integer>();
        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Type.Integer, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, Type.Integer, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
    }

}
