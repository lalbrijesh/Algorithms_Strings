/*
Author: Brijesh Lal

Program to find whether one string is a permutation of the other string
*/

public class StringPermutation{

	static boolean isPerm(String a, String b){
		int[] set = new int[265];
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();

		if(a.length()!=b.length())	//cannot be same if length is different
			return false;
		else{
			for(char c: ac)	//count of letters in first string
				set[c]++;

			for(char h: bc){ //checking with the count of second string
				set[h]--;
				if(set[h]<0)
					return false;
	    	}
		return true;
	    }
    }

	public static void main(String args[]){
		String a = new String("abcda");
		String b = new String("aacbd");

		System.out.println(isPerm(a,b));
	}
}