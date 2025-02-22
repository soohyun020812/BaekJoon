package foundations_of_mathematics;
import java.util.*;

// 2609 최대공약수와 최소공배수 
public class Main2609 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // 최대공약수 구하기
        int gcd = getGCD(a, b); 
        // 최소공배수 구하기
        int lcm = (a * b) / gcd; 
        
        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 유클리드 호제법을 이용한 최대공약수(GCD) 구하기
    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}
