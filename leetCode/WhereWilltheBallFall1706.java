public class WhereWilltheBallFall1706 {
    public int[] findBall(int[][] grid) {
        int [] arr = new int[grid[0].length];
        int lb= grid[0].length;
        for(int k= 0;k<grid[0].length;k++) {
            System.out.println("####################c: "+k);
            int r=0;
            int c=k;
            for (int i = 0; i < grid.length; i++) {

                if (grid[r][c] == 1) {
                    System.out.println("Right");
                    if (c + 1 >= lb || grid[r][c + 1] == -1) {
                        System.out.println("c: "+c+": -1");
                        arr[k]=-1;
                        break;
                    }
                    r++;
                    c++;
                    System.out.println("r = " + r + " c=" + c);
                } else if (grid[r][c] == -1) {
                    System.out.println("Left");
                    if (c - 1 < 0 || grid[r][c - 1] == 1) {
                        System.out.println("c: "+c+": -1");
                        arr[k]=-1;
                        break;
                    }
                    r++;
                    c--;
                    System.out.println("r = " + r + " c=" + c);
                }
                if (r >= grid.length) {
                    System.out.println("c: "+c+": 1");
                    arr[k] = c;
                    break;
                }

            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        [[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1],[1,1,1,1,1,1],[-1,-1,-1,-1,-1,-1]]

        int[][] mat = {{1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1},
                {1,1,1,1,1,1},
                {-1,-1,-1,-1,-1,-1}};

        WhereWilltheBallFall1706 obj = new WhereWilltheBallFall1706();
        int arr [] = obj.findBall(mat);
        for(int a:arr) System.out.print(" " + a);

    }
}
