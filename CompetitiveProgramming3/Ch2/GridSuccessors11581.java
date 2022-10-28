import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridSuccessors11581 {

    public static int[][] func(int[][] org) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                temp[i][j]
                int sum = 0;
                if (i - 1 >= 0) {
                    sum += org[i - 1][j];
                }
                if (i + 1 < 3) {
                    sum += org[i + 1][j];
                }

                if (j - 1 >= 0) {
                    sum += org[i][j - 1];
                }
                if (j + 1 < 3) {
                    sum += org[i][j + 1];
                }

                temp[i][j] = sum % 2;
            }
        }
        return temp;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(isr);

        String input = in.readLine();
        int n = Integer.parseInt(input);

        for (int i = 0; i < n; i++) {
            int[][] arr = new int[3][3];
            in.readLine();
            for (int j = 0; j < 3; j++) {
                String ii = in.readLine();

                arr[j][0] = Integer.parseInt(String.valueOf(ii.charAt(0)));
                arr[j][1] = Integer.parseInt(String.valueOf(ii.charAt(1)));
                arr[j][2] = Integer.parseInt(String.valueOf(ii.charAt(2)));
            }

            int k = 0;
            while (true) {
                boolean c = true;

                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
//                        System.out.print(arr[l][m] + " ");
                        if(arr[l][m] != 0){
                            c = false;
                            break;
                        }

                    }
//                    System.out.println("");
                }
//                System.out.println("k = " + k+" c = " + c );
                if(c) break;
                arr = func(arr);
                k++;
            }
            System.out.println((k-1));

        }

    }
}
