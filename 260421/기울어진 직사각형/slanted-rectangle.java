import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
		lst = new List[N];
		for (int startX = 1; startX < N - 1; startX++) {
			lst[startX] = new ArrayList<>();
			answer = Math.max(answer, getMaximumValue(startX));
//			sb.append(lst[startX].toString()).append("\n\n");
		}

		sb.append(answer);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int getMaximumValue(int startX) {
		// TODO Auto-generated method stub
		int startY = 0;
		int firstY = startY, firstX = startX;

		int sum = 0;
		int idx = startX;
		boolean flag = false;
		// 좌하
		while (startY < N && startX >= 0) {
			startY++;
			startX--;

			if (startY >= N) {
				startY = N - 1;
				startX++;
				break;
			}
			if (startX < 0) {
				startX = 0;
				startY--;
				break;
			}
			sum += board[startY][startX];
			lst[idx].add(board[startY][startX]);
		}

		// 우하
		while (startY < N && startX < N) {
			startY++;
			startX++;

			if (startY >= N) {
				startY = N - 1;
				startX--;
				break;
			}
			if (startX >= N) {
				startX = N - 1;
				startY--;
				break;
			}
			sum += board[startY][startX];
			lst[idx].add(board[startY][startX]);

		}

		// 우상
		while (startY >= 0 && startX < N) {
			startY--;
			startX++;

			if (startY < 0) {
				startY = 0;
				startX--;
				break;
			}
			if (startX >= N) {
				startX = N - 1;
				startY++;
				break;
			}
			sum += board[startY][startX];
			lst[idx].add(board[startY][startX]);
		}
		// 좌상
		while (startY >= 0 && startX >= 0) {
			int tempY = startY--;
			int tempX = startX--;

			if (startY < 0) {
				startY = tempY;
				startX = tempX;
				break;
			}
			if (startX < 0) {
				startX = tempX;
				startY = tempY;
				break;
			}
			sum += board[startY][startX];
			lst[idx].add(board[startY][startX]);
		}
		return sum;
	}
}
