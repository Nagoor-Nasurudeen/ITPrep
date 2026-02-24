package L2.Strings;
import java.util.Arrays;
public class ValidAnagram {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.isAnagram("car","rac"));
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        int frequencyS[] =new int[26];
        int frequencyT[] =new int[26];
        int charInt;
        for (char c :s.toCharArray()){
            charInt=c-'a';
            if (frequencyS[charInt]==0) frequencyS[charInt]=1;
            else frequencyS[charInt]=frequencyS[charInt]+1;
        }
        for (char c :t.toCharArray()){
            charInt=c-'a';
            if (frequencyT[charInt]==0) frequencyT[charInt]=1;
            else frequencyT[charInt]=frequencyT[charInt]+1;
        }
        for(int i=0;i<26;i++){
        System.out.print(frequencyS[i]);
        
        System.out.print(frequencyT[i]);
        System.out.println();

        }
        
        return Arrays.equals(frequencyS,frequencyT);
    }

}