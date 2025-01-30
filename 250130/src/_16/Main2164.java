package _16;
import java.io.*;
import java.util.*;

// 2164 카드2 
public class Main2164 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 큐 자료구조 사용
        // ArrayDeque를 활용하면 poll() 및 offer() 연산이 O(1)로 이루어져 빠름
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // 1부터 N까지 큐에 삽입
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
        	// 제일 위의 카드 버리기
        	queue.poll();
        	// 제일 위의 카드를 맨 뒤로 옮기기
            queue.offer(queue.poll()); 
        }

        // 마지막으로 남은 카드 출력
        System.out.println(queue.poll());
    }
}
