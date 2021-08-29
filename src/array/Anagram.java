import java.util.Arrays;
/**
 * Date 03/08/2021
 * @author Brijoo Bopanna
 *
 * Two strings are said to be anagrams of one another if you can turn the first string into
 * the second by rearranging its letters. For example, “table” and “bleat” are anagrams, as
 * are “tear” and “rate.” Your job is to write a function that takes in two strings as input and
 * determines whether they're anagrams of one another
 *
 * Time complexity areAnagrams1 : O(nlogn) areAnagrams2 : O(n)
 * Space complexity O(n)
 */

public class Anagram {
  Anagram()   {}

  boolean isAnagram(String src, String Dest)
  {
    int srcLen = src.length();
    int desLen = Dest.length();
    int i , j = 0;
    int CntArray[]= new int[100] ;
    if (srcLen != desLen) return false;
    if ((srcLen == 0) || (desLen == 0) ) return  false;
    if (src.equals(Dest)) return true;
    for (i = 0; i<srcLen; i++)
    {
      CntArray[src.charAt(i)-'A']++;
    }
    for (j = 0; j<desLen; j++)
    {
      if (CntArray[Dest.charAt(j)-'A'] == 0) return false;
      CntArray[Dest.charAt(j)-'A']--;
    }
    if (j == desLen) return true;
    return false;
  }

   boolean areAnagrams1(String first, String second) {
     char[] one = first.toCharArray();
     char[] two = second.toCharArray();
     Arrays.sort(one);
    Arrays.sort(two);
    return Arrays.equals(one, two);
  }

   boolean areAnagrams2(String first, String second) {
    if (first.length() != second.length()) return false;
    int[] frequencies = new int[100];
    for (int i = 0; i < first.length(); i++) {
      frequencies[first.charAt(i)-'A']++;
    }
    for (int i = 0; i < second.length(); i++) {
      if (frequencies[second.charAt(i)-'A'] == 0) return false;
      frequencies[second.charAt(i)-'A']--;
    }
    return true;
  }

  public static void main(String args[])
  {
    Anagram obj = new Anagram();
    String src = new String("tbBle");
    String dest = new String("Blebt");
    if (obj.isAnagram(src,dest))
      System.out.println("Anagram");
   if (obj.areAnagrams1(src,dest))
      System.out.println("Anagram1");
    if (obj.areAnagrams2(src,dest))
      System.out.println("Anagram2");
  }
}
