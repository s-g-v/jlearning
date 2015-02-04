package cipher;

public class Vigenere {
	
	private String key = "keyword";
	
	public Vigenere(){
	}
	
	public static void main (String[] args){
		char[] alphabet = new char[26];
	  	for (int i=0; i< 26; i++) {
	  		alphabet[i] = (char)('a' + i);
	   	}
	  	System.out.println(alphabet);
	}
	
	public String encrypt(String value){
		return "";
	} 
}
