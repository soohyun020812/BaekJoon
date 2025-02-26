package dfs;
import java.io.*;
import java.util.*;

// 10552 DOM
public class Main10552 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노인의 수
        int N = Integer.parseInt(st.nextToken()); 
        // 채널의 개수
        int M = Integer.parseInt(st.nextToken()); 
        // 초기 TV 채널
        int P = Integer.parseInt(st.nextToken()); 

        // 싫어하는 채널 (가장 어린 노인의 좋아하는 채널)
        Map<Integer, Integer> dislikes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 좋아하는 채널
            int favorite = Integer.parseInt(st.nextToken()); 
            // 싫어하는 채널
            int hate = Integer.parseInt(st.nextToken()); 

            // 가장 어린 노인이 싫어하는 채널이 처음 등장하면 저장
            if (!dislikes.containsKey(hate)) {
                dislikes.put(hate, favorite);
            }
        }

        // 현재 TV 채널
        int currentChannel = P; 
        // 채널 변경 횟수
        int changeCount = 0; 
        // 방문한 채널 (무한 루프 검출)
        Set<Integer> visitedChannels = new HashSet<>(); 

        // 현재 채널을 싫어하는 노인이 있다면
        while (dislikes.containsKey(currentChannel)) { 
        	// 이전에 방문한 적 있으면 무한 루프 발생
        	if (visitedChannels.contains(currentChannel)) { 
                
        		System.out.println(-1);
                return;
            }

        	// 방문한 채널 저장
        	visitedChannels.add(currentChannel); 
        	// 가장 어린 노인의 좋아하는 채널로 변경
        	currentChannel = dislikes.get(currentChannel); 
        	// 채널 변경 횟수 증가
        	changeCount++; 
        }

        System.out.println(changeCount);
    }
}
