import java.util.*;
import java.io.*;

public class Main {
    private static int [] days = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    private static Map<String, Integer> dayOfWeek = new HashMap<>();

    static {
        dayOfWeek.put("Mon",0);
        dayOfWeek.put("Tue",1);
        dayOfWeek.put("Wed",2);
        dayOfWeek.put("Thu",3);
        dayOfWeek.put("Fri",4);
        dayOfWeek.put("Sat",5);
        dayOfWeek.put("Sun",6);
    }
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int dayOfWeekIdx = dayOfWeek.get(st.nextToken());
        
        for(int i = 2 ; i <= 12 ; i++){
            days[i] += days[i-1];
        }
        
        int start = days[m1-1] + d1;
        int end = days[m2-1] + d2;
    
        int period = end - start + 7 * 53;
        int answer = (end - start) / 7;
        int remain = period % 7;
    
        if(remain >= dayOfWeekIdx){
            answer++;
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();

    }
}