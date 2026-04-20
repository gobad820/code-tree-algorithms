import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int answer = 0;

        for(int y = 0 ; y < n - 2 ; y++ ){
            for(int x = 0 ; x < n - 2 ; x++){
                int tempSum = 0;
                for(int row = y ; row < y + 3 ; row++){
                    for(int col = x ; col < x + 3;  col++){
                        tempSum += (grid[row][col] == 1 ? 1 : 0 );
                    }
                }
                answer=  Math.max(answer , tempSum);
            }
        }
        // Please write your code here.
        System.out.println(answer);
    }
}