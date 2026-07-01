import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        String num = sc.next();

        System.out.println(Integer.toString(Integer.parseInt(num, from), to));
        sc.close();
    }
}