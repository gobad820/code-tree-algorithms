import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, testcase, answer, board[][];
	static List<Integer>[] lst;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];

		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				for (int width = 1; width < N; width++) {
					for (int height = 1; height < N; height++) {
						answer = Math.max(answer, goForSquare(y, x, height, width));
					}
				}
			}
		}

		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int goForSquare(int y, int x, int height, int width) {
		// 좌하로 이동
		int sum = 0;
		for (int i = 0; i < height; i++) {
			if (checkArrayIndexBounds(y, x)) {
				return -1;
			}
			sum += board[y][x];
			y++;
			x--;
		}

		for (int i = 0; i < width; i++) {
			if (checkArrayIndexBounds(y, x)) {
				return -1;
			}
			sum += board[y][x];
			y++;
			x++;
		}

		for (int i = 0; i < height; i++) {
			if (checkArrayIndexBounds(y, x)) {
				return -1;
			}
			sum += board[y][x];
			y--;
			x++;
		}
		for (int i = 0; i < width; i++) {
			if (checkArrayIndexBounds(y, x)) {
				return -1;
			}
			sum += board[y][x];
			y--;
			x--;
		}
		return sum;
	}

	private static boolean checkArrayIndexBounds(int y, int x) {
		return y >= N || x < 0 || y < 0 || x >= N;
	}

}
