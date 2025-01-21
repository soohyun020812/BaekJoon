package _11;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 24264 알고리즘 수업 - 알고리즘의 수행 시간 3
public class Main24264 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 코드1의 수행 횟수
        System.out.println((long) n * n);
        // 최고차항 차수
        System.out.println(2);
    }
}
