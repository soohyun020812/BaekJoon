package dfs;
import java.io.*;
import java.util.*;

public class Main11724 {
	static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점 개수
        int N = Integer.parseInt(st.nextToken()); 
        // 간선 개수
        int M = Integer.parseInt(st.nextToken()); 

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            // 무방향 그래프이므로 양쪽에 추가
            graph[v].add(u); 
        }

        int componentCount = 0;

        // 모든 정점에 대해 DFS 수행
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                // 새로운 연결 요소 발견
                componentCount++; 
            }
        }

        System.out.println(componentCount);
    }

    // DFS 탐색
    static void dfs(int node) {
        visited[node] = true;
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
