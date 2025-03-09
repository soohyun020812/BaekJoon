package greedy;
import java.io.*;

// 14916 거스름돈 
public class Main14916 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(minCoins(n));
    }

    private static int minCoins(int n) {
        int count = 0;

        while (n >= 0) {
        	// 5원으로 나누어 떨어질 경우
            if (n % 5 == 0) {  
                return count + (n / 5);
            }
            
            // 2원짜리 동전 하나 사용
            n -= 2;  
            // 동전 개수 증가
            count++; 
        }

        // 정확히 거슬러 줄 수 없는 경우
        return -1;  
    }
}
