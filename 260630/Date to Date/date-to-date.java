import java.io.*;
import java.util.*;

public class Main {
    static int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws IOException {
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

        int firstDates = days[m1-1] + d1;
        int secondDates = days[m2-1] + d2;

        bw.write((secondDates - firstDates + 1) +"");
        br.close();
        bw.flush();
        bw.close();
    }
}