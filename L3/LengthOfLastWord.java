public class LengthOfLastWord {
    
    
    public static void main(String[] args) {
        String s= "Hello world   ";
        int wordLength=0;
        int lastSeen=0;
        for(char c :s.toCharArray()){
            if (c==' '){
                if (wordLength!=0 )lastSeen=wordLength;
                wordLength=0 ;
            }
            else wordLength=wordLength+1;
        }
        System.out.println(wordLength==0?lastSeen:wordLength);
    }
}

