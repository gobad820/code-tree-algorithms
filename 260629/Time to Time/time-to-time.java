import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());


        int start = a * 60 + b;
        int end = c * 60 + d;

        StringBuilder sb = new StringBuilder();
        sb.append(Math.abs(end - start));
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}