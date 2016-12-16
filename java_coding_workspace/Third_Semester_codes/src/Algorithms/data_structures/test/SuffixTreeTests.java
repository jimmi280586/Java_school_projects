package data_structures.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data_structures.SuffixTree;
import data_structures.test.common.SuffixTreeTest;

@SuppressWarnings("static-method")
public class SuffixTreeTests {

    @Test
    public void testSuffixTree() {
        String bookkeeper = "bookkeeper";
        SuffixTree<String> tree = new SuffixTree<String>(bookkeeper);
        assertTrue(SuffixTreeTest.suffixTreeTest(tree, bookkeeper));
    }
}
