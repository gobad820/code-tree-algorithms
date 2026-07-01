import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        System.out.println(Integer.toString(Integer.parseInt(sc.next(), 2) * 17, 2));
        sc.close();
    }
}