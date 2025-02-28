package bfs;
import java.io.*;
import java.util.*;

// 2644 촌수계산 
public class Main2644 {
	static int n, start, target, m;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수 입력
        n = Integer.parseInt(br.readLine());

        // 촌수를 계산할 두 사람 입력
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        // 관계 개수 입력
        m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 부모 - 자식 관계 저장 (양방향)
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        // BFS 실행하여 촌수 계산
        int result = bfs();
        System.out.println(result);
    }

    // BFS로 촌수 찾기
    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n + 1];

        // 시작점 추가 (현재 노드, 촌수)
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            // 현재 사람 번호
            int person = current[0]; 
            // 현재 촌수
            int depth = current[1];  

            // 목표한 사람을 찾으면 촌수 반환
            if (person == target) {
                return depth;
            }

            // 연결된 사람 탐색 (부모 - 자식 관계)
            for (int next : graph[person]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, depth + 1});
                }
            }
        }

        // 촌수를 찾을 수 없는 경우
        return -1;
    }
}
