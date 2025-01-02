package baekjoon;
import java.util.Scanner;

// 백준 문제 10430
public class Main10430 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        System.out.println((A+B)%C);
        System.out.println(((A%C) + (B%C))%C);
        System.out.println((A*B)%C);
        System.out.println(((A%C)*(B%C))%C);
        
        // Scanner 닫기
        sc.close();
	}
}
