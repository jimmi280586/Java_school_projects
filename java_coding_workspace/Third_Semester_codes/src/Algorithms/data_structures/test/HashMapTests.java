package data_structures.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data_structures.HashMap;
import data_structures.test.common.JavaMapTest;
import data_structures.test.common.MapTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class HashMapTests {

    @Test
    public void testHashMap() {
        TestData data = Utils.generateTestData(1000);

        String mapName = "ProbingHashMap";
        HashMap<Integer,String> map = new HashMap<Integer,String>(HashMap.Type.PROBING);
        java.util.Map<Integer,String> jMap = map.toMap();

        assertTrue(MapTest.testMap(map, Type.Integer, mapName, data.unsorted, data.invalid));
        assertTrue(JavaMapTest.testJavaMap(jMap, Type.Integer, mapName, data.unsorted, data.sorted, data.invalid));

        mapName = "LinkingHashMap";
        map = new HashMap<Integer,String>(HashMap.Type.CHAINING);
        jMap = map.toMap();

        assertTrue(MapTest.testMap(map, Type.Integer, mapName, data.unsorted, data.invalid));
        assertTrue(JavaMapTest.testJavaMap(jMap, Type.Integer, mapName, data.unsorted, data.sorted, data.invalid));
    }
}
