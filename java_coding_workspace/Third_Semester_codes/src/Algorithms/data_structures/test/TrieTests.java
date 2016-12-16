package data_structures.test;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import data_structures.Trie;
import data_structures.test.common.JavaCollectionTest;
import data_structures.test.common.TreeTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class TrieTests {

    @Test
    public void testTrie() {
        TestData data = Utils.generateTestData(1000);

        String bstName = "Trie";
        Trie<String> bst = new Trie<String>();
        Collection<String> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Type.String, bstName,
                                     data.unsorted, data.invalid));
        assertTrue(JavaCollectionTest.testCollection(bstCollection, Type.String, bstName,
                                                     data.unsorted, data.sorted, data.invalid));
    }
}
