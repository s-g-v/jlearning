package cipher;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VigenereTest extends Assert{
		

	@DataProvider
	public Object[][] prepareData(){
		return new Object[][]{
		{Alphabet.EN, "abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"},
		{Alphabet.EN, "keyword", "value to test."},
		{Alphabet.RU, "абвгдежзийклмнопрстуфхцчшщъыьэюя", "абвгдежзийклмнопрстуфхцчшщъыьэюя"},
		{Alphabet.RU, "ключ", "значение для проверки."}
		};
	}
	
	@Test(dataProvider = "prepareData")
	public void PositiveTest(Alphabet alphabet, String key, String value) {
		String sourceText = value;
		Vigenere cipher = new Vigenere(alphabet); 
		
		System.out.println("Encrypt...");
		String encryptedText = cipher.encrypt(key, value);
		System.out.println(value + " + " + key + " = " + encryptedText);
		
		System.out.println("Decrypt...");
		String result = cipher.decrypt(key, encryptedText);
		System.out.println(encryptedText + " + " + key + " = " + result);
		
		assertEquals(sourceText, result, "Source text and encrypted+decrypted text are different.");
	}
}
