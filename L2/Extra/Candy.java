package L2.Extra;
public class Candy {
    static int sum(int[] arr){
        int sum=0;
        for(int i:arr) sum=sum+i;
        return sum;
    }
    static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] ratings ={2};
        int[] alloted=new int[ratings.length];

        for(int i=0;i<ratings.length;i++){
            alloted[i]=alloted[i]+1;
            if(i>0 && ratings[i-1]<ratings[i]){
                alloted[i]=alloted[i]+1;
            }
            if(i>0 && ratings[i-1]>ratings[i]){
                if (alloted[i-1]==alloted[i]){
                    alloted[i]=alloted[i]+1;
                }
            }
        }
        System.out.println(sum(alloted));
        printArray(alloted);

    }
}
