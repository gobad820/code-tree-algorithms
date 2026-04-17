

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, testcase, answer, A, B, path[];
	static List<int[]>[] graph;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new int[] { v, w });
			graph[v].add(new int[] { u, w });

		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		dist[A] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.offer(new int[] { A, 0 });
		path = new int[N + 1];
		path[A] = -1;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int currNode = curr[0];
			int currDist = curr[1];
			if (currDist > dist[currNode]) {
				continue;
			}

			for (int[] next : graph[currNode]) {
				int nextNode = next[0];
				int nextWeight = next[1];

				if (dist[nextNode] > currDist + nextWeight) {
					dist[nextNode] = currDist + nextWeight;
					pq.offer(new int[] { nextNode, dist[nextNode] });
					path[nextNode] = currNode;
				}
			}
		}

		int temp = B;
		List<Integer> ans = new ArrayList<>();
		while (temp != -1) {
			ans.add(temp);

			temp = path[temp];
			
		}
		Collections.reverse(ans);
		sb.append(dist[B]).append("\n");
		for (int node : ans) {
			sb.append(node).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
