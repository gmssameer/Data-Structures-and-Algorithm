import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int down = matrix.length-1, right = matrix[0].length-1;
        int top =0, left = 0;
        while (true) {
//            System.out.println("#########");
//            System.out.println("top = " + top);
//            System.out.println("down = " + down);
//            System.out.println("left = " + left);
//            System.out.println("right = " + right);

            // UP
            System.out.println("UP");
            for (int i = left; i <= right; i++) {
                System.out.println("i = " + matrix[top][i]);
                list.add(matrix[top][i]);
            }
            top++;
            if(left > right || top > down) break;

            // Right
            System.out.println("Right");
            for (int i = top; i <= down; i++) {
                System.out.println("i = " + matrix[i][right]);
                list.add(matrix[i][right]);
            }
            right--;
            if(left > right || top > down) break;
            // Down
            System.out.println("Down");
            for (int i = right; i >= left; i--) {
                System.out.println("i = " + matrix[down][i]);
                list.add(matrix[down][i]);
            }
            down --;
            if(left > right || top > down) break;
            //Left
            System.out.println("Left");
            for (int i = down ; i >= top; i--) {
                System.out.println("i = " + matrix[i][left]);
                list.add(matrix[i][left]);

            }
            left++;
            if(left > right || top > down) break;
        }

        return list;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        spiralOrder(mat);
    }
}
