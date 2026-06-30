import java.util.*;
import java.io.*;


public class Main {
    static final int MIN_PER_DAY = 60 * 24;
    static final int MIN_PER_HOUR = 60;

    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int start = toMinutes(11, 11, 11);
        int end = toMinutes(a,b,c);
        int answer = (end < start) ? -1 : end - start;
        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int toMinutes(int day, int hour, int min){
        return (day-1) * MIN_PER_DAY + hour * MIN_PER_HOUR + min;
    }
}