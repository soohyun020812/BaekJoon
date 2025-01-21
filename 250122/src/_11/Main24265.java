package _11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 24265 알고리즘 수업 - 알고리즘의 수행 시간 4
public class Main24265 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 수행 횟수 계산
        long count = (long) n * (n - 1) / 2;
        
        // 코드1의 수행 횟수
        System.out.println(count); 
        // 최고차항 차수
        System.out.println(2);
    }
}
