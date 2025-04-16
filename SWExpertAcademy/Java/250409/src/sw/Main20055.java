package sw;
import java.io.*;
import java.util.*;

// 20055 컨베이어 벨트 위의 로봇 
public class Main20055 {
	static int N, K;
    static int[] durability;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        durability = new int[2 * N];
        // 로봇은 0~N-1까지 존재 가능
        robot = new boolean[N]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int step = 0;
        while (true) {
            step++;

            // 1. 벨트와 로봇 회전
            rotateBelt();

            // 2. 로봇 이동
            moveRobot();

            // 3. 로봇 올리기
            placeRobot();

            // 4. 내구도 0 개수 체크
            if (countZeroDurability() >= K) break;
        }

        System.out.println(step);
    }

    // 벨트와 로봇을 함께 회전
    static void rotateBelt() {
        int last = durability[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            durability[i] = durability[i - 1];
        }
        durability[0] = last;

        // 로봇 위치 회전 (N-1은 내리는 위치라 비워야 함)
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        // 내리는 위치는 비워야 함
        robot[N - 1] = false; 
    }

    // 로봇 이동
    static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && durability[i + 1] > 0) {
                robot[i] = false;
                robot[i + 1] = true;
                durability[i + 1]--;
            }
        }
        // 내리는 위치면 내림
        robot[N - 1] = false; 
    }

    // 로봇 올리기
    static void placeRobot() {
        if (durability[0] > 0 && !robot[0]) {
            robot[0] = true;
            durability[0]--;
        }
    }

    // 내구도 0인 칸 수 카운트
    static int countZeroDurability() {
        int count = 0;
        for (int d : durability) {
            if (d == 0) count++;
        }
        return count;
    }
}
