package two_pointer;
import java.io.*;
import java.util.*;

// 13144 List of Unique Numbers
public class Main13144 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countUniqueSubarrays(N, arr));
    }

    private static long countUniqueSubarrays(int N, int[] arr) {
        int left = 0, right = 0;
        long count = 0;
        HashSet<Integer> set = new HashSet<>();

        while (right < N) {
            // 중복이 없을 경우, 우측 포인터 확장
            while (right < N && !set.contains(arr[right])) {
                set.add(arr[right]);
                right++;
                // 경우의 수 추가
                count += (right - left); 
            }

            // 중복이 생겼다면 left를 이동시켜 중복 제거
            set.remove(arr[left]);
            left++;
        }

        return count;
    }
}
