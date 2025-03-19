package sw;
import java.io.*;
import java.util.*;

// 14889 스타트와 링크 
public class Main14889 {
	static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        selected = new boolean[N];

        // 능력치 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 백트래킹 시작
        backtrack(0, 0);
        
        System.out.println(minDiff);
    }

    static void backtrack(int index, int count) {
        // 팀이 완성되었을 때 능력치 차이 계산
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = index; i < N; i++) {
            if (!selected[i]) {
                selected[i] = true;
                backtrack(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int startTeam = 0, linkTeam = 0;

        // 두 팀으로 나누어 능력치 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (selected[i] && selected[j]) startTeam += S[i][j];
                else if (!selected[i] && !selected[j]) linkTeam += S[i][j];
            }
        }

        // 최소 차이 갱신
        minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
    }
}
