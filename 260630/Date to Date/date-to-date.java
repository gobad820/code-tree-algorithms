import java.io.*;
import java.util.*;

public class Main {
    static int [] days = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [][] dates = new int[2][2];

        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                dates[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int firstDates = 0;
        for(int firstMonth = 1 ; firstMonth < dates[0][0] ; firstMonth++){
            firstDates += days[firstMonth];
        }firstDates += (dates[0][1]-1);

        int secondDates = 0;
        for(int m = 1 ; m < dates[1][0] ; m++){
            secondDates += days[m];
        }secondDates += dates[1][1];

        bw.write((secondDates - firstDates) +"");
        br.close();
        bw.flush();
        bw.close();
    }
}