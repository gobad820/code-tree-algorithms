import java.util.*;
import java.io.*;


public class Main {
    static int[] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static final int START_MON = 11;
    static final int START_D = 11;
    static final int START_H = 11;
    static final int START_M = 11;
    static final int DAY_TO_HOUR = 60*24;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 2 ; i <= 12; i++){
            days[i-1] += days[i];
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int startMinute = (START_D - 1) * DAY_TO_HOUR + (START_H - 1) * 60 + START_M;
        int endMinute = (a - 1 ) * DAY_TO_HOUR + (b - 1) * 60 + c;
        int answer = ((endMinute - startMinute) < 0) ? -1 : endMinute - startMinute;
        bw.write(answer + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}