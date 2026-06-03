/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low=1,high=n;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(guess(mid)==0) return mid;
            else if (guess(mid)==-1) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }
}




// public class Solution {
//     public int guessNumber(int n) {
//         int start=1,end=n;
//         int num=n/2;
//         int pick=guess(num);
      
//         while(pick!=0){
//             if (pick==-1){
//                 num=num-start/2;
//                 pick=guess(num);
//             }else{
//                 num=end-num/2;
//                 pick=guess(num);
//             }
//         }
//         return num;
//     }
//     public int guess(int num){
//         int pick =9;

//         if (num>pick) return -1;
//         else if (num<pick) return 1;
//         else return 0;
//     }

//     public static void main(String[] args) {
//         Solution soln = new Solution();
//         System.out.println(soln.guessNumber(14));
//     }
// }