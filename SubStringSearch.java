/*
Author: Brijesh Lal

Program to find a substring in a string using Rabin Karp algorithm.
*/

class RabinKarp{
    
    static int prime = 13;  //used to calculate hash value
    
    public void subsearch(String txt, String pat){
        
        char[] t = txt.toCharArray();
        char[] p = pat.toCharArray();
        int tlen = txt.length();
        int plen = pat.length();
        long pathash = createHash(p, plen);     //finding the hash value of the substring
        long texthash = 0;
        
        for(int i=0; i<=tlen-plen; i++){
        	if(i==0)
        		texthash = createHash(t,plen);
            if(texthash == pathash){
                if(compareLetters(p, t, i, plen))
                    System.out.println("Found at index " + i);
            }
            else
                texthash = rollingHash(texthash, t, i, plen);
        }
    }
    
    //finding the first hash value in the main string of substring size
    public long createHash(char[] c, int len){  
        long hashvalue = 0;

        for(int i=0; i<len; i++)
            hashvalue += c[i]*Math.pow(prime,i);

        return hashvalue;
    }
    
    //finding the hash value of next substring size in the main string by using the previous calculation of hash value
    public long rollingHash(long hash, char[] c, int index, int len){   
        long hashvalue = hash;
        hashvalue -= c[index];
        hashvalue /= prime;
        hashvalue += c[index+len]*Math.pow(prime,len-1);		

        return hashvalue;
    }
    
    //if the hash values match, check if the letters are same
    public boolean compareLetters(char[] p, char[] txt, int index, int len){
        for(int i=0; i<len; i++){
           if(p[i] != txt[index])
        	   return false;
           index++;
        }
        return true;
    }
}

public class SubStringSearch {
    public static void main(String args[]){
        String p = new String("cde");   //substring
        String t = new String("abcdefcde"); //main string

        RabinKarp rk = new RabinKarp();
        rk.subsearch(t,p);
    }
}
