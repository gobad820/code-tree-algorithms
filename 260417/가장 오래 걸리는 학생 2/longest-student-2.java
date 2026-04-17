

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, testcase, answer;
	static List<int[]>[] graph;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[v].add(new int[] { u, w });
		}

		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[N] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] { N, 0 });

		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDist = curr[1];

			if (currDist > dist[currNode]) {
				continue;
			}

			for (int[] next : graph[currNode]) {
				int nextWeight = next[1];
				int nextNode = next[0];

				if (dist[nextNode] > currDist + nextWeight) {
					dist[nextNode] = currDist + nextWeight;
					pq.offer(new int[] { nextNode, dist[nextNode] });
				}
			}
		}
		answer = -1;
		for (int i = 1; i < N; i++) {
			answer = dist[i] != Integer.MAX_VALUE ? Math.max(answer, dist[i]) : answer;
		}
		sb.append(answer);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
