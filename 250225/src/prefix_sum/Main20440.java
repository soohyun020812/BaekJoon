package prefix_sum;
import java.io.*;
import java.util.*;

// 20440 🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1
public class Main20440 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 모기의 개수
        int N = Integer.parseInt(br.readLine()); 

        Map<Integer, Integer> eventMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int enter = Integer.parseInt(st.nextToken());
            int exit = Integer.parseInt(st.nextToken());
            
            // 입장 시 +1
            eventMap.put(enter, eventMap.getOrDefault(enter, 0) + 1); 
            // 퇴장 시 -1
            eventMap.put(exit, eventMap.getOrDefault(exit, 0) - 1); 
        }

        // 키(시간)를 오름차순 정렬
        List<Integer> timePoints = new ArrayList<>(eventMap.keySet());
        timePoints.sort(Integer::compareTo);

        int maxMosquitoes = 0, currentMosquitoes = 0;
        int startTime = 0, endTime = 0;
        boolean isMaxPeriodOpen = false;

        // Sweeping (스위핑 알고리즘)
        // currentMosquitoes 값을 누적하면서 최대 모기 개수(maxMosquitoes) 갱신
        // 최대 구간이 시작되면 startTime 저장, 끝나는 순간 endTime 저장
        
        // 시각 기준으로 정렬, 시각이 같으면 퇴장이 먼저
        for (int time : timePoints) {
            currentMosquitoes += eventMap.get(time);

            // 최대 모기 수 갱신
            if (currentMosquitoes > maxMosquitoes) { 
                maxMosquitoes = currentMosquitoes;
                startTime = time;
                isMaxPeriodOpen = true;
            // 최대 모기 구간 종료
            } else if (currentMosquitoes < maxMosquitoes && isMaxPeriodOpen) { 
                endTime = time;
                isMaxPeriodOpen = false;
            }
        }

        System.out.println(maxMosquitoes);
        System.out.println(startTime + " " + endTime);
    }
}
