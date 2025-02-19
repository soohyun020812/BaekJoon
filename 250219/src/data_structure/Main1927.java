package data_structure;
import java.io.*;
import java.util.*;

// 1927 최소 힙 
public class Main1927 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        // 최소 힙
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
            	// 삭제 (poll) : O(log N)
                sb.append(minHeap.isEmpty() ? 0 : minHeap.poll()).append("\n");
            } else {
            	// 삽입 (offer) : O(log N)
                minHeap.offer(x);
            }
        }

        System.out.print(sb);
    }
}
