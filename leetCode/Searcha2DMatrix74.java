/**
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class Searcha2DMatrix74 {

    public static int binRowSearch(int [][]arr, int s,int e,int t){
        int ans =-1;
        if(s<=e){
            int m = (s+e)/2;
            System.out.println(s+" ,"+e+" ,"+m);
            if(t>= arr[m][0] && t<=arr[m][arr[m].length-1]){
                return m;
            }
            else if(t<arr[m][0]){
                return binRowSearch(arr,s,m-1,t);
            }
            else if(t>arr[m][arr[m].length-1]){
                return binRowSearch(arr,m+1,e,t);
            }
        }
        return ans;
    }

    public static int binColSearch(int []arr, int s,int e,int t){
        int ans =-1;
        if(s<=e){
            int m = (s+e)/2;
            System.out.println(s+" ,"+e+" ,"+m);
            if(t == arr[m]){
                return m;
            }
            else if(t<arr[m]){
                return binColSearch(arr,s,m-1,t);
            }
            else if(t>arr[m]){
                return binColSearch(arr,m+1,e,t);
            }
        }
        return ans;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int r = binRowSearch(matrix,0,matrix.length-1,target);
        if(r!=-1){
            int c = binColSearch(matrix[r],0,matrix[r].length-1,target);
            if(c!=-1){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1}};
        int target =2;
        System.out.println(searchMatrix(matrix,target));
    }
}
