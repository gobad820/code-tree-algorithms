import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n%2);
            n/=2;
        }
        System.out.println(sb.reverse().toString());
        sc.close();
    }
}