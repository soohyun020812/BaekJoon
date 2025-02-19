package data_structure;
import java.io.*;
import java.util.*;

// 11279 최대 힙 
public class Main11279 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 최대 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
            	// 삭제 (poll) : O(log N)
                sb.append(maxHeap.isEmpty() ? 0 : maxHeap.poll()).append("\n");
            } else {
            	// 삽입 (offer) : O(log N)
                maxHeap.offer(x);
            }
        }

        System.out.print(sb);
    }
}
