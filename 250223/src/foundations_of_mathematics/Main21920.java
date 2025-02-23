package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 21920 서로소 평균 
public class Main21920 {
	// 최대공약수(GCD) 계산 
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수열의 크기
        int N = Integer.parseInt(br.readLine()); 
        int[] A = new int[N];

        // 수열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // X 입력
        int X = Integer.parseInt(br.readLine()); 

        // 서로소인 값들의 합과 개수 계산
        long sum = 0;
        int count = 0;

        for (int num : A) {
        	// 서로소인 경우만 선택
            if (gcd(num, X) == 1) { 
                sum += num;
                count++;
            }
        }

        // 평균 계산 
        System.out.printf("%.6f\n", (double) sum / count);
    }
}
