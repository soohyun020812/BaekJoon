package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 2485 가로수
public class Main2485 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 가로수의 개수 입력
        int N = Integer.parseInt(br.readLine());
        
        // 가로수 위치 입력
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        
        // 간격 계산
        int[] gaps = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            gaps[i] = positions[i + 1] - positions[i];
        }
        
        // 간격들의 최대공약수 구하기
        int gcdValue = gaps[0];
        for (int i = 1; i < gaps.length; i++) {
            gcdValue = gcd(gcdValue, gaps[i]);
        }
        
        // 필요한 추가 가로수 개수 계산
        int addCount = 0;
        for (int gap : gaps) {
            addCount += (gap / gcdValue) - 1;
        }
        
        System.out.println(addCount);
    }
    
    // 최대공약수를 계산하는 유클리드 호제법
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
