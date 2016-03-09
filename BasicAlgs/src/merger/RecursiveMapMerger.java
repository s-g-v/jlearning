package merger;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RecursiveMapMerger {
	
	public static void main(String[] args){
		Map<Map<Map<String, String>, String>, String> map1 = new HashMap<>(); 
		map1.put(Collections.singletonMap(Collections.singletonMap("key1", "val1"), "vall1"), "value1");
		map1.put(Collections.singletonMap(Collections.singletonMap("key2", "val2"), "vall2"), "value2");
		map1.put(Collections.singletonMap(Collections.singletonMap("key3", "val3"), "vall3"), "value3");
//		map1.put(null, "value1");
		
		Map<Map<Map<String, String>, String>, String> map2 = new HashMap<>(); 
		map2.put(Collections.singletonMap(Collections.singletonMap("key1", "val4"), "vall7"), "value7");
		map2.put(Collections.singletonMap(Collections.singletonMap("key2", "val6"), "vall6"), "value8");
		map2.put(Collections.singletonMap(Collections.singletonMap("key3", "val7"), "vall8"), "value6");
		map2.put(Collections.singletonMap(Collections.singletonMap("key5", "val5"), "vall5"), "value5");
//		map2.put(null, "value1");
		
		Map<Map<Map<String, String>, String>, String> map3 = mergeMaps(map1, map2);
		System.out.println(map3.toString().replace(',', '\n'));
	}

	private static <K, V> K extractKey(K k) {		
		return (k instanceof Map<?, ?>) ? 
				extractKey(((Map<K,V>) k).keySet().iterator().next()) : k; 
	}

	private static <K, V> Map<K, V> mergeMaps(Map<K, V> m1, Map<K, V> m2){
		if ((m1 == null) || (m2 == null)) 
			throw new IllegalArgumentException("Map should not be null.");
		Set<K> firstMapKeys = new HashSet<>();
		Iterator<K> iterator = m1.keySet().iterator();
		while(iterator.hasNext()){
			firstMapKeys.add(extractKey(iterator.next()));
		}
		iterator = m2.keySet().iterator();
		while(iterator.hasNext()){
			K k = iterator.next();
			if (!firstMapKeys.contains(extractKey(k))) 
				m1.put(k, m2.get(k));
		}
		return m1;
	}
}
