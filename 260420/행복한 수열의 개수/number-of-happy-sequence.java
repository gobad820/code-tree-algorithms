import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, board[][];
    static StringTokenizer st;
    // static int[] rows, cols;
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
       
        board = new int[N][N];
        Map<Integer, Integer>[] rows, cols;
        rows = new Map[N];
        cols = new Map[N];
        for(int i = 0 ; i < N ; i++){
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
        }

        for(int y = 0 ; y < N ; y++ ){
            st = new StringTokenizer(br.readLine());
            for(int x = 0 ; x < N ; x++){
                board[y][x] = Integer.parseInt(st.nextToken());
                rows[y].merge(board[y][x], 1, Integer::sum);
            }
        }

        int answer = 0;
        if(M == 1){
           answer = (N * 2);

        }else{
                    for(int x = 0 ; x < N ; x++ ){
            for(int y = 0 ; y < N ; y++){
                cols[y].merge(board[y][x], 1, Integer::sum);
            }
        }


        for(int y = 0 ; y < N;  y++ ){
            for(int num = 1 ; num <= 100 ; num++ ){
                if(rows[y].getOrDefault(num,0) >= M) {
                    answer++;
                    continue;
                }
            }
            for(int num = 1 ; num <= 100 ; num++ ){
                if(cols[y].getOrDefault(num,0) >= M) {
                    answer++;
                    continue;
                }
            }
        }

   
        }
     bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
}