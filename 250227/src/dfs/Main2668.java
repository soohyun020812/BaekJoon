package dfs;
import java.io.*;
import java.util.*;

// 2668 숫자고르기 
public class Main2668 {
	static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 인덱스 1부터 사용
        arr = new int[N + 1]; 
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
        	// 둘째 줄 값 입력
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        // 사이클 찾기
        for (int i = 1; i <= N; i++) {
        	// 각 DFS 탐색에서 사용
            boolean[] cycleVisited = new boolean[N + 1]; 
            if (dfs(i, i, cycleVisited)) {
            	// 사이클이 있는 경우 결과 리스트에 추가
            	result.add(i); 
            }
        }

        Collections.sort(result);
        
        System.out.println(result.size());
        for (int num : result) {

        	System.out.println(num);
        }
    }

    // DFS를 이용한 사이클 탐색
    private static boolean dfs(int start, int current, boolean[] cycleVisited) {
        if (cycleVisited[current]) {
        	// 현재 방문한 노드가 시작점과 같으면 사이클 형성
            return current == start; 
        }

        // 현재 노드 방문 처리
        cycleVisited[current] = true; 
        // 다음 노드로 이동
        return dfs(start, arr[current], cycleVisited); 
    }
}
