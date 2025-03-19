package sw;
import java.io.*;
import java.util.*;

// 14891 톱니바퀴 
public class Main14891 {
	@SuppressWarnings("unchecked")
	static Deque<Integer>[] gears = new Deque[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 4개의 톱니바퀴 입력 저장
        for (int i = 0; i < 4; i++) {
            gears[i] = new LinkedList<>();
            String line = br.readLine();
            for (char ch : line.toCharArray()) {
            	// 0 or 1로 변환하여 저장
            	gears[i].add(ch - '0'); 
            }
        }

        // 회전 횟수 입력
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 인덱스화
            int num = Integer.parseInt(st.nextToken()) - 1; 
            int dir = Integer.parseInt(st.nextToken());

            rotateGears(num, dir);
        }

        // 점수 계산
        int score = 0;
        int[] scores = {1, 2, 4, 8};
        for (int i = 0; i < 4; i++) {
            if (gears[i].peekFirst() == 1) score += scores[i];
        }

        System.out.println(score);
    }

    // 톱니바퀴 회전
    static void rotateGears(int num, int dir) {
        int[] directions = new int[4];
        // 현재 톱니바퀴 회전 방향 설정
        directions[num] = dir; 

        // 왼쪽 톱니 회전 여부 체크
        for (int i = num; i > 0; i--) {
            if (gears[i].toArray()[6] != gears[i - 1].toArray()[2]) {
                directions[i - 1] = -directions[i];
            } else break;
        }

        // 오른쪽 톱니 회전 여부 체크
        for (int i = num; i < 3; i++) {
            if (gears[i].toArray()[2] != gears[i + 1].toArray()[6]) {
                directions[i + 1] = -directions[i];
            } else break;
        }

        // 톱니 회전 적용
        for (int i = 0; i < 4; i++) {
            if (directions[i] == 1) rotateClockwise(i);
            else if (directions[i] == -1) rotateCounterClockwise(i);
        }
    }

    // 시계 방향 회전
    static void rotateClockwise(int idx) {
        gears[idx].addFirst(gears[idx].removeLast());
    }

    // 반시계 방향 회전
    static void rotateCounterClockwise(int idx) {
        gears[idx].addLast(gears[idx].removeFirst());
    }
}
