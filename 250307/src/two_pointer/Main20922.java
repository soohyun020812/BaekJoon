package two_pointer;
import java.io.*;
import java.util.*;

// 20922 겹치는 건 싫어 
public class Main20922 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 및 빈도 저장용 맵
        // 원소 값 범위 : 1 ≤ a_i ≤ 100,000
        int[] count = new int[100001]; 
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < N) {
            int num = arr[right];
            count[num]++;

            // 특정 숫자의 개수가 K를 초과하면 left를 이동시켜 조정
            while (count[num] > K) {
                count[arr[left]]--;
                left++;
            }

            // 윈도우 크기 갱신
            maxLen = Math.max(maxLen, right - left + 1);
            // 오른쪽 포인터 이동
            right++; 
        }

        System.out.println(maxLen);
    }
}
