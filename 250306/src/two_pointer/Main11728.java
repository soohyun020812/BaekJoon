package two_pointer;
import java.io.*;
import java.util.*;

// 배열 합치기 
public class Main11728 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        // 배열 A 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 투 포인터 병합 정렬 수행
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (A[i] <= B[j]) sb.append(A[i++]).append(" ");
            else sb.append(B[j++]).append(" ");
        }

        // A 배열의 남은 요소 추가
        while (i < N) sb.append(A[i++]).append(" ");

        // B 배열의 남은 요소 추가
        while (j < M) sb.append(B[j++]).append(" ");

        System.out.println(sb.toString());
    }
}
