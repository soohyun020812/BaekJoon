package greedy;
import java.io.*;
import java.util.*;

// 1931 회의실 배정 
public class Main1931 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 시작 시간
            meetings[i][0] = Integer.parseInt(st.nextToken()); 
            // 종료 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); 
        }

        // 종료 시간을 기준으로 정렬 
        // 같다면 시작 시간 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int count = 0;
        int lastEnd = 0;

        for (int[] meeting : meetings) {
        	// 시작 시간이 이전 회의의 끝난 시간 이후라면 선택
            if (meeting[0] >= lastEnd) { 
                count++;
                // 종료 시간 업데이트
                lastEnd = meeting[1]; 
            }
        }

        System.out.println(count);
    }
}
