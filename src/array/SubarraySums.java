/**
 * Date 10/09/2021
 * @author Brijoo Bopanna
 *
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that
 * array. For example, the array [1, 3, 7] has seven subarrays:
 * [ ]  [1]  [3]  [7]  [1, 3]  [3, 7]  [1, 3, 7]
 * The sum of an array is the sum of all the values in that array. Task is to write a
 * function that takes as input an array and outputs the sum of all of its subarrays.
 * Time complexity  O(n2)
 * Space complexity :O(1) 
 */

public class subArraySum {
  int calcSubArraySum(int [] arr)
  {
      int sum = 0, result = 0;
      int len = arr.length;
      for (int i = 0; i<len; i++)
      {
        result = 0;
        for(int j = i ;j< len; j++)
        {
          result += arr[j];
          sum += result;
        }

      }
      return sum;
  }
  public static void main (String args[])
  {
     int []arr= {1,3,7};
     subArraySum obj = new subArraySum();
     System.out.println(obj.calcSubArraySum(arr));
  }
}

