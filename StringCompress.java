/*
Author: Brijesh Lal

Program to compress a string with the count of consecutive letters
*/

public class StringCompress{

	static String compress(String s){
		StringBuilder result = new StringBuilder();
		int count = 0;

		for(int i=0; i<s.length(); i++){
			count++;

			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1)){
				result.append(s.charAt(i));
				result.append(count);
				count=0;	//resetting the counter for new letter
			}
		}
		return new String(result.toString());
	}

	public static void main(String args[]){
		String a = new String("abbcdddd");
		System.out.println(compress(a));	//Output: a1b2c1d4
	}
}