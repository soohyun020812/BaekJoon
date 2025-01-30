package _16;
import java.io.*;
import java.util.*;

// 2346 풍선 터뜨리기 
public class Main2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 풍선 개수 입력
        int N = Integer.parseInt(br.readLine()); 
        // 풍선 내부 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        // 배열 기반 리스트 (Deque 대신 ArrayList를 사용하여 직접 이동)
        List<int[]> balloons = new ArrayList<>(N); 
        for (int i = 0; i < N; i++) {
            balloons.add(new int[]{i + 1, Integer.parseInt(st.nextToken())});
        }

        // 현재 터뜨릴 풍선 위치
        int index = 0; 
        while (!balloons.isEmpty()) {
        	// 풍선 터뜨리기
            int[] balloon = balloons.remove(index); 
            // 터진 풍선 번호 저장
            sb.append(balloon[0]).append(" "); 
            
            // 풍선이 모두 터졌다면 종료
            if (balloons.isEmpty()) break; 
            
            // 이동할 거리
            int move = balloon[1]; 
            if (move > 0) {
            	// 오른쪽 이동
                index = (index + move - 1) % balloons.size(); 
            } else {
            	// 왼쪽 이동
                index = (index + move) % balloons.size(); 
                // 음수 인덱스 처리
                if (index < 0) index += balloons.size(); 
            }
        }

        System.out.println(sb); 
    }
}
