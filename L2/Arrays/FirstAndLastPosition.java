package L2.Arrays;

/*34. Find First and Last Position of Element in Sorted Array
Medium
Topics
premium lock iconCompanies

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
    nums is a non-decreasing array.
    -109 <= target <= 109

*/ 

public class FirstAndLastPosition {
    
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
          int start=0,end=nums.length-1;
          
          int left =-1,right=-1;
          while (start<=end){
            int mid = start+(end-start)/2;
            if (nums[mid]==target) {
                left=mid;
                end=mid-1;
            }
            else if(target>nums[mid]) start=mid+1;
            else end=mid-1; 
          }
          start=0;
          end=nums.length-1;
          while (start<=end){
            int mid = start+(end-start)/2;
            if (nums[mid]==target) {
                right=mid;
                start=mid+1;
            }
            else if(target>nums[mid]) start=mid+1;
            else end=mid-1; 
          }
        
        return new int[]{left,right};
    }

}