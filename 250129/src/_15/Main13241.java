package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 13241 최소공배수
public class Main13241 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 한 줄로 입력된 두 숫자를 공백 기준으로 나눔
        String[] input = br.readLine().split(" ");
        // 첫 번째 정수
        long A = Long.parseLong(input[0]); 
        // 두 번째 정수
        long B = Long.parseLong(input[1]); 
        
        // 최소공배수 계산
        long lcm = lcm(A, B);
        
        System.out.println(lcm);
    }
    
    // 최대공약수를 계산하는 유클리드 호제법
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    // 최소공배수 계산
    private static long lcm(long a, long b) {
    	// (A * B) / GCD(A, B)로 계산
    	return (a / gcd(a, b)) * b; 
    }
}
