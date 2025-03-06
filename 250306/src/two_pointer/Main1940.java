package two_pointer;
import java.io.*;
import java.util.*;

// 1940 주몽 
public class Main1940 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 재료 배열 입력
        int[] materials = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬 (O(N log N))
        Arrays.sort(materials);

        // 투 포인터 탐색 (O(N))
        int left = 0, right = N - 1, count = 0;

        while (left < right) {
            int sum = materials[left] + materials[right];

            // 갑옷을 만들 수 있는 경우
            if (sum == M) { 
                count++;
                left++;
                right--;
            // 합이 작으면 left를 증가
            } else if (sum < M) {  
                left++;
            // 합이 크면 right를 감소
            } else { 
                right--;
            }
        }

        System.out.println(count);
    }
}
