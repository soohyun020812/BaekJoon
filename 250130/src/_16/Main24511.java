package _16;
import java.io.*;
import java.util.*;

// 24511 queuestack 
public class Main24511 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // queuestack의 자료구조 개수 N
        int N = Integer.parseInt(br.readLine());

        // 각 자료구조가 queue(0)인지 stack(1)인지를 나타내는 배열
        int[] typeArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 자료구조 형태 입력 받기
        for (int i = 0; i < N; i++) {
            typeArr[i] = Integer.parseInt(st.nextToken());
        }

        // queue 자료구조의 초기 원소들을 저장할 덱 (Deque 사용)
        Deque<Integer> deque = new ArrayDeque<>();

        // 자료구조에 있는 원소 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (typeArr[i] == 0) {
                // queue인 경우만 덱에 추가 (queue에서만 의미가 있기 때문)
                deque.addLast(num);
            }
        }

        // queuestack에 삽입할 수열 길이 M
        int M = Integer.parseInt(br.readLine());

        // queuestack에 삽입할 원소들 입력받기
        st = new StringTokenizer(br.readLine());

        br.close();

        // 수열을 삽입하며 결과를 처리
        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());

            // 덱의 앞쪽에 원소 추가 (새로운 입력값)
            deque.addFirst(x);

            // 마지막 값을 가져와 결과에 추가 (queuestack 작동)
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
