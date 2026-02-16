package L2.Patterns;

public class Ex10 {
    static void printHalfDiamond(int n){
        int stars;
        for(int i=1;i<=2*n-1;i++){
            stars=i;
            if(i>n) stars=2*n-i;
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printHalfDiamond(5);

    }


    // public static void main(String[] args) {
    //     int n=5;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<i+1;j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    //     for(int i=n-1;i>0;i--){
    //         for(int j=0;j<i;j++){
    //             System.out.print("*");
    //         }
    //         System.out.println();
    //     }
    // }
    
}
