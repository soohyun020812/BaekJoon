package two_pointer;
import java.io.*;
import java.util.*;

// 22945 팀 빌딩
public class Main22945 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 개발자 수
        int N = Integer.parseInt(br.readLine()); 

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(maxTeamSkill(N, arr));
    }

    private static int maxTeamSkill(int N, int[] arr) {
        int left = 0, right = N - 1;
        int maxSkill = 0;

        while (left < right) {
            int gap = right - left - 1;
            int skill = gap * Math.min(arr[left], arr[right]);
            maxSkill = Math.max(maxSkill, skill);

            // 능력치가 낮은 쪽을 안쪽으로 이동
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxSkill;
    }
}
