import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N, M, board[][];
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][N];
		
		

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			
			}
		}

		int answer = 0;
		if (M == 1) {
			answer = (N * 2);
		} else {
			for(int y = 0 ; y <  N ; y++){
				int cnt = 1;
				for(int x = 1 ; x < N ; x++){
					cnt = (board[y][x-1] == board[y][x] ? cnt + 1 : 1);
					if(cnt >= M) {
						answer++;
						break;
					}
				}
			}
			for(int x = 0 ; x < N ; x++){
				int cnt = 1;
				for(int y = 1 ; y < N ; y++){
					cnt = board[y-1][x] == board[y][x] ? cnt + 1  :1 ;
					if(cnt >= M) {
						answer++;
						break;
					}
				}
			}
		}
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
