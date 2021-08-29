import java.util.HashSet;

/**
 * Date 10/08/2021
 * @author Brijoo Bopanna
 *
 * You are given an array of n integers and a number k. Determine whether there is a pair
 * of elements in the array that sums to exactly k. For example, given the array [1, 3, 7] and
 * k = 8, the answer is “yes,” but given k = 6 the answer is “no.”
 *
 * Time complexity  O(n)
 * Space complexity twoSumScanNonSort :O(n) twoSumScanSort :O(1)
 */

public class Twosum {
  public int[] twoSumScanNonSort(int [] srcArr, int k)
  {
    HashSet <Integer>h = new HashSet<Integer>();
    int []retArr = new int[2];
    for (int i =0;i<srcArr.length;i++)
    {
        if(h.contains(k-srcArr[i]))
        {
          retArr[0]=k-srcArr[i];
          retArr[1]=srcArr[i];
        }
        else
        {
          h.add(srcArr[i]);
        }
      }
    return retArr;
    }


  public int[] twoSumScanSort(int [] srcArr, int k)
  {
    int i=0, j = srcArr.length-1;
    int []retArr = new int[2];
    for (;i<j;)
    {
      if ((srcArr[i]+srcArr[j]) > k)
      {
        j--;
      }
      else if ((srcArr[i]+srcArr[j]) < k)
      {
        i++;
      }
      else if ((srcArr[i]+srcArr[j]) == k)
      {
        retArr[0]=srcArr[i];
        retArr[1]=k-srcArr[j];
      }
    }
    return retArr;

  }
  public static  void main(String args[])
  {
     int [] k = {1,7,8};
     Twosum obj = new Twosum();
     int []j= obj.twoSumScanNonSort(k,8);
     System.out.println("the 2 numbers are " +j[0] +j[1]);
    j= obj.twoSumScanNonSort(k,8);
    System.out.println("the 2 numbers are " +j[0] +j[1]);
  }
}
