package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 13909 창문 닫기 
public class Main13909 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 창문 개수 N
        int N = Integer.parseInt(br.readLine());
        
        // N 이하의 완전 제곱수의 개수를 구하기 위해
        // sqrt(N)의 정수 부분을 구하면 된다.
        int result = (int) Math.sqrt(N);
        
        System.out.println(result);
    }
}
