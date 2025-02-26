package dfs;
import java.io.*;
import java.util.*;

// 11403 경로 찾기 
public class Main11403 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점 개수
        int N = Integer.parseInt(br.readLine()); 
        int[][] graph = new int[N][N];

        // 인접 행렬 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Floyd-Warshall (플로이드-워셜) 알고리즘 수행
        // 경유점 k
        for (int k = 0; k < N; k++) { 
        	// 출발점 i
        	for (int i = 0; i < N; i++) { 
        		// 도착점 j
                for (int j = 0; j < N; j++) { 
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                    	// 경유지를 통해 도달 가능하면 1로 설정
                        graph[i][j] = 1; 
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
