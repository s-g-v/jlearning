package merger;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapMerger {
	
	public static void main(String[] args){
		Map<Map<String, String>, String> map1 = new HashMap<>(); 
		map1.put(Collections.singletonMap("key1", "val1"), "value1");
//		map1.put(null, "value1");
		map1.put(Collections.singletonMap("key2", "val2"), "value2");
		map1.put(Collections.singletonMap("key3", "val3"), "value3");
		
		Map<Map<String, String>, String> map2 = new HashMap<>(); 
		map2.put(Collections.singletonMap("key1", "val3"), "value3");
//		map2.put(null, "value3");
		map2.put(Collections.singletonMap("key2", "val1"), "value1");
		map2.put(Collections.singletonMap("key3", "val2"), "value2");
		map2.put(Collections.singletonMap("key5", "val5"), "value5");
		
		Map<Map<String, String>, String> map3 = mergeMaps(map1, map2);
		System.out.println(map3.toString().replace(',', '\n'));
	}
	
	private static <K, V, T> Map<Map<K, V>, T> mergeMaps(Map<Map<K, V>, T> m1, Map<Map<K, V>, T> m2){
		if ((m1 == null) || (m2 == null)) 
			throw new IllegalArgumentException("Map should not be null.");
		Set<K> firstMapKeys = new HashSet<>();
		for (Map<K, V> currentMap : m1.keySet()) {
			K innerKey = null;
			if (currentMap != null)	innerKey = currentMap.keySet().iterator().next();
			firstMapKeys.add(innerKey);
		}
		for (Map<K, V> currentMap : m2.keySet()) {
			K innerKey = null;
			if (currentMap != null)	innerKey = currentMap.keySet().iterator().next();
			if (!firstMapKeys.contains(innerKey)) m1.put(currentMap, m2.get(currentMap));
		}
		return m1;
	}
}
