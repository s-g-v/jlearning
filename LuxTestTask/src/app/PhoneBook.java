package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

	private Map<String, List<String>> phones;
	
	public PhoneBook(){
		this.phones = new HashMap<String, List<String>>();
	}
	
	public void addNumber(String name, String phone) {
		if (!phones.containsKey(name)) {
			this.phones.put(name, new ArrayList<String> (Arrays.asList(phone)));			
		} else {
			phones.get(name).add(phone);
		}
	}

	public List<String> getListNumbers(String name) {
		List<String> result = new ArrayList<String>();
		if (!phones.containsKey(name)) {
			return new ArrayList<String> (Arrays.asList("Name not found."));
		}
		result.addAll(phones.get(name));
		return result;
	}
}
