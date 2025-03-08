package two_pointer;
import java.io.*;
import java.util.*;

// 22862 가장 긴 짝수 연속한 부분 수열 (large)
public class Main22862 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열의 길이
        int N = Integer.parseInt(st.nextToken()); 
        // 삭제할 수 있는 최대 횟수
        int K = Integer.parseInt(st.nextToken()); 

        int[] S = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMaxEvenSubarray(N, K, S));
    }

    private static int findMaxEvenSubarray(int N, int K, int[] S) {
        int left = 0, right = 0;
        int oddCount = 0, maxLen = 0;

        while (right < N) {
            // 현재 요소가 홀수라면 홀수 개수 증가
            if (S[right] % 2 != 0) {
                oddCount++;
            }

            // 홀수 개수가 K를 초과하면 left 포인터 이동
            while (oddCount > K) {
                if (S[left] % 2 != 0) {
                    oddCount--;
                }
                // left를 증가시켜 홀수 개수를 유지
                left++; 
            }

            // 현재 짝수 부분 수열의 길이 계산
            maxLen = Math.max(maxLen, right - left + 1 - oddCount);
            right++;
        }

        return maxLen;
    }
}
