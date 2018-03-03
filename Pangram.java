/*
Author: Brijesh Lal

Program to find if a string contains all 26 letters.
*/

public class Pangram{
	public static boolean pangram(String s){

		char[] ch = s.toLowerCase().toCharArray();
		char[] b = new char[256];

		//getting a count of letters
		for(char c:ch){
			if(b[c]==0)
				b[c]++;
		}

		//count of all letters should be greater than 0
		for(char c='a'; c<'z'; c++){
			if(b[c]==0)
				return false;
		}
		return true;
	}

	public static void main(String args[]){
		String str = new String("The quick brown fox jumps over the lazy dog");
		System.out.println(pangram(str));	//returns boolean value
	}
}