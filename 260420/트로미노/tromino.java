import java.util.*;
import java.io.*;


public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N,M,board[][];
	static StringTokenizer st ;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		for(int y = 0 ; y < N ; y++	){
			st = new StringTokenizer(br.readLine());
			for(int x = 0 ; x < N ; x++){
				board[y][x]  = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;

		// shape 1 iteration
		for(int y = 0 ; y < N ; y++){
			for(int x = 0 ; x < N-1;  x++){
				int sum0 = (x+1 >= N || y-1 < 0 ) ? 0 : board[y][x] + board[y][x+1] + board[y-1][x];
				int sum1 = (x-1 < 0 || y-1 < 0 ) ? 0 : board[y][x] + board[y][x-1] + board[y-1][x];
				int sum2 = (x+1 >= N || y+1 >= N) ? 0 : board[y][x] + board[y][x+1] + board[y+1][x];
				int sum3 = (x-1 < 0 || y+1 >= N) ? 0 : board[y][x] + board[y][x-1] + board[y+1][x];
				answer = Math.max(sum0, Math.max(sum1, Math.max(sum2, Math.max(answer, sum3))));
			}
		}

		for(int y = 0 ; y < N ; y++){
			for(int x = 0 ; x < N; x++){
				int sum0 = (x-1 < 0 || x+1 >= N) ? 0 : board[y][x-1] + board[y][x] + board[y][x+1];
				int sum1 = (y-1 < 0 || y+1 >= N) ? 0 : board[y-1][x] + board[y][x] + board[y+1][x];
				answer = Math.max(sum0, Math.max(sum1, answer));
			}
		}

		System.out.println(answer);
    }
}