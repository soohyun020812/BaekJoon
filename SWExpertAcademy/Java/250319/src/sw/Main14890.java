package sw;
import java.io.*;
import java.util.*;

// 경사로 
public class Main14890 {
	static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        // 행 검사
        for (int i = 0; i < N; i++) {
            if (checkPath(map[i])) count++;
        }
        // 열 검사
        for (int j = 0; j < N; j++) {
            int[] col = new int[N];
            for (int i = 0; i < N; i++) {
                col[i] = map[i][j];
            }
            if (checkPath(col)) count++;
        }

        System.out.println(count);
    }

    static boolean checkPath(int[] line) {
    	// 경사로 설치 여부
        boolean[] used = new boolean[N]; 

        for (int i = 0; i < N - 1; i++) {
        	// 높이가 같으면 패스
            if (line[i] == line[i + 1]) continue; 

            // 높이 차이가 2 이상이면 불가능
            if (Math.abs(line[i] - line[i + 1]) > 1) return false; 

            // 오르막 (높이가 증가)
            if (line[i] < line[i + 1]) { 
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || line[i - j] != line[i] || used[i - j]) return false;
                    used[i - j] = true;
                }
            // 내리막 (높이가 감소)
            } else { 
                for (int j = 0; j < L; j++) {
                    if (i + 1 + j >= N || line[i + 1 + j] != line[i + 1] || used[i + 1 + j]) return false;
                    used[i + 1 + j] = true;
                }
            }
        }

        return true;
    }
}
