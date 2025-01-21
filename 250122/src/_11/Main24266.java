package _11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 24266 알고리즘 수업 - 알고리즘의 수행 시간 5
public class Main24266 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        // 수행 횟수 계산
        long count = n * n * n;
        
        // 코드1의 수행 횟수
        System.out.println(count); 
        // 최고차항 차수
        System.out.println(3);
    }
}
