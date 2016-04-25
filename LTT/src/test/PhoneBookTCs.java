package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import app.PhoneBook;

public class PhoneBookTCs {

	@Test
	public void SingleNumberTC() {
		PhoneBook pbUnderTest = new PhoneBook();
		String name = "Firstname Lastname";
		String phone = "+79110001122";
		pbUnderTest.addNumber(name, phone);
		assertEquals(pbUnderTest.getListNumbers(name).get(0),phone);
	}

	@Test
	public void ListNumbersTC() {
		PhoneBook pbUnderTest = new PhoneBook();
		String name = "Firstname Lastname";
		List<String> phones = new ArrayList<String>();
		phones.add("+79110001122");
		phones.add("+79110001133");
		for (String phone:phones) {
			pbUnderTest.addNumber(name, phone);
		}
		assertEquals(pbUnderTest.getListNumbers(name),phones);
	}

	@Test
	public void ListNamesTC() {
		PhoneBook pbUnderTest = new PhoneBook();
		String name1 = "Firstperson Name";
		String phone1 = "+79110001111";
		String name2 = "Secondperson Name";
		String phone2 = "+79110002222";
		pbUnderTest.addNumber(name1, phone1);
		pbUnderTest.addNumber(name2, phone2);
		pbUnderTest.getListNumbers(name1).remove(0);
		assertEquals(pbUnderTest.getListNumbers(name1).get(0),phone1);
		assertEquals(pbUnderTest.getListNumbers(name2).get(0),phone2);
	}
	
	@Test
	public void NameNotFoundTC() {
		PhoneBook pbUnderTest = new PhoneBook();
		String name = "Firstname Lastname";		
		assertEquals(pbUnderTest.getListNumbers(name).get(0),"Name not found.");		
	}

	@Test
	public void PhoneNotFoundTC() {
		PhoneBook pbUnderTest = new PhoneBook();
		String name = "Firstname Lastname";		
		String phone1 = "+79110001111";
		String phone2 = "+79110002222";
		pbUnderTest.addNumber(name, phone1);
		assertFalse(pbUnderTest.getListNumbers(name).contains(phone2));		
	}
}
