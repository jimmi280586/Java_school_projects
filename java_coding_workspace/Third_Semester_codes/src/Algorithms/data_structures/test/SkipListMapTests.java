package data_structures.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import data_structures.SkipListMap;
import data_structures.test.common.JavaMapTest;
import data_structures.test.common.MapTest;
import data_structures.test.common.Utils;
import data_structures.test.common.Utils.TestData;
import data_structures.test.common.Utils.Type;

@SuppressWarnings("static-method")
public class SkipListMapTests {

    @Test
    public void testSkipListMap() {
        TestData data = Utils.generateTestData(1000);

        String mapName = "SkipListMap";
        SkipListMap<String,Integer> map = new SkipListMap<String,Integer>();
        java.util.Map<String,Integer> jMap = map.toMap();

        assertTrue(MapTest.testMap(map, Type.String, mapName,
                                   data.unsorted, data.invalid));
        assertTrue(JavaMapTest.testJavaMap(jMap, Type.Integer, mapName,
                                           data.unsorted, data.sorted, data.invalid));
    }

}
