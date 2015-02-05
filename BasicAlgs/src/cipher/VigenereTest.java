package cipher;

public class VigenereTest {

	public static void main (String[] args){
		String key = "key";
		String value = "value to test";
		System.out.println("Encrypt...");
		String result = Vigenere.encrypt(key, value);
		System.out.println(value + " + " + key + " = " + result);
		System.out.println("Decrypt...");
		value = result;
		result = Vigenere.decrypt(key, value);
		System.out.println(value + " + " + key + " = " + result);
	}
	

}
