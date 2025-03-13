package greedy;
import java.io.*;
import java.util.*;

// 19598 최소 회의실 개수 
public class Main19598 {
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

        // 회의 시작 시간을 기준으로 정렬
        // 시작 시간이 같다면 종료 시간 기준 정렬
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // 최소 힙
        // 현재 진행 중인 회의의 종료 시간을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] meeting : meetings) {
            if (!pq.isEmpty() && pq.peek() <= meeting[0]) {
            	// 기존 회의실 재사용
            	// 종료된 회의 제거
            	pq.poll(); 
            }
            // 새로운 회의 추가
            pq.add(meeting[1]); 
        }

        // 필요한 최소 회의실 개수
        System.out.println(pq.size()); 
    }
}
