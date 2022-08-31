import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotatedSquare10855 {


    public static char [][] rotateSquare(char [][] org){
        char [][] temp = new char[org.length][org.length];
        for(int i=0;i<org.length;i++){
            for(int j=org[i].length-1;j>=0;j--){
//                System.out.println("i : j " + j+" "+i);
//                System.out.print(" " + org[j][i]);
                temp[i][(org[i].length-1)-j] = org[j][i];
//                System.out.println("ni : nj " + i+" "+ ((org[i].length-1)-j) );
            }
//            System.out.println("");
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        while (true) {
            String[] vals = in.readLine().split(" ");
            int a = Integer.parseInt(vals[0]), b = Integer.parseInt(vals[1]);
            if (a == 0) break;

            String[] arr = new String[a];
            for (int i = 0; i < a; i++) {
                arr[i] = in.readLine();
            }

            char[][] small = new char[b][b];

            for (int i = 0; i < b; i++) {
                String str = in.readLine();
                small[i] = str.toCharArray(); // to char array is O(n)
            }


            int[] count = new int[4];

            for (int sq = 0; sq < 4; sq++) {
                count[sq]=0;

                for (int i = 0; i <= a - b; i++) {
//                    System.out.println("i = " + i);
                    for (int j = 0; j <= a - b; j++) {
//                        System.out.println("j = " + j);
                        String s = arr[i].substring(j, j + b);
                        boolean c = false;
                        if (s.contains(new String(small[0]))) {
//                            System.out.println("s = " + s);
                            c = b == 1;
                            for (int k = 1; k < b; k++) {
                                String sub = arr[i + k].substring(j, j + b);
                                if (sub.contains(new String(small[k]))) {
//                                    System.out.println("sub = " + sub);
                                    c = true;
                                } else {
                                    c = false;
                                    break;
                                }
                            }

                        }
                        if (c) {
                            count[sq] += 1;
//                            System.out.println("sq = "+sq+ "count = " + count[sq]);
                        }
                    }
                }
                small = rotateSquare(small);
//                System.out.println("End of rotate: "+sq);
            }
            for(int k=0;k<count.length;k++){
                System.out.print(count[k]);
                if(k<count.length-1) System.out.print(" ");
            }
            System.out.println("");
        }
//        System.out.println("");
    }
}
