package data_structure;
import java.io.*;
import java.util.*;

// 11286 절대값 힙 
public class Main11286 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 절댓값 기준 최소 힙, 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            // 절댓값이 같다면 원래 값 비교
            if (absA == absB) return Integer.compare(a, b); 
            // 절댓값이 작은 순서
            return Integer.compare(absA, absB); 
        });

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            // 출력 요청
            if (x == 0) { 
                if (pq.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            // 값 추가
            } else { 
                pq.add(x);
            }
        }

        System.out.print(sb);
    }
}
