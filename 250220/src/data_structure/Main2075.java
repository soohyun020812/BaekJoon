package data_structure;
import java.io.*;
import java.util.*;

// 2075 N번째 큰 수 
public class Main2075 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                minHeap.add(num);
                // N개 초과 시 가장 작은 값 제거
                if (minHeap.size() > N) { 
                    minHeap.poll();
                }
            }
        }

        System.out.println(minHeap.poll()); 
    }
}
