import java.io.*;
import java.util.*;

public class Main {
    static List<int[]>[] graph;
    static int N,M,K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        // Please write your code here.
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        K = Integer.parseInt(br.readLine());

        graph = new List[N+1];
        for(int i = 0 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[] {v, w});
            graph[v].add(new int[]{u,w});
        }

        int [] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0]; // dist
        });

        pq.offer(new int[]{0,K});
        dist[K] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[1];
            int currDist = curr[0];

            if(currDist > dist[currNode]){
                continue;
            }

            for(int[] next : graph[currNode]){
                int nextNode = next[0];
                int nextWeight = next[1];

                if(dist[nextNode] > currDist + nextWeight){
                    dist[nextNode  ] = currDist + nextWeight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        for(int i = 1 ; i <= N ; i++){
            sb.append(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]  ).append("\n");
        }
        System.out.println(sb.toString());
    }
}