import java.util.BitSet;
import java.util.Scanner;

public class JollyJumpers10038 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int [] arr = new int[n];
            boolean []cc = new boolean[n];
            for(int i =0;i<n;i++){
                arr[i]=in.nextInt();
                cc[i]=false;
            }
            for(int i=0;i<n-1;i++){
                int k = Math.abs(arr[i] - arr[i+1]);
                if(k<n && k>=0){
                    cc[k] = true;
                }
            }
            boolean c = true;
            for(int i=1;i<n;i++){
                if(!cc[i]){
                    c=false; break;
                }
            }
            if(c){
                System.out.println("Jolly");
            }else{
                System.out.println("Not jolly");
            }
        }

    }
}
