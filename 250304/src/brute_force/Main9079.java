package brute_force;
import java.io.*;
import java.util.*;

public class Main9079 {
	// 3x3 격자의 행, 열, 대각선을 뒤집는 비트마스크
    static final int[] FLIP_MASKS = {
    	// 첫 번째 행
    	0b111000000, 
    	// 두 번째 행
    	0b000111000, 
    	// 세 번째 행
    	0b000000111, 
    	// 첫 번째 열
    	0b100100100, 
    	// 두 번째 열
    	0b010010010, 
    	// 세 번째 열
    	0b001001001, 
    	// 왼쪽 위 ↘ 오른쪽 아래 대각선
    	0b100010001, 
    	// 오른쪽 위 ↙ 왼쪽 아래 대각선
    	0b001010100  
    };

    // BFS 탐색을 통해 최소 연산 횟수 찾기
    public static int bfs(int startState) {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        
        queue.add(startState);
        visited.put(startState, 0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int steps = visited.get(current);

            // 목표 상태(HHHHHHHHH 또는 TTTTTTTTT)에 도달하면 반환
            if (current == 0 || current == 0b111111111) return steps;

            for (int mask : FLIP_MASKS) {
            	// 비트마스킹으로 뒤집기
                int nextState = current ^ mask; 
                
                if (!visited.containsKey(nextState)) {
                    visited.put(nextState, steps + 1);
                    queue.add(nextState);
                }
            }
        }
        
        // 불가능한 경우
        return -1; 
    }

    // 입력을 받아서 3x3 격자를 9비트 정수로 변환
    public static int getInitialState(BufferedReader br) throws IOException {
        int state = 0;
        for (int i = 0; i < 3; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
            	// H는 0, T는 1
            	if (line[j].equals("T")) { 
                    state |= (1 << (i * 3 + j));
                }
            }
        }
        
        return state;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int initialState = getInitialState(br);
            System.out.println(bfs(initialState));
        }
    }
}
