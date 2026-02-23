package L2.Strings;
public class LengthOfLastWord {
    
    
    public static void main(String[] args) {
        String s= "hello world   ";
        int wordLength=0;
        // int lastSeen=0;
        // for(char c :s.toCharArray()){
        //     if (c==' '){
        //         if (wordLength!=0 )lastSeen=wordLength;
        //         wordLength=0 ;
        //     }
        //     else wordLength=wordLength+1;
        // }
        // System.out.println(wordLength==0?lastSeen:wordLength);
        int i=s.length()-1;
        while(i>=0 && s.charAt(i)==' '){
            i--;
        }
        while(i>=0 && s.charAt(i)!=' '){
            wordLength++;
            i--;
        }
        System.out.println(wordLength);
    }
}

