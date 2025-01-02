package baekjoon;
import java.util.Scanner;

// 백준 문제 10869
public class Main10869 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        System.out.println(A+B);
        System.out.println(A-B);
        System.out.println(A*B);
        System.out.println(A/B);
        System.out.println(A%B);
        
        sc.close();
    }
}
