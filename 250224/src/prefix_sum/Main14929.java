package prefix_sum;
import java.io.*;
import java.util.*;

// 14929 귀찮아 (SIB)
public class Main14929 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값 n (배열의 크기)
        int n = Integer.parseInt(st.nextToken()); 
        // 전체 합(sumX)과 제곱의 합(sumX2) 변수 선언
        long sumX = 0, sumX2 = 0; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            
            // 전체 합을 저장
            sumX += x;
            // 각 숫자의 제곱 값을 누적 
            sumX2 += (long) x * x;
        }

        // 주어진 공식을 활용하여 결과 계산
        // S = (sumX^2 - sumX2) / 2
        long result = (sumX * sumX - sumX2) / 2;
        
        System.out.println(result);
    }
}
