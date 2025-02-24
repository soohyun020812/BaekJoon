package prefix_sum;
import java.io.*;
import java.util.*;

// 21318 피아노 체조 
public class Main21318 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 악보 개수 입력
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] mistakePrefix = new int[N + 1];

        // 난이도 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 실수 개수 전처리
        for (int i = 2; i <= N; i++) {
            mistakePrefix[i] = mistakePrefix[i - 1] + (A[i - 1] > A[i] ? 1 : 0);
        }

        // 질의 개수 입력
        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        // 질의 처리
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(mistakePrefix[y] - mistakePrefix[x]).append("\n");
        }

        System.out.print(sb);
    }
}
