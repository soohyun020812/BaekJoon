package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 9613 GCD 합 
public class Main9613 {
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
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 수의 개수
            int n = Integer.parseInt(st.nextToken()); 
            int[] numbers = new int[n];

            // 입력된 수 저장
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            // 모든 쌍의 GCD 합을 저장할 변수
            long sum = 0; 

            // 가능한 모든 두 수의 쌍을 선택하여 GCD 계산 후 합산
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += gcd(numbers[i], numbers[j]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}
