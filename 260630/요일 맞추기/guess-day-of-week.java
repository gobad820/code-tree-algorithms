import java.io.*;
import java.util.*;

public class Main {
    static int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    static final String[] DAY_NAMES = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
    static final int NEGATIVE_BUFFER = 7 * 53;
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        for(int i = 2 ; i <= 12 ; i++){
            days[i] += days[i-1];
        }
        
        int start = days[m1-1] + d1;
        int end = days[m2-1] + d2;

        int periodDates = end - start + NEGATIVE_BUFFER;
        String answer = DAY_NAMES[(periodDates % 7)];
        bw.write(answer);
        bw.flush();
        bw.close();
        br.close();

    }
}