

//SearchInsertPosition
//LC #35

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low =0, high =nums.length-1;
        int mid=-1;
        while(low<=high){
            mid=low+(high-low)/2;
            if (nums[mid]== target ) return mid;
            else if (nums[mid]>target) high=mid-1;
            else low= mid+1;
        }
        return low;
    }
    public static void main(String[] args) {
        SearchInsertPosition s =new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5)); //output 2
    }
}

// 35. Search Insert Position
// Given a sorted array of distinct integers and a target value, return the index if the target is found.
//  If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4

 

// Constraints:

//     1 <= nums.length <= 104
//     -104 <= nums[i] <= 104
//     nums contains distinct values sorted in ascending order.
//     -104 <= target <= 104

