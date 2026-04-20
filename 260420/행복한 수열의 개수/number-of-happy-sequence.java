

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
		Map<Integer, Integer>[] rows, cols;
		rows = new Map[N];
		cols = new Map[N];
		for (int i = 0; i < N; i++) {
			rows[i] = new HashMap<>();
			cols[i] = new HashMap<>();
		}

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
				rows[y].merge(board[y][x], 1, Integer::sum);
			}
		}

		int answer = 0;
		if (M == 1) {
			answer = (N * 2);
		} else {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					cols[x].merge(board[y][x], 1, Integer::sum);
				}
			}

			for (int y = 0; y < N; y++) {
                boolean isHappy = false;
                for(int x = 1 ; x <= N - M + 1 ; x++){
                    int i = 0;
                    for(; i < M-1 ; i++){
                        if(board[y][x+i-1] != board[y][x+i]){
                            // isHappy = false;
                            break;
                        }
                    }
                    if(i == M-1) {
                        answer++;
                        break;
                    }    
                }

                isHappy = false;
                for(int x = 1 ; x <= N - M + 1 ; x++){
                    int i = 0;
                    for(; i < M -1; i++){
                        if(board[x+i-1][y] != board[x+i][y]){
                            // isHappy = false;
                            break;
                        }
                    }
                    if(i == M-1) {
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
