package greedy;
import java.io.*;
import java.util.*;

// 13975 파일 합치기 3
public class Main13975 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 빠른 입력 처리
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); 

        for (int tc = 0; tc < T; tc++) {
        	// 파일 개수
            int N = Integer.parseInt(br.readLine()); 
            st = new StringTokenizer(br.readLine(), " ");

            // 최소 힙 (우선순위 큐) 선언
            // 파일 크기가 작은 순서대로 정렬됨
            PriorityQueue<Long> pq = new PriorityQueue<>();

            // 파일 크기를 우선순위 큐에 추가
            for (int i = 0; i < N; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            // 최소 비용을 저장할 변수
            long totalCost = 0; 

            // 파일이 하나만 남을 때까지 반복 
            // 파일을 합치는 과정
            while (pq.size() > 1) {
            	// 가장 작은 파일
                long file1 = pq.poll(); 
                // 두 번째로 작은 파일
                long file2 = pq.poll(); 
                // 두 파일을 합치는 비용
                long mergeCost = file1 + file2; 

                // 비용 누적
                totalCost += mergeCost; 
                // 합친 파일을 다시 큐에 추가
                pq.offer(mergeCost); 
            }

            System.out.println(totalCost); 
        }
    }
}
