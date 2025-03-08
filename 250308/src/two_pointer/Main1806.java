package two_pointer;
import java.io.*;
import java.util.*;

// 1806 부분합
public class Main1806 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수열 길이
        int N = Integer.parseInt(st.nextToken()); 
        // 목표 부분합
        int S = Integer.parseInt(st.nextToken()); 

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findMinSubarrayLength(N, S, arr));
    }

    private static int findMinSubarrayLength(int N, int S, int[] arr) {
        int left = 0, right = 0, sum = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < N) {
            sum += arr[right];

            // 조건 만족 시 최소 길이 갱신
            while (sum >= S) {  
                minLength = Math.min(minLength, right - left + 1);
                // left를 이동하여 새로운 구간 탐색
                sum -= arr[left]; 
                left++;
            }
            
            right++;
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
