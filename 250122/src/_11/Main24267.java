package _11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 24267 알고리즘 수업 - 알고리즘의 수행 시간 6
public class Main24267 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        // 수행 횟수 계산 : n(n-1)(n-2) / 6
        long count = n * (n - 1) * (n - 2) / 6;
        
        // 코드1의 수행 횟수
        System.out.println(count); 
        // 최고차항 차수
        System.out.println(3);
    }
}
