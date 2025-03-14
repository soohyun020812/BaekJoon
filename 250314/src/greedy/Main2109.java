package greedy;
import java.io.*;
import java.util.*;

// 2109 순회강연
public class Main2109 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 대학에서 요청한 강연 정보 저장 
        // 강연료 p, 기한 d
        List<int[]> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new int[]{p, d});
        }

        // 1. 강연료(p) 기준 내림차순 정렬 
        // 내림차순 정렬이므로 큰 강연료가 먼저 옴
        lectures.sort((a, b) -> b[0] - a[0]);

        // 2. 우선순위 큐를 사용하여 날짜별 강연 스케줄 관리
        // 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        // 최대 10,000일까지 존재 가능
        boolean[] booked = new boolean[10001]; 

        // 최종적으로 번 돈
        int totalEarned = 0; 

        for (int[] lecture : lectures) {
        	// 강연료
        	int pay = lecture[0]; 
        	// 강연 기한
        	int deadline = lecture[1]; 

            // 가능한 날짜 중 가장 늦은 날짜에 배정
            for (int day = deadline; day > 0; day--) {
            	// 비어있는 날짜라면
            	if (!booked[day]) { 
            		// 해당 날짜에 강연 배정
            		booked[day] = true; 
            		// 강연료 누적
            		totalEarned += pay; 
                    break;
                }
            }
        }
        
        System.out.println(totalEarned); 
    }
}
